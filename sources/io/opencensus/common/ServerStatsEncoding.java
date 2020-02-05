package io.opencensus.common;

import com.google.common.primitives.UnsignedBytes;
import io.opencensus.common.ServerStatsFieldEnums;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ServerStatsEncoding {
    public static final byte CURRENT_VERSION = 0;

    private ServerStatsEncoding() {
    }

    public static byte[] toBytes(ServerStats serverStats) {
        ByteBuffer allocate = ByteBuffer.allocate(ServerStatsFieldEnums.getTotalSize() + 1);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) 0);
        allocate.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_LB_LATENCY_ID.value());
        allocate.putLong(serverStats.getLbLatencyNs());
        allocate.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_SERVICE_LATENCY_ID.value());
        allocate.putLong(serverStats.getServiceLatencyNs());
        allocate.put((byte) ServerStatsFieldEnums.Id.SERVER_STATS_TRACE_OPTION_ID.value());
        allocate.put(serverStats.getTraceOption());
        return allocate.array();
    }

    public static ServerStats parseBytes(byte[] bArr) throws ServerStatsDeserializationException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (wrap.hasRemaining()) {
            byte b = wrap.get();
            if (b > 0 || b < 0) {
                throw new ServerStatsDeserializationException("Invalid ServerStats version: " + b);
            }
            long j = 0;
            long j2 = 0;
            byte b2 = 0;
            while (wrap.hasRemaining()) {
                ServerStatsFieldEnums.Id valueOf = ServerStatsFieldEnums.Id.valueOf((int) wrap.get() & UnsignedBytes.MAX_VALUE);
                if (valueOf == null) {
                    wrap.position(wrap.limit());
                } else {
                    int i = AnonymousClass1.$SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id[valueOf.ordinal()];
                    if (i == 1) {
                        j = wrap.getLong();
                    } else if (i == 2) {
                        j2 = wrap.getLong();
                    } else if (i == 3) {
                        b2 = wrap.get();
                    }
                }
            }
            try {
                return ServerStats.create(j, j2, b2);
            } catch (IllegalArgumentException e) {
                throw new ServerStatsDeserializationException("Serialized ServiceStats contains invalid values: " + e.getMessage());
            }
        } else {
            throw new ServerStatsDeserializationException("Serialized ServerStats buffer is empty");
        }
    }

    /* renamed from: io.opencensus.common.ServerStatsEncoding$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id = new int[ServerStatsFieldEnums.Id.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                io.opencensus.common.ServerStatsFieldEnums$Id[] r0 = io.opencensus.common.ServerStatsFieldEnums.Id.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id = r0
                int[] r0 = $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.opencensus.common.ServerStatsFieldEnums$Id r1 = io.opencensus.common.ServerStatsFieldEnums.Id.SERVER_STATS_LB_LATENCY_ID     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id     // Catch:{ NoSuchFieldError -> 0x001f }
                io.opencensus.common.ServerStatsFieldEnums$Id r1 = io.opencensus.common.ServerStatsFieldEnums.Id.SERVER_STATS_SERVICE_LATENCY_ID     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$io$opencensus$common$ServerStatsFieldEnums$Id     // Catch:{ NoSuchFieldError -> 0x002a }
                io.opencensus.common.ServerStatsFieldEnums$Id r1 = io.opencensus.common.ServerStatsFieldEnums.Id.SERVER_STATS_TRACE_OPTION_ID     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opencensus.common.ServerStatsEncoding.AnonymousClass1.<clinit>():void");
        }
    }
}
