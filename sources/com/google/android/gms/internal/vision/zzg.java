package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zzg extends zzm<zzh> {
    private final zze zzbm;

    public zzg(Context context, zze zze) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.zzbm = zze;
        zzq();
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzn zzn) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzh) zzq()).zza(ObjectWrapper.wrap(byteBuffer), zzn);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(Bitmap bitmap, zzn zzn) {
        if (!isOperational()) {
            return new Barcode[0];
        }
        try {
            return ((zzh) zzq()).zzb(ObjectWrapper.wrap(bitmap), zzn);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzm() throws RemoteException {
        if (isOperational()) {
            ((zzh) zzq()).zzn();
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza(com.google.android.gms.dynamite.DynamiteModule r4, android.content.Context r5) throws android.os.RemoteException, com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r3 = this;
            java.lang.String r0 = "com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator"
            android.os.IBinder r4 = r4.instantiate(r0)
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r4 = r0
            goto L_0x001f
        L_0x000b:
            java.lang.String r1 = "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.vision.zzj
            if (r2 == 0) goto L_0x0019
            r4 = r1
            com.google.android.gms.internal.vision.zzj r4 = (com.google.android.gms.internal.vision.zzj) r4
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.vision.zzk r1 = new com.google.android.gms.internal.vision.zzk
            r1.<init>(r4)
            r4 = r1
        L_0x001f:
            if (r4 != 0) goto L_0x0022
            return r0
        L_0x0022:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            com.google.android.gms.internal.vision.zze r0 = r3.zzbm
            com.google.android.gms.internal.vision.zzh r4 = r4.zza(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzg.zza(com.google.android.gms.dynamite.DynamiteModule, android.content.Context):java.lang.Object");
    }
}
