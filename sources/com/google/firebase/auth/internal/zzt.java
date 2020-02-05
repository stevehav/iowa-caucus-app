package com.google.firebase.auth.internal;

import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzt implements Parcelable.Creator<zzu> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x000a:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0055
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r8 = 1
            if (r2 == r8) goto L_0x004e
            r8 = 2
            if (r2 == r8) goto L_0x0044
            r8 = 3
            if (r2 == r8) goto L_0x003f
            r8 = 4
            if (r2 == r8) goto L_0x0035
            r8 = 5
            if (r2 == r8) goto L_0x002b
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000a
        L_0x002b:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzn> r2 = com.google.firebase.auth.internal.zzn.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r7 = r1
            com.google.firebase.auth.internal.zzn r7 = (com.google.firebase.auth.internal.zzn) r7
            goto L_0x000a
        L_0x0035:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzg> r2 = com.google.firebase.auth.zzg.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r6 = r1
            com.google.firebase.auth.zzg r6 = (com.google.firebase.auth.zzg) r6
            goto L_0x000a
        L_0x003f:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r10, r1)
            goto L_0x000a
        L_0x0044:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzw> r2 = com.google.firebase.auth.internal.zzw.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r4 = r1
            com.google.firebase.auth.internal.zzw r4 = (com.google.firebase.auth.internal.zzw) r4
            goto L_0x000a
        L_0x004e:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzae> r2 = com.google.firebase.auth.zzae.CREATOR
            java.util.ArrayList r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r10, r1, r2)
            goto L_0x000a
        L_0x0055:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.firebase.auth.internal.zzu r10 = new com.google.firebase.auth.internal.zzu
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzt.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
