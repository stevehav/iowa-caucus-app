package com.google.android.gms.internal.vision;

import android.os.Parcelable;

public final class zzao implements Parcelable.Creator<zzan> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzan[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 0
            r3 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r10 = r8
            r9 = 0
            r11 = 0
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0055
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x004b;
                case 3: goto L_0x0041;
                case 4: goto L_0x0037;
                case 5: goto L_0x0032;
                case 6: goto L_0x002d;
                case 7: goto L_0x0028;
                case 8: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000e
        L_0x0023:
            boolean r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000e
        L_0x0028:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x002d:
            float r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r13, r1)
            goto L_0x000e
        L_0x0032:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x0037:
            android.os.Parcelable$Creator<com.google.android.gms.internal.vision.zzy> r2 = com.google.android.gms.internal.vision.zzy.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r7 = r1
            com.google.android.gms.internal.vision.zzy r7 = (com.google.android.gms.internal.vision.zzy) r7
            goto L_0x000e
        L_0x0041:
            android.os.Parcelable$Creator<com.google.android.gms.internal.vision.zzy> r2 = com.google.android.gms.internal.vision.zzy.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r6 = r1
            com.google.android.gms.internal.vision.zzy r6 = (com.google.android.gms.internal.vision.zzy) r6
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.vision.zzai> r2 = com.google.android.gms.internal.vision.zzai.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r13, r1, r2)
            r5 = r1
            com.google.android.gms.internal.vision.zzai[] r5 = (com.google.android.gms.internal.vision.zzai[]) r5
            goto L_0x000e
        L_0x0055:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.internal.vision.zzan r13 = new com.google.android.gms.internal.vision.zzan
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzao.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
