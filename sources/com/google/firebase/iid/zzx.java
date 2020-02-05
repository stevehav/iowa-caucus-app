package com.google.firebase.iid;

final class zzx implements InstanceIdResult {
    private final String zzbu;
    private final String zzbv;

    zzx(String str, String str2) {
        this.zzbu = str;
        this.zzbv = str2;
    }

    public final String getId() {
        return this.zzbu;
    }

    public final String getToken() {
        return this.zzbv;
    }
}
