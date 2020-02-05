package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzah extends zzai {
    private final char zza;

    zzah(char c) {
        this.zza = c;
    }

    public final boolean zza(char c) {
        return c == this.zza;
    }

    public final String toString() {
        String zzb = zzaf.zzc(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zzb);
        sb.append("')");
        return sb.toString();
    }
}
