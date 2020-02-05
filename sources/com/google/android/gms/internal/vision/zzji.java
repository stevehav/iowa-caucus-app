package com.google.android.gms.internal.vision;

public enum zzji {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzeo.zzrx),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzyd;

    private zzji(Object obj) {
        this.zzyd = obj;
    }
}
