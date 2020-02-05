package com.google.android.gms.vision.face.internal.client;

import android.os.Parcelable;

public final class zzd implements Parcelable.Creator<FaceParcel> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new FaceParcel[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r21)
            r2 = 0
            r3 = 0
            r4 = 0
            r15 = r2
            r19 = r15
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x001b:
            int r2 = r21.dataPosition()
            if (r2 >= r1) goto L_0x0081
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r21)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x007c;
                case 2: goto L_0x0077;
                case 3: goto L_0x0072;
                case 4: goto L_0x006d;
                case 5: goto L_0x0068;
                case 6: goto L_0x0063;
                case 7: goto L_0x005e;
                case 8: goto L_0x0059;
                case 9: goto L_0x004f;
                case 10: goto L_0x004a;
                case 11: goto L_0x0045;
                case 12: goto L_0x0040;
                case 13: goto L_0x0035;
                case 14: goto L_0x0030;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001b
        L_0x0030:
            float r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0035:
            android.os.Parcelable$Creator<com.google.android.gms.vision.face.internal.client.zza> r3 = com.google.android.gms.vision.face.internal.client.zza.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r19 = r2
            com.google.android.gms.vision.face.internal.client.zza[] r19 = (com.google.android.gms.vision.face.internal.client.zza[]) r19
            goto L_0x001b
        L_0x0040:
            float r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0045:
            float r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x004a:
            float r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x004f:
            android.os.Parcelable$Creator<com.google.android.gms.vision.face.internal.client.LandmarkParcel> r3 = com.google.android.gms.vision.face.internal.client.LandmarkParcel.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r15 = r2
            com.google.android.gms.vision.face.internal.client.LandmarkParcel[] r15 = (com.google.android.gms.vision.face.internal.client.LandmarkParcel[]) r15
            goto L_0x001b
        L_0x0059:
            float r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x005e:
            float r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0063:
            float r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0068:
            float r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x006d:
            float r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0072:
            float r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x001b
        L_0x0077:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x007c:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x0081:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.vision.face.internal.client.FaceParcel r0 = new com.google.android.gms.vision.face.internal.client.FaceParcel
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.internal.client.zzd.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
