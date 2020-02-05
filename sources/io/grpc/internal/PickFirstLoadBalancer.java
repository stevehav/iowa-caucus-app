package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.List;

final class PickFirstLoadBalancer extends LoadBalancer {
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    PickFirstLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
    }

    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 == null) {
            this.subchannel = this.helper.createSubchannel(addresses, Attributes.EMPTY);
            this.helper.updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(this.subchannel)));
            this.subchannel.requestConnection();
            return;
        }
        this.helper.updateSubchannelAddresses(subchannel2, addresses);
    }

    public void handleNameResolutionError(Status status) {
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 != null) {
            subchannel2.shutdown();
            this.subchannel = null;
        }
        this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(status)));
    }

    public void handleSubchannelState(LoadBalancer.Subchannel subchannel2, ConnectivityStateInfo connectivityStateInfo) {
        LoadBalancer.SubchannelPicker subchannelPicker;
        LoadBalancer.SubchannelPicker subchannelPicker2;
        ConnectivityState state = connectivityStateInfo.getState();
        if (subchannel2 == this.subchannel && state != ConnectivityState.SHUTDOWN) {
            int i = AnonymousClass1.$SwitchMap$io$grpc$ConnectivityState[state.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    subchannelPicker = new Picker(LoadBalancer.PickResult.withNoResult());
                } else if (i == 3) {
                    subchannelPicker2 = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel2));
                } else if (i == 4) {
                    subchannelPicker = new Picker(LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus()));
                } else {
                    throw new IllegalArgumentException("Unsupported state:" + state);
                }
                this.helper.updateBalancingState(state, subchannelPicker);
            }
            subchannelPicker2 = new RequestConnectionPicker(subchannel2);
            subchannelPicker = subchannelPicker2;
            this.helper.updateBalancingState(state, subchannelPicker);
        }
    }

    /* renamed from: io.grpc.internal.PickFirstLoadBalancer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ConnectivityState = new int[ConnectivityState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                io.grpc.ConnectivityState[] r0 = io.grpc.ConnectivityState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$grpc$ConnectivityState = r0
                int[] r0 = $SwitchMap$io$grpc$ConnectivityState     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.IDLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$io$grpc$ConnectivityState     // Catch:{ NoSuchFieldError -> 0x001f }
                io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$io$grpc$ConnectivityState     // Catch:{ NoSuchFieldError -> 0x002a }
                io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.READY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$io$grpc$ConnectivityState     // Catch:{ NoSuchFieldError -> 0x0035 }
                io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.TRANSIENT_FAILURE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.PickFirstLoadBalancer.AnonymousClass1.<clinit>():void");
        }
    }

    public void shutdown() {
        LoadBalancer.Subchannel subchannel2 = this.subchannel;
        if (subchannel2 != null) {
            subchannel2.shutdown();
        }
    }

    private static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult pickResult) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(pickResult, "result");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.result;
        }
    }

    private static final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.Subchannel subchannel;

        RequestConnectionPicker(LoadBalancer.Subchannel subchannel2) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel2, "subchannel");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            this.subchannel.requestConnection();
            return LoadBalancer.PickResult.withNoResult();
        }

        public void requestConnection() {
            this.subchannel.requestConnection();
        }
    }
}
