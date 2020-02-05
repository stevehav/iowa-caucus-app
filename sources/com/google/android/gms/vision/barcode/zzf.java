package com.google.android.gms.vision.barcode;

import android.os.Parcelable;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzf implements Parcelable.Creator<Barcode.ContactInfo> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0058
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x004e;
                case 3: goto L_0x0049;
                case 4: goto L_0x0044;
                case 5: goto L_0x003a;
                case 6: goto L_0x0030;
                case 7: goto L_0x002b;
                case 8: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x000c
        L_0x0021:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Address> r2 = com.google.android.gms.vision.barcode.Barcode.Address.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r1, r2)
            r9 = r1
            com.google.android.gms.vision.barcode.Barcode$Address[] r9 = (com.google.android.gms.vision.barcode.Barcode.Address[]) r9
            goto L_0x000c
        L_0x002b:
            java.lang.String[] r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r11, r1)
            goto L_0x000c
        L_0x0030:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Email> r2 = com.google.android.gms.vision.barcode.Barcode.Email.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r1, r2)
            r7 = r1
            com.google.android.gms.vision.barcode.Barcode$Email[] r7 = (com.google.android.gms.vision.barcode.Barcode.Email[]) r7
            goto L_0x000c
        L_0x003a:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Phone> r2 = com.google.android.gms.vision.barcode.Barcode.Phone.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r1, r2)
            r6 = r1
            com.google.android.gms.vision.barcode.Barcode$Phone[] r6 = (com.google.android.gms.vision.barcode.Barcode.Phone[]) r6
            goto L_0x000c
        L_0x0044:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x0049:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x004e:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$PersonName> r2 = com.google.android.gms.vision.barcode.Barcode.PersonName.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r2)
            r3 = r1
            com.google.android.gms.vision.barcode.Barcode$PersonName r3 = (com.google.android.gms.vision.barcode.Barcode.PersonName) r3
            goto L_0x000c
        L_0x0058:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.google.android.gms.vision.barcode.Barcode$ContactInfo r11 = new com.google.android.gms.vision.barcode.Barcode$ContactInfo
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.barcode.zzf.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
