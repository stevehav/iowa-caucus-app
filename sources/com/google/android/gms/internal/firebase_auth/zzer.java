package com.google.android.gms.internal.firebase_auth;

import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzer implements Parcelable.Creator<zzes> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzes[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r23) {
        /*
            r22 = this;
            r0 = r23
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r23)
            r2 = 0
            r4 = 0
            r5 = 0
            r15 = r2
            r17 = r15
            r7 = r5
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r20 = r14
            r21 = r20
            r9 = 0
            r19 = 0
        L_0x001b:
            int r2 = r23.dataPosition()
            if (r2 >= r1) goto L_0x007e
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r23)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x0079;
                case 3: goto L_0x0074;
                case 4: goto L_0x006f;
                case 5: goto L_0x006a;
                case 6: goto L_0x0065;
                case 7: goto L_0x005b;
                case 8: goto L_0x0056;
                case 9: goto L_0x0051;
                case 10: goto L_0x004c;
                case 11: goto L_0x0047;
                case 12: goto L_0x0042;
                case 13: goto L_0x0037;
                case 14: goto L_0x0030;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001b
        L_0x0030:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfa> r3 = com.google.android.gms.internal.firebase_auth.zzfa.CREATOR
            java.util.ArrayList r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x001b
        L_0x0037:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzg> r3 = com.google.firebase.auth.zzg.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r20 = r2
            com.google.firebase.auth.zzg r20 = (com.google.firebase.auth.zzg) r20
            goto L_0x001b
        L_0x0042:
            boolean r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0047:
            long r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x001b
        L_0x004c:
            long r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x001b
        L_0x0051:
            java.lang.String r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x0056:
            java.lang.String r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x005b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfe> r3 = com.google.android.gms.internal.firebase_auth.zzfe.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.internal.firebase_auth.zzfe r12 = (com.google.android.gms.internal.firebase_auth.zzfe) r12
            goto L_0x001b
        L_0x0065:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x006a:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x006f:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0074:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x0079:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x007e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.internal.firebase_auth.zzes r0 = new com.google.android.gms.internal.firebase_auth.zzes
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzer.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
