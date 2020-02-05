package com.google.android.gms.internal.firebase_auth;

import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzds implements Parcelable.Creator<zzdp> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdp[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r3 = 0
            r6 = r2
            r7 = r6
            r8 = r7
            r9 = r3
            r11 = 0
            r12 = 0
        L_0x000e:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x0046
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x003c;
                case 2: goto L_0x0037;
                case 3: goto L_0x0032;
                case 4: goto L_0x002d;
                case 5: goto L_0x0028;
                case 6: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000e
        L_0x0023:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x000e
        L_0x0028:
            boolean r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x000e
        L_0x002d:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x000e
        L_0x0032:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000e
        L_0x0037:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000e
        L_0x003c:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzae> r2 = com.google.firebase.auth.zzae.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r6 = r1
            com.google.firebase.auth.zzae r6 = (com.google.firebase.auth.zzae) r6
            goto L_0x000e
        L_0x0046:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.internal.firebase_auth.zzdp r14 = new com.google.android.gms.internal.firebase_auth.zzdp
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzds.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
