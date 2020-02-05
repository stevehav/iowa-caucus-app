package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public enum zzlf {
    DOUBLE(zzlm.DOUBLE, 1),
    FLOAT(zzlm.FLOAT, 5),
    INT64(zzlm.LONG, 0),
    UINT64(zzlm.LONG, 0),
    INT32(zzlm.INT, 0),
    FIXED64(zzlm.LONG, 1),
    FIXED32(zzlm.INT, 5),
    BOOL(zzlm.BOOLEAN, 0),
    STRING(zzlm.STRING, 2),
    GROUP(zzlm.MESSAGE, 3),
    MESSAGE(zzlm.MESSAGE, 2),
    BYTES(zzlm.BYTE_STRING, 2),
    UINT32(zzlm.INT, 0),
    ENUM(zzlm.ENUM, 0),
    SFIXED32(zzlm.INT, 5),
    SFIXED64(zzlm.LONG, 1),
    SINT32(zzlm.INT, 0),
    SINT64(zzlm.LONG, 0);
    
    private final zzlm zzs;
    private final int zzt;

    private zzlf(zzlm zzlm, int i) {
        this.zzs = zzlm;
        this.zzt = i;
    }

    public final zzlm zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
