package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public enum zzil {
    DOUBLE(zzio.DOUBLE, 1),
    FLOAT(zzio.FLOAT, 5),
    INT64(zzio.LONG, 0),
    UINT64(zzio.LONG, 0),
    INT32(zzio.INT, 0),
    FIXED64(zzio.LONG, 1),
    FIXED32(zzio.INT, 5),
    BOOL(zzio.BOOLEAN, 0),
    STRING(zzio.STRING, 2),
    GROUP(zzio.MESSAGE, 3),
    MESSAGE(zzio.MESSAGE, 2),
    BYTES(zzio.BYTE_STRING, 2),
    UINT32(zzio.INT, 0),
    ENUM(zzio.ENUM, 0),
    SFIXED32(zzio.INT, 5),
    SFIXED64(zzio.LONG, 1),
    SINT32(zzio.INT, 0),
    SINT64(zzio.LONG, 0);
    
    private final zzio zzs;
    private final int zzt;

    private zzil(zzio zzio, int i) {
        this.zzs = zzio;
        this.zzt = i;
    }

    public final zzio zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
