package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzak extends zzm<zzaa> {
    private final zzal zzfa;

    public zzak(Context context, zzal zzal) {
        super(context, "TextNativeHandle", "text");
        this.zzfa = zzal;
        zzq();
    }

    public final zzae[] zza(Bitmap bitmap, zzn zzn, zzag zzag) {
        if (!isOperational()) {
            return new zzae[0];
        }
        try {
            return ((zzaa) zzq()).zza(ObjectWrapper.wrap(bitmap), zzn, zzag);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzae[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzm() throws RemoteException {
        ((zzaa) zzq()).zzs();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza(com.google.android.gms.dynamite.DynamiteModule r4, android.content.Context r5) throws android.os.RemoteException, com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r3 = this;
            java.lang.String r0 = "com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator"
            android.os.IBinder r4 = r4.instantiate(r0)
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r4 = r0
            goto L_0x001f
        L_0x000b:
            java.lang.String r1 = "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.vision.zzac
            if (r2 == 0) goto L_0x0019
            r4 = r1
            com.google.android.gms.internal.vision.zzac r4 = (com.google.android.gms.internal.vision.zzac) r4
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.vision.zzad r1 = new com.google.android.gms.internal.vision.zzad
            r1.<init>(r4)
            r4 = r1
        L_0x001f:
            if (r4 != 0) goto L_0x0022
            return r0
        L_0x0022:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            com.google.android.gms.internal.vision.zzal r0 = r3.zzfa
            com.google.android.gms.internal.vision.zzaa r4 = r4.zza(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzak.zza(com.google.android.gms.dynamite.DynamiteModule, android.content.Context):java.lang.Object");
    }
}
