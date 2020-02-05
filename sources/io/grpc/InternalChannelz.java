package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

@Internal
public final class InternalChannelz {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalChannelz INSTANCE = new InternalChannelz();
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(InternalChannelz.class.getName());
    private final ConcurrentMap<Long, InternalInstrumented<SocketStats>> otherSockets = new ConcurrentHashMap();
    private final ConcurrentMap<Long, ServerSocketMap> perServerSockets = new ConcurrentHashMap();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ChannelStats>> rootChannels = new ConcurrentSkipListMap();
    private final ConcurrentNavigableMap<Long, InternalInstrumented<ServerStats>> servers = new ConcurrentSkipListMap();
    private final ConcurrentMap<Long, InternalInstrumented<ChannelStats>> subchannels = new ConcurrentHashMap();

    private static final class ServerSocketMap extends ConcurrentSkipListMap<Long, InternalInstrumented<SocketStats>> {
        private static final long serialVersionUID = -7883772124944661414L;

        private ServerSocketMap() {
        }
    }

    public static InternalChannelz instance() {
        return INSTANCE;
    }

    public void addServer(InternalInstrumented<ServerStats> internalInstrumented) {
        ServerSocketMap serverSocketMap = (ServerSocketMap) this.perServerSockets.put(Long.valueOf(id(internalInstrumented)), new ServerSocketMap());
        add(this.servers, internalInstrumented);
    }

