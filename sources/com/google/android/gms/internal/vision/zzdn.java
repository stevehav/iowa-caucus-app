package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzdn extends zzjn<zzdn> {
    public Integer zzow;
    public Integer zzox;
    public Integer zzoy;
    public Boolean zzoz = null;
    public Boolean zzpa = null;
    public Float zzpb = null;

    public zzdn() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        Integer num = this.zzow;
        if (num != null) {
            zzjl.zze(1, num.intValue());
        }
        Integer num2 = this.zzox;
        if (num2 != null) {
            zzjl.zze(2, num2.intValue());
        }
        Integer num3 = this.zzoy;
        if (num3 != null) {
            zzjl.zze(3, num3.intValue());
        }
        Boolean bool = this.zzoz;
        if (bool != null) {
            zzjl.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzpa;
        if (bool2 != null) {
            zzjl.zzb(5, bool2.booleanValue());
        }
        Float f = this.zzpb;
        if (f != null) {
            zzjl.zza(6, f.floatValue());
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzow;
        if (num != null) {
            zzt += zzjl.zzi(1, num.intValue());
        }
        Integer num2 = this.zzox;
        if (num2 != null) {
            zzt += zzjl.zzi(2, num2.intValue());
        }
        Integer num3 = this.zzoy;
        if (num3 != null) {
            zzt += zzjl.zzi(3, num3.intValue());
        }
        Boolean bool = this.zzoz;
        if (bool != null) {
            bool.booleanValue();
            zzt += zzjl.zzav(4) + 1;
        }
        Boolean bool2 = this.zzpa;
        if (bool2 != null) {
            bool2.booleanValue();
            zzt += zzjl.zzav(5) + 1;
        }
        Float f = this.zzpb;
        if (f == null) {
            return zzt;
        }
        f.floatValue();
        return zzt + zzjl.zzav(6) + 4;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        throw new java.lang.IllegalArgumentException(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
        throw new java.lang.IllegalArgumentException(r5.toString());
     */
    /* renamed from: zzd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.vision.zzdn zza(com.google.android.gms.internal.vision.zzjk r7) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r7.zzdq()
            if (r0 == 0) goto L_0x00e7
            r1 = 8
            r2 = 3
            if (r0 == r1) goto L_0x00b2
            r1 = 16
            r3 = 40
            if (r0 == r1) goto L_0x007f
            r1 = 24
            if (r0 == r1) goto L_0x004b
            r1 = 32
            if (r0 == r1) goto L_0x0040
            if (r0 == r3) goto L_0x0035
            r1 = 53
            if (r0 == r1) goto L_0x0026
            boolean r0 = super.zza(r7, r0)
            if (r0 != 0) goto L_0x0000
            return r6
        L_0x0026:
            int r0 = r7.zzdv()
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r6.zzpb = r0
            goto L_0x0000
        L_0x0035:
            boolean r0 = r7.zzcu()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzpa = r0
            goto L_0x0000
        L_0x0040:
            boolean r0 = r7.zzcu()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzoz = r0
            goto L_0x0000
        L_0x004b:
            int r1 = r7.getPosition()
            int r2 = r7.zzdt()     // Catch:{ IllegalArgumentException -> 0x0078 }
            if (r2 < 0) goto L_0x005f
            r3 = 2
            if (r2 > r3) goto L_0x005f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0078 }
            r6.zzoy = r2     // Catch:{ IllegalArgumentException -> 0x0078 }
            goto L_0x0000
        L_0x005f:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0078 }
            r4 = 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0078 }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0078 }
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0078 }
            java.lang.String r2 = " is not a valid enum Classification"
            r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0078 }
            java.lang.String r2 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x0078 }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0078 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0078 }
        L_0x0078:
            r7.zzbt(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x007f:
            int r1 = r7.getPosition()
            int r4 = r7.zzdt()     // Catch:{ IllegalArgumentException -> 0x00aa }
            if (r4 < 0) goto L_0x0093
            if (r4 > r2) goto L_0x0093
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalArgumentException -> 0x00aa }
            r6.zzox = r2     // Catch:{ IllegalArgumentException -> 0x00aa }
            goto L_0x0000
        L_0x0093:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00aa }
            r5.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00aa }
            r5.append(r4)     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.String r3 = " is not a valid enum Landmark"
            r5.append(r3)     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.String r3 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x00aa }
            r2.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00aa }
            throw r2     // Catch:{ IllegalArgumentException -> 0x00aa }
        L_0x00aa:
            r7.zzbt(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x00b2:
            int r1 = r7.getPosition()
            int r3 = r7.zzdt()     // Catch:{ IllegalArgumentException -> 0x00df }
            if (r3 < 0) goto L_0x00c6
            if (r3 > r2) goto L_0x00c6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x00df }
            r6.zzow = r2     // Catch:{ IllegalArgumentException -> 0x00df }
            goto L_0x0000
        L_0x00c6:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00df }
            r4 = 36
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00df }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x00df }
            r5.append(r3)     // Catch:{ IllegalArgumentException -> 0x00df }
            java.lang.String r3 = " is not a valid enum Mode"
            r5.append(r3)     // Catch:{ IllegalArgumentException -> 0x00df }
            java.lang.String r3 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x00df }
            r2.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00df }
            throw r2     // Catch:{ IllegalArgumentException -> 0x00df }
        L_0x00df:
            r7.zzbt(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x00e7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzdn.zza(com.google.android.gms.internal.vision.zzjk):com.google.android.gms.internal.vision.zzdn");
    }
}
