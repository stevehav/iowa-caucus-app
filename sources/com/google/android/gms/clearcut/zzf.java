package com.google.android.gms.clearcut;

import android.os.Parcelable;

public final class zzf implements Parcelable.Creator<zze> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 1
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r11 = r9
            r10 = 1
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0055
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x004b;
                case 3: goto L_0x0046;
                case 4: goto L_0x0041;
                case 5: goto L_0x003c;
                case 6: goto L_0x0037;
                case 7: goto L_0x0032;
                case 8: goto L_0x002d;
                case 9: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000e
        L_0x0023:
            android.os.Parcelable$Creator<com.google.android.gms.phenotype.ExperimentTokens> r2 = com.google.android.gms.phenotype.ExperimentTokens.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r13, r1, r2)
            r11 = r1
            com.google.android.gms.phenotype.ExperimentTokens[] r11 = (com.google.android.gms.phenotype.ExperimentTokens[]) r11
            goto L_0x000e
        L_0x002d:
            boolean r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000e
        L_0x0032:
            byte[][] r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArrayArray(r13, r1)
            goto L_0x000e
        L_0x0037:
            int[] r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r13, r1)
            goto L_0x000e
        L_0x003c:
            java.lang.String[] r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r13, r1)
            goto L_0x000e
        L_0x0041:
            int[] r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r13, r1)
            goto L_0x000e
        L_0x0046:
            byte[] r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r13, r1)
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.clearcut.zzr> r2 = com.google.android.gms.internal.clearcut.zzr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r4 = r1
            com.google.android.gms.internal.clearcut.zzr r4 = (com.google.android.gms.internal.clearcut.zzr) r4
            goto L_0x000e
        L_0x0055:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.clearcut.zze r13 = new com.google.android.gms.clearcut.zze
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.clearcut.zzf.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