    public void addSubchannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        add(this.subchannels, internalInstrumented);
    }

    public void addRootChannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        add(this.rootChannels, internalInstrumented);
    }

    public void addClientSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        add(this.otherSockets, internalInstrumented);
    }

    public void addListenSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        add(this.otherSockets, internalInstrumented);
    }

    public void addServerSocket(InternalInstrumented<ServerStats> internalInstrumented, InternalInstrumented<SocketStats> internalInstrumented2) {
        add((ServerSocketMap) this.perServerSockets.get(Long.valueOf(id(internalInstrumented))), internalInstrumented2);
    }

    public void removeServer(InternalInstrumented<ServerStats> internalInstrumented) {
        remove(this.servers, internalInstrumented);
        ServerSocketMap serverSocketMap = (ServerSocketMap) this.perServerSockets.remove(Long.valueOf(id(internalInstrumented)));
    }

    public void removeSubchannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        remove(this.subchannels, internalInstrumented);
    }

    public void removeRootChannel(InternalInstrumented<ChannelStats> internalInstrumented) {
        remove(this.rootChannels, internalInstrumented);
    }

    public void removeClientSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        remove(this.otherSockets, internalInstrumented);
    }

    public void removeListenSocket(InternalInstrumented<SocketStats> internalInstrumented) {
        remove(this.otherSockets, internalInstrumented);
    }

    public void removeServerSocket(InternalInstrumented<ServerStats> internalInstrumented, InternalInstrumented<SocketStats> internalInstrumented2) {
        remove((ServerSocketMap) this.perServerSockets.get(Long.valueOf(id(internalInstrumented))), internalInstrumented2);
    }

    public RootChannelList getRootChannels(long j, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.rootChannels.tailMap(Long.valueOf(j)).values().iterator();
        while (it.hasNext() && arrayList.size() < i) {
            arrayList.add(it.next());
        }
        return new RootChannelList(arrayList, !it.hasNext());
    }

    @Nullable
    public InternalInstrumented<ChannelStats> getChannel(long j) {
        return (InternalInstrumented) this.rootChannels.get(Long.valueOf(j));
    }

    @Nullable
    public InternalInstrumented<ChannelStats> getSubchannel(long j) {
        return (InternalInstrumented) this.subchannels.get(Long.valueOf(j));
    }

    public ServerList getServers(long j, int i) {
        ArrayList arrayList = new ArrayList(i);
        Iterator it = this.servers.tailMap(Long.valueOf(j)).values().iterator();
        while (it.hasNext() && arrayList.size() < i) {
            arrayList.add(it.next());
        }
        return new ServerList(arrayList, !it.hasNext());
    }

    @Nullable
    public ServerSocketsList getServerSockets(long j, long j2, int i) {
        ServerSocketMap serverSocketMap = (ServerSocketMap) this.perServerSockets.get(Long.valueOf(j));
        if (serverSocketMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = serverSocketMap.tailMap(Long.valueOf(j2)).values().iterator();
        while (arrayList.size() < i && it.hasNext()) {
            arrayList.add(it.next());
        }
        return new ServerSocketsList(arrayList, !it.hasNext());
    }

    @Nullable
    public InternalInstrumented<SocketStats> getSocket(long j) {
        InternalInstrumented<SocketStats> internalInstrumented = (InternalInstrumented) this.otherSockets.get(Long.valueOf(j));
        if (internalInstrumented != null) {
            return internalInstrumented;
        }
        return getServerSocket(j);
    }

    private InternalInstrumented<SocketStats> getServerSocket(long j) {
        for (ServerSocketMap serverSocketMap : this.perServerSockets.values()) {
            InternalInstrumented<SocketStats> internalInstrumented = (InternalInstrumented) serverSocketMap.get(Long.valueOf(j));
            if (internalInstrumented != null) {
                return internalInstrumented;
            }
        }
        return null;
    }

    @VisibleForTesting
    public boolean containsServer(InternalLogId internalLogId) {
        return contains(this.servers, internalLogId);
    }

    @VisibleForTesting
    public boolean containsSubchannel(InternalLogId internalLogId) {
        return contains(this.subchannels, internalLogId);
    }

    public InternalInstrumented<ChannelStats> getRootChannel(long j) {
        return (InternalInstrumented) this.rootChannels.get(Long.valueOf(j));
    }

    @VisibleForTesting
    public boolean containsClientSocket(InternalLogId internalLogId) {
        return contains(this.otherSockets, internalLogId);
    }

    private static <T extends InternalInstrumented<?>> void add(Map<Long, T> map, T t) {
        InternalInstrumented internalInstrumented = (InternalInstrumented) map.put(Long.valueOf(t.getLogId().getId()), t);
    }

    private static <T extends InternalInstrumented<?>> void remove(Map<Long, T> map, T t) {
        InternalInstrumented internalInstrumented = (InternalInstrumented) map.remove(Long.valueOf(id(t)));
    }

    private static <T extends InternalInstrumented<?>> boolean contains(Map<Long, T> map, InternalLogId internalLogId) {
        return map.containsKey(Long.valueOf(internalLogId.getId()));
    }

    public static final class RootChannelList {
        public final List<InternalInstrumented<ChannelStats>> channels;
        public final boolean end;

        public RootChannelList(List<InternalInstrumented<ChannelStats>> list, boolean z) {
            this.channels = (List) Preconditions.checkNotNull(list);
            this.end = z;
        }
    }

    public static final class ServerList {
        public final boolean end;
        public final List<InternalInstrumented<ServerStats>> servers;

        public ServerList(List<InternalInstrumented<ServerStats>> list, boolean z) {
            this.servers = (List) Preconditions.checkNotNull(list);
            this.end = z;
        }
    }

    public static final class ServerSocketsList {
        public final boolean end;
        public final List<InternalWithLogId> sockets;

        public ServerSocketsList(List<InternalWithLogId> list, boolean z) {
            this.sockets = list;
            this.end = z;
        }
    }

    @Immutable
    public static final class ServerStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        public final long lastCallStartedNanos;
        public final List<InternalInstrumented<SocketStats>> listenSockets;

        public ServerStats(long j, long j2, long j3, long j4, List<InternalInstrumented<SocketStats>> list) {
            this.callsStarted = j;
            this.callsSucceeded = j2;
            this.callsFailed = j3;
            this.lastCallStartedNanos = j4;
            this.listenSockets = (List) Preconditions.checkNotNull(list);
        }

        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private long lastCallStartedNanos;
            public List<InternalInstrumented<SocketStats>> listenSockets = new ArrayList();

            public Builder setCallsStarted(long j) {
                this.callsStarted = j;
                return this;
            }

            public Builder setCallsSucceeded(long j) {
                this.callsSucceeded = j;
                return this;
            }

            public Builder setCallsFailed(long j) {
                this.callsFailed = j;
                return this;
            }

            public Builder setLastCallStartedNanos(long j) {
                this.lastCallStartedNanos = j;
                return this;
            }

            public Builder addListenSockets(List<InternalInstrumented<SocketStats>> list) {
                Preconditions.checkNotNull(list, "listenSockets");
                for (InternalInstrumented<SocketStats> checkNotNull : list) {
                    this.listenSockets.add(Preconditions.checkNotNull(checkNotNull, "null listen socket"));
                }
                return this;
            }

            public ServerStats build() {
                return new ServerStats(this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.listenSockets);
            }
        }
    }

    @Immutable
    public static final class ChannelStats {
        public final long callsFailed;
        public final long callsStarted;
        public final long callsSucceeded;
        @Nullable
        public final ChannelTrace channelTrace;
        public final long lastCallStartedNanos;
        public final List<InternalWithLogId> sockets;
        public final ConnectivityState state;
        public final List<InternalWithLogId> subchannels;
        public final String target;

        private ChannelStats(String str, ConnectivityState connectivityState, @Nullable ChannelTrace channelTrace2, long j, long j2, long j3, long j4, List<InternalWithLogId> list, List<InternalWithLogId> list2) {
            Preconditions.checkState(list.isEmpty() || list2.isEmpty(), "channels can have subchannels only, subchannels can have either sockets OR subchannels, neither can have both");
            this.target = str;
            this.state = connectivityState;
            this.channelTrace = channelTrace2;
            this.callsStarted = j;
            this.callsSucceeded = j2;
            this.callsFailed = j3;
            this.lastCallStartedNanos = j4;
            this.subchannels = (List) Preconditions.checkNotNull(list);
            this.sockets = (List) Preconditions.checkNotNull(list2);
        }

        public static final class Builder {
            private long callsFailed;
            private long callsStarted;
            private long callsSucceeded;
            private ChannelTrace channelTrace;
            private long lastCallStartedNanos;
            private List<InternalWithLogId> sockets = Collections.emptyList();
            private ConnectivityState state;
            private List<InternalWithLogId> subchannels = Collections.emptyList();
            private String target;

            public Builder setTarget(String str) {
                this.target = str;
                return this;
            }

            public Builder setState(ConnectivityState connectivityState) {
                this.state = connectivityState;
                return this;
            }

            public Builder setChannelTrace(ChannelTrace channelTrace2) {
                this.channelTrace = channelTrace2;
                return this;
            }

            public Builder setCallsStarted(long j) {
                this.callsStarted = j;
                return this;
            }

            public Builder setCallsSucceeded(long j) {
                this.callsSucceeded = j;
                return this;
            }

            public Builder setCallsFailed(long j) {
                this.callsFailed = j;
                return this;
            }

            public Builder setLastCallStartedNanos(long j) {
                this.lastCallStartedNanos = j;
                return this;
            }

            public Builder setSubchannels(List<InternalWithLogId> list) {
                Preconditions.checkState(this.sockets.isEmpty());
                this.subchannels = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
                return this;
            }

            public Builder setSockets(List<InternalWithLogId> list) {
                Preconditions.checkState(this.subchannels.isEmpty());
                this.sockets = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
                return this;
            }

            public ChannelStats build() {
                return new ChannelStats(this.target, this.state, this.channelTrace, this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedNanos, this.subchannels, this.sockets);
            }
        }
    }

    @Immutable
    public static final class ChannelTrace {
        public final long creationTimeNanos;
        public final List<Event> events;
        public final long numEventsLogged;

        private ChannelTrace(long j, long j2, List<Event> list) {
            this.numEventsLogged = j;
            this.creationTimeNanos = j2;
            this.events = list;
        }

        public static final class Builder {
            private Long creationTimeNanos;
            private List<Event> events = Collections.emptyList();
            private Long numEventsLogged;

            public Builder setNumEventsLogged(long j) {
                this.numEventsLogged = Long.valueOf(j);
                return this;
            }

            public Builder setCreationTimeNanos(long j) {
                this.creationTimeNanos = Long.valueOf(j);
                return this;
            }

            public Builder setEvents(List<Event> list) {
                this.events = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public ChannelTrace build() {
                Preconditions.checkNotNull(this.numEventsLogged, "numEventsLogged");
                Preconditions.checkNotNull(this.creationTimeNanos, "creationTimeNanos");
                return new ChannelTrace(this.numEventsLogged.longValue(), this.creationTimeNanos.longValue(), this.events);
            }
        }

        @Immutable
        public static final class Event {
            @Nullable
            public final InternalWithLogId channelRef;
            public final String description;
            public final Severity severity;
            @Nullable
            public final InternalWithLogId subchannelRef;
            public final long timestampNanos;

            public enum Severity {
                CT_UNKNOWN,
                CT_INFO,
                CT_WARNING,
                CT_ERROR
            }

            private Event(String str, Severity severity2, long j, @Nullable InternalWithLogId internalWithLogId, @Nullable InternalWithLogId internalWithLogId2) {
                this.description = str;
                this.severity = (Severity) Preconditions.checkNotNull(severity2, "severity");
                this.timestampNanos = j;
                this.channelRef = internalWithLogId;
                this.subchannelRef = internalWithLogId2;
            }

            public int hashCode() {
                return Objects.hashCode(this.description, this.severity, Long.valueOf(this.timestampNanos), this.channelRef, this.subchannelRef);
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Event)) {
                    return false;
                }
                Event event = (Event) obj;
                if (!Objects.equal(this.description, event.description) || !Objects.equal(this.severity, event.severity) || this.timestampNanos != event.timestampNanos || !Objects.equal(this.channelRef, event.channelRef) || !Objects.equal(this.subchannelRef, event.subchannelRef)) {
                    return false;
                }
                return true;
            }

            public String toString() {
                return MoreObjects.toStringHelper((Object) this).add("description", (Object) this.description).add("severity", (Object) this.severity).add("timestampNanos", this.timestampNanos).add("channelRef", (Object) this.channelRef).add("subchannelRef", (Object) this.subchannelRef).toString();
            }

            public static final class Builder {
                private InternalWithLogId channelRef;
                private String description;
                private Severity severity;
                private InternalWithLogId subchannelRef;
                private Long timestampNanos;

                public Builder setDescription(String str) {
                    this.description = str;
                    return this;
                }

                public Builder setTimestampNanos(long j) {
                    this.timestampNanos = Long.valueOf(j);
                    return this;
                }

                public Builder setSeverity(Severity severity2) {
                    this.severity = severity2;
                    return this;
                }

                public Builder setChannelRef(InternalWithLogId internalWithLogId) {
                    this.channelRef = internalWithLogId;
                    return this;
                }

                public Builder setSubchannelRef(InternalWithLogId internalWithLogId) {
                    this.subchannelRef = internalWithLogId;
                    return this;
                }

                public Event build() {
                    Preconditions.checkNotNull(this.description, "description");
                    Preconditions.checkNotNull(this.severity, "severity");
                    Preconditions.checkNotNull(this.timestampNanos, "timestampNanos");
                    Preconditions.checkState(this.channelRef == null || this.subchannelRef == null, "at least one of channelRef and subchannelRef must be null");
                    return new Event(this.description, this.severity, this.timestampNanos.longValue(), this.channelRef, this.subchannelRef);
                }
            }
        }
    }

    public static final class Security {
        @Nullable
        public final OtherSecurity other;
        @Nullable
        public final Tls tls;

        public Security(Tls tls2) {
            this.tls = (Tls) Preconditions.checkNotNull(tls2);
            this.other = null;
        }

        public Security(OtherSecurity otherSecurity) {
            this.tls = null;
            this.other = (OtherSecurity) Preconditions.checkNotNull(otherSecurity);
        }
    }

    public static final class OtherSecurity {
        @Nullable
        public final Object any;
        public final String name;

        public OtherSecurity(String str, @Nullable Object obj) {
            this.name = (String) Preconditions.checkNotNull(str);
            Preconditions.checkState(obj == null || obj.getClass().getName().endsWith("com.google.protobuf.Any"), "the 'any' object must be of type com.google.protobuf.Any");
            this.any = obj;
        }
    }

    @Immutable
    public static final class Tls {
        public final String cipherSuiteStandardName;
        @Nullable
        public final Certificate localCert;
        @Nullable
        public final Certificate remoteCert;

        public Tls(String str, Certificate certificate, Certificate certificate2) {
            this.cipherSuiteStandardName = str;
            this.localCert = certificate;
            this.remoteCert = certificate2;
        }

        public Tls(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e) {
                InternalChannelz.log.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", new Object[]{sSLSession.getPeerHost()}), e);
            }
            this.cipherSuiteStandardName = cipherSuite;
            this.localCert = certificate2;
            this.remoteCert = certificate;
        }
    }

    public static final class SocketStats {
        @Nullable
        public final TransportStats data;
        @Nullable
        public final SocketAddress local;
        @Nullable
        public final SocketAddress remote;
        @Nullable
        public final Security security;
        public final SocketOptions socketOptions;

        public SocketStats(TransportStats transportStats, @Nullable SocketAddress socketAddress, @Nullable SocketAddress socketAddress2, SocketOptions socketOptions2, Security security2) {
            this.data = transportStats;
            this.local = (SocketAddress) Preconditions.checkNotNull(socketAddress, "local socket");
            this.remote = socketAddress2;
            this.socketOptions = (SocketOptions) Preconditions.checkNotNull(socketOptions2);
            this.security = security2;
        }
    }

    public static final class TcpInfo {
        public final int advmss;
        public final int ato;
        public final int backoff;
        public final int caState;
        public final int fackets;
        public final int lastAckRecv;
        public final int lastAckSent;
        public final int lastDataRecv;
        public final int lastDataSent;
        public final int lost;
        public final int options;
        public final int pmtu;
        public final int probes;
        public final int rcvMss;
        public final int rcvSsthresh;
        public final int rcvWscale;
        public final int reordering;
        public final int retrans;
        public final int retransmits;
        public final int rto;
        public final int rtt;
        public final int rttvar;
        public final int sacked;
        public final int sndCwnd;
        public final int sndMss;
        public final int sndSsthresh;
        public final int sndWscale;
        public final int state;
        public final int unacked;

        TcpInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
            this.state = i;
            this.caState = i2;
            this.retransmits = i3;
            this.probes = i4;
            this.backoff = i5;
            this.options = i6;
            this.sndWscale = i7;
            this.rcvWscale = i8;
            this.rto = i9;
            this.ato = i10;
            this.sndMss = i11;
            this.rcvMss = i12;
            this.unacked = i13;
            this.sacked = i14;
            this.lost = i15;
            this.retrans = i16;
            this.fackets = i17;
            this.lastDataSent = i18;
            this.lastAckSent = i19;
            this.lastDataRecv = i20;
            this.lastAckRecv = i21;
            this.pmtu = i22;
            this.rcvSsthresh = i23;
            this.rtt = i24;
            this.rttvar = i25;
            this.sndSsthresh = i26;
            this.sndCwnd = i27;
            this.advmss = i28;
            this.reordering = i29;
        }

        public static final class Builder {
            private int advmss;
            private int ato;
            private int backoff;
            private int caState;
            private int fackets;
            private int lastAckRecv;
            private int lastAckSent;
            private int lastDataRecv;
            private int lastDataSent;
            private int lost;
            private int options;
            private int pmtu;
            private int probes;
            private int rcvMss;
            private int rcvSsthresh;
            private int rcvWscale;
            private int reordering;
            private int retrans;
            private int retransmits;
            private int rto;
            private int rtt;
            private int rttvar;
            private int sacked;
            private int sndCwnd;
            private int sndMss;
            private int sndSsthresh;
            private int sndWscale;
            private int state;
            private int unacked;

            public Builder setState(int i) {
                this.state = i;
                return this;
            }

            public Builder setCaState(int i) {
                this.caState = i;
                return this;
            }

            public Builder setRetransmits(int i) {
                this.retransmits = i;
                return this;
            }

            public Builder setProbes(int i) {
                this.probes = i;
                return this;
            }

            public Builder setBackoff(int i) {
                this.backoff = i;
                return this;
            }

            public Builder setOptions(int i) {
                this.options = i;
                return this;
            }

            public Builder setSndWscale(int i) {
                this.sndWscale = i;
                return this;
            }

            public Builder setRcvWscale(int i) {
                this.rcvWscale = i;
                return this;
            }

            public Builder setRto(int i) {
                this.rto = i;
                return this;
            }

            public Builder setAto(int i) {
                this.ato = i;
                return this;
            }

            public Builder setSndMss(int i) {
                this.sndMss = i;
                return this;
            }

            public Builder setRcvMss(int i) {
                this.rcvMss = i;
                return this;
            }

            public Builder setUnacked(int i) {
                this.unacked = i;
                return this;
            }

            public Builder setSacked(int i) {
                this.sacked = i;
                return this;
            }

            public Builder setLost(int i) {
                this.lost = i;
                return this;
            }

            public Builder setRetrans(int i) {
                this.retrans = i;
                return this;
            }

            public Builder setFackets(int i) {
                this.fackets = i;
                return this;
            }

            public Builder setLastDataSent(int i) {
                this.lastDataSent = i;
                return this;
            }

            public Builder setLastAckSent(int i) {
                this.lastAckSent = i;
                return this;
            }

            public Builder setLastDataRecv(int i) {
                this.lastDataRecv = i;
                return this;
            }

            public Builder setLastAckRecv(int i) {
                this.lastAckRecv = i;
                return this;
            }

            public Builder setPmtu(int i) {
                this.pmtu = i;
                return this;
            }

            public Builder setRcvSsthresh(int i) {
                this.rcvSsthresh = i;
                return this;
            }

            public Builder setRtt(int i) {
                this.rtt = i;
                return this;
            }

            public Builder setRttvar(int i) {
                this.rttvar = i;
                return this;
            }

            public Builder setSndSsthresh(int i) {
                this.sndSsthresh = i;
                return this;
            }

            public Builder setSndCwnd(int i) {
                this.sndCwnd = i;
                return this;
            }

            public Builder setAdvmss(int i) {
                this.advmss = i;
                return this;
            }

            public Builder setReordering(int i) {
                this.reordering = i;
                return this;
            }

            public TcpInfo build() {
                return new TcpInfo(this.state, this.caState, this.retransmits, this.probes, this.backoff, this.options, this.sndWscale, this.rcvWscale, this.rto, this.ato, this.sndMss, this.rcvMss, this.unacked, this.sacked, this.lost, this.retrans, this.fackets, this.lastDataSent, this.lastAckSent, this.lastDataRecv, this.lastAckRecv, this.pmtu, this.rcvSsthresh, this.rtt, this.rttvar, this.sndSsthresh, this.sndCwnd, this.advmss, this.reordering);
            }
        }
    }

    public static final class SocketOptions {
        @Nullable
        public final Integer lingerSeconds;
        public final Map<String, String> others;
        @Nullable
        public final Integer soTimeoutMillis;
        @Nullable
        public final TcpInfo tcpInfo;

        public SocketOptions(@Nullable Integer num, @Nullable Integer num2, @Nullable TcpInfo tcpInfo2, Map<String, String> map) {
            Preconditions.checkNotNull(map);
            this.soTimeoutMillis = num;
            this.lingerSeconds = num2;
            this.tcpInfo = tcpInfo2;
            this.others = Collections.unmodifiableMap(new HashMap(map));
        }

        public static final class Builder {
            private Integer lingerSeconds;
            private final Map<String, String> others = new HashMap();
            private TcpInfo tcpInfo;
            private Integer timeoutMillis;

            public Builder setSocketOptionTimeoutMillis(Integer num) {
                this.timeoutMillis = num;
                return this;
            }

            public Builder setSocketOptionLingerSeconds(Integer num) {
                this.lingerSeconds = num;
                return this;
            }

            public Builder setTcpInfo(TcpInfo tcpInfo2) {
                this.tcpInfo = tcpInfo2;
                return this;
            }

            public Builder addOption(String str, String str2) {
                this.others.put(str, Preconditions.checkNotNull(str2));
                return this;
            }

            public Builder addOption(String str, int i) {
                this.others.put(str, Integer.toString(i));
                return this;
            }

            public Builder addOption(String str, boolean z) {
                this.others.put(str, Boolean.toString(z));
                return this;
            }

            public SocketOptions build() {
                return new SocketOptions(this.timeoutMillis, this.lingerSeconds, this.tcpInfo, this.others);
            }
        }
    }

    @Immutable
    public static final class TransportStats {
        public final long keepAlivesSent;
        public final long lastLocalStreamCreatedTimeNanos;
        public final long lastMessageReceivedTimeNanos;
        public final long lastMessageSentTimeNanos;
        public final long lastRemoteStreamCreatedTimeNanos;
        public final long localFlowControlWindow;
        public final long messagesReceived;
        public final long messagesSent;
        public final long remoteFlowControlWindow;
        public final long streamsFailed;
        public final long streamsStarted;
        public final long streamsSucceeded;

        public TransportStats(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
            this.streamsStarted = j;
            this.lastLocalStreamCreatedTimeNanos = j2;
            this.lastRemoteStreamCreatedTimeNanos = j3;
            this.streamsSucceeded = j4;
            this.streamsFailed = j5;
            this.messagesSent = j6;
            this.messagesReceived = j7;
            this.keepAlivesSent = j8;
            this.lastMessageSentTimeNanos = j9;
            this.lastMessageReceivedTimeNanos = j10;
            this.localFlowControlWindow = j11;
            this.remoteFlowControlWindow = j12;
        }
    }

    public static long id(InternalWithLogId internalWithLogId) {
        return internalWithLogId.getLogId().getId();
    }
}
