package com.google.android.gms.internal.clearcut;

public enum zzfl {
    DOUBLE(zzfq.DOUBLE, 1),
    FLOAT(zzfq.FLOAT, 5),
    INT64(zzfq.LONG, 0),
    UINT64(zzfq.LONG, 0),
    INT32(zzfq.INT, 0),
    FIXED64(zzfq.LONG, 1),
    FIXED32(zzfq.INT, 5),
    BOOL(zzfq.BOOLEAN, 0),
    STRING(zzfq.STRING, 2),
    GROUP(zzfq.MESSAGE, 3),
    MESSAGE(zzfq.MESSAGE, 2),
    BYTES(zzfq.BYTE_STRING, 2),
    UINT32(zzfq.INT, 0),
    ENUM(zzfq.ENUM, 0),
    SFIXED32(zzfq.INT, 5),
    SFIXED64(zzfq.LONG, 1),
    SINT32(zzfq.INT, 0),
    SINT64(zzfq.LONG, 0);
    
    private final zzfq zzqu;
    private final int zzqv;

    private zzfl(zzfq zzfq, int i) {
        this.zzqu = zzfq;
        this.zzqv = i;
    }

    public final zzfq zzek() {
        return this.zzqu;
    }

    public final int zzel() {
        return this.zzqv;
    }
}
