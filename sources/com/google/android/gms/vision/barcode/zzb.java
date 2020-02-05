package com.google.android.gms.vision.barcode;

import android.os.Parcelable;

public final class zzb implements Parcelable.Creator<Barcode> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v12, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r20) {
        /*
            r19 = this;
            r0 = r20
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r20)
            r2 = 0
            r3 = 0
            r6 = r3
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r5 = 0
            r8 = 0
        L_0x0019:
            int r2 = r20.dataPosition()
            if (r2 >= r1) goto L_0x00ad
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r20)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x00a7;
                case 3: goto L_0x00a1;
                case 4: goto L_0x009b;
                case 5: goto L_0x0095;
                case 6: goto L_0x008b;
                case 7: goto L_0x0081;
                case 8: goto L_0x0077;
                case 9: goto L_0x006d;
                case 10: goto L_0x0063;
                case 11: goto L_0x0059;
                case 12: goto L_0x004f;
                case 13: goto L_0x0044;
                case 14: goto L_0x0039;
                case 15: goto L_0x002e;
                default: goto L_0x002a;
            }
        L_0x002a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0019
        L_0x002e:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$DriverLicense> r3 = com.google.android.gms.vision.barcode.Barcode.DriverLicense.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r18 = r2
            com.google.android.gms.vision.barcode.Barcode$DriverLicense r18 = (com.google.android.gms.vision.barcode.Barcode.DriverLicense) r18
            goto L_0x0019
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$ContactInfo> r3 = com.google.android.gms.vision.barcode.Barcode.ContactInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r17 = r2
            com.google.android.gms.vision.barcode.Barcode$ContactInfo r17 = (com.google.android.gms.vision.barcode.Barcode.ContactInfo) r17
            goto L_0x0019
        L_0x0044:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$CalendarEvent> r3 = com.google.android.gms.vision.barcode.Barcode.CalendarEvent.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r16 = r2
            com.google.android.gms.vision.barcode.Barcode$CalendarEvent r16 = (com.google.android.gms.vision.barcode.Barcode.CalendarEvent) r16
            goto L_0x0019
        L_0x004f:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$GeoPoint> r3 = com.google.android.gms.vision.barcode.Barcode.GeoPoint.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r15 = r2
            com.google.android.gms.vision.barcode.Barcode$GeoPoint r15 = (com.google.android.gms.vision.barcode.Barcode.GeoPoint) r15
            goto L_0x0019
        L_0x0059:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$UrlBookmark> r3 = com.google.android.gms.vision.barcode.Barcode.UrlBookmark.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            com.google.android.gms.vision.barcode.Barcode$UrlBookmark r14 = (com.google.android.gms.vision.barcode.Barcode.UrlBookmark) r14
            goto L_0x0019
        L_0x0063:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$WiFi> r3 = com.google.android.gms.vision.barcode.Barcode.WiFi.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            com.google.android.gms.vision.barcode.Barcode$WiFi r13 = (com.google.android.gms.vision.barcode.Barcode.WiFi) r13
            goto L_0x0019
        L_0x006d:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Sms> r3 = com.google.android.gms.vision.barcode.Barcode.Sms.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.vision.barcode.Barcode$Sms r12 = (com.google.android.gms.vision.barcode.Barcode.Sms) r12
            goto L_0x0019
        L_0x0077:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Phone> r3 = com.google.android.gms.vision.barcode.Barcode.Phone.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            com.google.android.gms.vision.barcode.Barcode$Phone r11 = (com.google.android.gms.vision.barcode.Barcode.Phone) r11
            goto L_0x0019
        L_0x0081:
            android.os.Parcelable$Creator<com.google.android.gms.vision.barcode.Barcode$Email> r3 = com.google.android.gms.vision.barcode.Barcode.Email.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.vision.barcode.Barcode$Email r10 = (com.google.android.gms.vision.barcode.Barcode.Email) r10
            goto L_0x0019
        L_0x008b:
            android.os.Parcelable$Creator r3 = android.graphics.Point.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r9 = r2
            android.graphics.Point[] r9 = (android.graphics.Point[]) r9
            goto L_0x0019
        L_0x0095:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0019
        L_0x009b:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0019
        L_0x00a1:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0019
        L_0x00a7:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0019
        L_0x00ad:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.vision.barcode.Barcode r0 = new com.google.android.gms.vision.barcode.Barcode
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.barcode.zzb.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
