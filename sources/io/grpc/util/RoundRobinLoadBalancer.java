package io.grpc.util;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class RoundRobinLoadBalancer extends LoadBalancer {
    private static final Status EMPTY_OK = Status.OK.withDescription("no subchannels ready");
    @VisibleForTesting
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    static final Attributes.Key<Ref<LoadBalancer.Subchannel>> STICKY_REF = Attributes.Key.create("sticky-ref");
    private RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;
    private final Random random;
    @Nullable
    private StickinessState stickinessState;
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();

    RoundRobinLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
        this.random = new Random();
    }

    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        String stickinessMetadataKeyFromServiceConfig;
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        Attributes attributes = resolvedAddresses.getAttributes();
        Set<EquivalentAddressGroup> keySet = this.subchannels.keySet();
        Set<EquivalentAddressGroup> stripAttrs = stripAttrs(addresses);
        Set<T> set = setsDifference(stripAttrs, keySet);
        Set<T> set2 = setsDifference(keySet, stripAttrs);
        Map map = (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG);
        if (!(map == null || (stickinessMetadataKeyFromServiceConfig = ServiceConfigUtil.getStickinessMetadataKeyFromServiceConfig(map)) == null)) {
            if (stickinessMetadataKeyFromServiceConfig.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.WARNING, "Binary stickiness header is not supported. The header \"{0}\" will be ignored", stickinessMetadataKeyFromServiceConfig);
            } else {
                StickinessState stickinessState2 = this.stickinessState;
                if (stickinessState2 == null || !stickinessState2.key.name().equals(stickinessMetadataKeyFromServiceConfig)) {
                    this.stickinessState = new StickinessState(stickinessMetadataKeyFromServiceConfig);
                }
            }
        }
        for (T t : set) {
            Attributes.Builder builder = Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE)));
            Ref ref = null;
            if (this.stickinessState != null) {
                Attributes.Key<Ref<LoadBalancer.Subchannel>> key = STICKY_REF;
                Ref ref2 = new Ref(null);
                builder.set(key, ref2);
                ref = ref2;
            }
            T t2 = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel((EquivalentAddressGroup) t, builder.build()), "subchannel");
            if (ref != null) {
                ref.value = t2;
            }
            this.subchannels.put(t, t2);
            t2.requestConnection();
        }
        ArrayList arrayList = new ArrayList();
        for (T remove : set2) {
            arrayList.add(this.subchannels.remove(remove));
        }
        updateBalancingState();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            shutdownSubchannel((LoadBalancer.Subchannel) it.next());
        }
    }

    public void handleNameResolutionError(Status status) {
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        RoundRobinPicker roundRobinPicker = this.currentPicker;
        if (!(roundRobinPicker instanceof ReadyPicker)) {
            roundRobinPicker = new EmptyPicker(status);
        }
        updateBalancingState(connectivityState, roundRobinPicker);
    }

    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        StickinessState stickinessState2;
        if (this.subchannels.get(subchannel.getAddresses()) == subchannel) {
            if (connectivityStateInfo.getState() == ConnectivityState.SHUTDOWN && (stickinessState2 = this.stickinessState) != null) {
                stickinessState2.remove(subchannel);
            }
            if (connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                subchannel.requestConnection();
            }
            getSubchannelStateInfoRef(subchannel).value = connectivityStateInfo;
            updateBalancingState();
        }
    }

    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
        StickinessState stickinessState2 = this.stickinessState;
        if (stickinessState2 != null) {
            stickinessState2.remove(subchannel);
        }
    }

    public void shutdown() {
        for (LoadBalancer.Subchannel shutdownSubchannel : getSubchannels()) {
            shutdownSubchannel(shutdownSubchannel);
        }
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> filterNonFailingSubchannels = filterNonFailingSubchannels(getSubchannels());
        if (filterNonFailingSubchannels.isEmpty()) {
            boolean z = false;
            Status status = EMPTY_OK;
            for (LoadBalancer.Subchannel subchannelStateInfoRef : getSubchannels()) {
                ConnectivityStateInfo connectivityStateInfo = (ConnectivityStateInfo) getSubchannelStateInfoRef(subchannelStateInfoRef).value;
                if (connectivityStateInfo.getState() == ConnectivityState.CONNECTING || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                    z = true;
                }
                if (status == EMPTY_OK || !status.isOk()) {
                    status = connectivityStateInfo.getStatus();
                }
            }
            updateBalancingState(z ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
            return;
        }
        updateBalancingState(ConnectivityState.READY, new ReadyPicker(filterNonFailingSubchannels, this.random.nextInt(filterNonFailingSubchannels.size()), this.stickinessState));
    }

    private void updateBalancingState(ConnectivityState connectivityState, RoundRobinPicker roundRobinPicker) {
        if (connectivityState != this.currentState || !roundRobinPicker.isEquivalentTo(this.currentPicker)) {
            this.helper.updateBalancingState(connectivityState, roundRobinPicker);
            this.currentState = connectivityState;
            this.currentPicker = roundRobinPicker;
        }
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (LoadBalancer.Subchannel next : collection) {
            if (isReady(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static Set<EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> list) {
        HashSet hashSet = new HashSet(list.size());
        for (EquivalentAddressGroup addresses : list) {
            hashSet.add(new EquivalentAddressGroup(addresses.getAddresses()));
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull(subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return ((ConnectivityStateInfo) getSubchannelStateInfoRef(subchannel).value).getState() == ConnectivityState.READY;
    }

    private static <T> Set<T> setsDifference(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Ref<LoadBalancer.Subchannel>> getStickinessMapForTest() {
        StickinessState stickinessState2 = this.stickinessState;
        if (stickinessState2 == null) {
            return null;
        }
        return stickinessState2.stickinessMap;
    }

    @VisibleForTesting
    static final class StickinessState {
        static final int MAX_ENTRIES = 1000;
        final Queue<String> evictionQueue = new ConcurrentLinkedQueue();
        final Metadata.Key<String> key;
        final ConcurrentMap<String, Ref<LoadBalancer.Subchannel>> stickinessMap = new ConcurrentHashMap();

        StickinessState(@Nonnull String str) {
            this.key = Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER);
        }

        /* access modifiers changed from: package-private */
        @Nonnull
        public LoadBalancer.Subchannel maybeRegister(String str, @Nonnull LoadBalancer.Subchannel subchannel) {
            Ref putIfAbsent;
            Ref ref = (Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF);
            do {
                putIfAbsent = this.stickinessMap.putIfAbsent(str, ref);
                if (putIfAbsent == null) {
                    addToEvictionQueue(str);
                    return subchannel;
                }
                LoadBalancer.Subchannel subchannel2 = (LoadBalancer.Subchannel) putIfAbsent.value;
                if (subchannel2 != null && RoundRobinLoadBalancer.isReady(subchannel2)) {
                    return subchannel2;
                }
            } while (!this.stickinessMap.replace(str, putIfAbsent, ref));
            return subchannel;
        }

        private void addToEvictionQueue(String str) {
            String poll;
            while (this.stickinessMap.size() >= 1000 && (poll = this.evictionQueue.poll()) != null) {
                this.stickinessMap.remove(poll);
            }
            this.evictionQueue.add(str);
        }

        /* access modifiers changed from: package-private */
        public void remove(LoadBalancer.Subchannel subchannel) {
            ((Ref) subchannel.getAttributes().get(RoundRobinLoadBalancer.STICKY_REF)).value = null;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public LoadBalancer.Subchannel getSubchannel(String str) {
            Ref ref = (Ref) this.stickinessMap.get(str);
            if (ref != null) {
                return (LoadBalancer.Subchannel) ref.value;
            }
            return null;
        }
    }

    private static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        /* access modifiers changed from: package-private */
        public abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);

        private RoundRobinPicker() {
        }
    }

    @VisibleForTesting
    static final class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, FirebaseAnalytics.Param.INDEX);
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;
        @Nullable
        private final StickinessState stickinessState;

        ReadyPicker(List<LoadBalancer.Subchannel> list2, int i, @Nullable StickinessState stickinessState2) {
            super();
            Preconditions.checkArgument(!list2.isEmpty(), "empty list");
            this.list = list2;
            this.stickinessState = stickinessState2;
            this.index = i - 1;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.Subchannel subchannel;
            String str;
            if (this.stickinessState == null || (str = (String) pickSubchannelArgs.getHeaders().get(this.stickinessState.key)) == null) {
                subchannel = null;
            } else {
                subchannel = this.stickinessState.getSubchannel(str);
                if (subchannel == null || !RoundRobinLoadBalancer.isReady(subchannel)) {
                    subchannel = this.stickinessState.maybeRegister(str, nextSubchannel());
                }
            }
            if (subchannel == null) {
                subchannel = nextSubchannel();
            }
            return LoadBalancer.PickResult.withSubchannel(subchannel);
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int i;
            int size = this.list.size();
            int incrementAndGet = indexUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                i = incrementAndGet % size;
                indexUpdater.compareAndSet(this, incrementAndGet, i);
            } else {
                i = incrementAndGet;
            }
            return this.list.get(i);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        /* access modifiers changed from: package-private */
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (!(roundRobinPicker instanceof ReadyPicker)) {
                return false;
            }
            ReadyPicker readyPicker = (ReadyPicker) roundRobinPicker;
            if (readyPicker == this || (this.stickinessState == readyPicker.stickinessState && this.list.size() == readyPicker.list.size() && new HashSet(this.list).containsAll(readyPicker.list))) {
                return true;
            }
            return false;
        }
    }

    @VisibleForTesting
    static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        EmptyPicker(@Nonnull Status status2) {
            super();
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        /* access modifiers changed from: package-private */
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (roundRobinPicker instanceof EmptyPicker) {
                EmptyPicker emptyPicker = (EmptyPicker) roundRobinPicker;
                if (Objects.equal(this.status, emptyPicker.status) || (this.status.isOk() && emptyPicker.status.isOk())) {
                    return true;
                }
            }
            return false;
        }
    }

    @VisibleForTesting
    static final class Ref<T> {
        T value;

        Ref(T t) {
            this.value = t;
        }
    }
}
