package com.google.android.gms.internal.vision;

public enum zzjd {
    DOUBLE(zzji.DOUBLE, 1),
    FLOAT(zzji.FLOAT, 5),
    INT64(zzji.LONG, 0),
    UINT64(zzji.LONG, 0),
    INT32(zzji.INT, 0),
    FIXED64(zzji.LONG, 1),
    FIXED32(zzji.INT, 5),
    BOOL(zzji.BOOLEAN, 0),
    STRING(zzji.STRING, 2),
    GROUP(zzji.MESSAGE, 3),
    MESSAGE(zzji.MESSAGE, 2),
    BYTES(zzji.BYTE_STRING, 2),
    UINT32(zzji.INT, 0),
    ENUM(zzji.ENUM, 0),
    SFIXED32(zzji.INT, 5),
    SFIXED64(zzji.LONG, 1),
    SINT32(zzji.INT, 0),
    SINT64(zzji.LONG, 0);
    
    private final zzji zzacm;
    private final int zzacn;

    private zzjd(zzji zzji, int i) {
        this.zzacm = zzji;
        this.zzacn = i;
    }

    public final zzji zzho() {
        return this.zzacm;
    }

    public final int zzhp() {
        return this.zzacn;
    }
}
