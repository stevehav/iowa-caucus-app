package io.opencensus.trace;

import io.opencensus.internal.Utils;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class TraceId implements Comparable<TraceId> {
    private static final int BASE16_SIZE = 32;
    public static final TraceId INVALID = new TraceId(0, 0);
    private static final long INVALID_ID = 0;
    public static final int SIZE = 16;
    private final long idHi;
    private final long idLo;

    private TraceId(long j, long j2) {
        this.idHi = j;
        this.idLo = j2;
    }

    public static TraceId fromBytes(byte[] bArr) {
        Utils.checkNotNull(bArr, "src");
        Utils.checkArgument(bArr.length == 16, "Invalid size: expected %s, got %s", 16, Integer.valueOf(bArr.length));
        return fromBytes(bArr, 0);
    }

    public static TraceId fromBytes(byte[] bArr, int i) {
        Utils.checkNotNull(bArr, "src");
        return new TraceId(BigendianEncoding.longFromByteArray(bArr, i), BigendianEncoding.longFromByteArray(bArr, i + 8));
    }

    public static TraceId fromLowerBase16(CharSequence charSequence) {
        Utils.checkNotNull(charSequence, "src");
        Utils.checkArgument(charSequence.length() == 32, "Invalid size: expected %s, got %s", 32, Integer.valueOf(charSequence.length()));
        return fromLowerBase16(charSequence, 0);
    }

    public static TraceId fromLowerBase16(CharSequence charSequence, int i) {
        Utils.checkNotNull(charSequence, "src");
        return new TraceId(BigendianEncoding.longFromBase16String(charSequence, i), BigendianEncoding.longFromBase16String(charSequence, i + 16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.opencensus.trace.TraceId generateRandomId(java.util.Random r7) {
        /*
        L_0x0000:
            long r0 = r7.nextLong()
            long r2 = r7.nextLong()
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0012
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0000
        L_0x0012:
            io.opencensus.trace.TraceId r7 = new io.opencensus.trace.TraceId
            r7.<init>(r0, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.TraceId.generateRandomId(java.util.Random):io.opencensus.trace.TraceId");
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[16];
        BigendianEncoding.longToByteArray(this.idHi, bArr, 0);
        BigendianEncoding.longToByteArray(this.idLo, bArr, 8);
        return bArr;
    }

    public void copyBytesTo(byte[] bArr, int i) {
        BigendianEncoding.longToByteArray(this.idHi, bArr, i);
        BigendianEncoding.longToByteArray(this.idLo, bArr, i + 8);
    }

    public void copyLowerBase16To(char[] cArr, int i) {
        BigendianEncoding.longToBase16String(this.idHi, cArr, i);
        BigendianEncoding.longToBase16String(this.idLo, cArr, i + 16);
    }

    public boolean isValid() {
        return (this.idHi == 0 && this.idLo == 0) ? false : true;
    }

    public String toLowerBase16() {
        char[] cArr = new char[32];
        copyLowerBase16To(cArr, 0);
        return new String(cArr);
    }

    public long getLowerLong() {
        long j = this.idHi;
        return j < 0 ? -j : j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceId)) {
            return false;
        }
        TraceId traceId = (TraceId) obj;
        if (this.idHi == traceId.idHi && this.idLo == traceId.idLo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.idHi;
        long j2 = this.idLo;
        return ((((int) (j ^ (j >>> 32))) + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "TraceId{traceId=" + toLowerBase16() + "}";
    }

    public int compareTo(TraceId traceId) {
        long j = this.idHi;
        long j2 = traceId.idHi;
        if (j == j2) {
            long j3 = this.idLo;
            long j4 = traceId.idLo;
            if (j3 == j4) {
                return 0;
            }
            if (j3 < j4) {
                return -1;
            }
            return 1;
        } else if (j < j2) {
            return -1;
        } else {
            return 1;
        }
    }
}
