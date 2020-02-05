package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zzc extends zzm<zzg> {
    private final zze zzda;

    public zzc(Context context, zze zze) {
        super(context, "FaceNativeHandle", "face");
        this.zzda = zze;
        zzq();
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzn zzn) {
        Face[] faceArr;
        FaceParcel[] faceParcelArr;
        Landmark[] landmarkArr;
        Contour[] contourArr;
        int i = 0;
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zzg) zzq()).zzc(ObjectWrapper.wrap(byteBuffer), zzn);
            Face[] faceArr2 = new Face[zzc.length];
            int i2 = 0;
            while (i2 < zzc.length) {
                FaceParcel faceParcel = zzc[i2];
                int i3 = faceParcel.id;
                PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
                float f = faceParcel.width;
                float f2 = faceParcel.height;
                float f3 = faceParcel.zzdb;
                float f4 = faceParcel.zzdc;
                float f5 = faceParcel.zzdd;
                LandmarkParcel[] landmarkParcelArr = faceParcel.zzde;
                if (landmarkParcelArr == null) {
                    faceParcelArr = zzc;
                    faceArr = faceArr2;
                    landmarkArr = new Landmark[i];
                } else {
                    landmarkArr = new Landmark[landmarkParcelArr.length];
                    int i4 = 0;
                    while (i4 < landmarkParcelArr.length) {
                        LandmarkParcel landmarkParcel = landmarkParcelArr[i4];
                        landmarkArr[i4] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
                        i4++;
                        zzc = zzc;
                        faceArr2 = faceArr2;
                        landmarkParcelArr = landmarkParcelArr;
                    }
                    faceParcelArr = zzc;
                    faceArr = faceArr2;
                }
                zza[] zzaArr = faceParcel.zzdf;
                if (zzaArr == null) {
                    contourArr = new Contour[0];
                } else {
                    Contour[] contourArr2 = new Contour[zzaArr.length];
                    for (int i5 = 0; i5 < zzaArr.length; i5++) {
                        zza zza = zzaArr[i5];
                        contourArr2[i5] = new Contour(zza.zzcz, zza.type);
                    }
                    contourArr = contourArr2;
                }
                faceArr[i2] = new Face(i3, pointF, f, f2, f3, f4, f5, landmarkArr, contourArr, faceParcel.zzcg, faceParcel.zzch, faceParcel.zzci);
                i2++;
                zzc = faceParcelArr;
                faceArr2 = faceArr;
                i = 0;
            }
            return faceArr2;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public final boolean zzd(int i) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zzg) zzq()).zzd(i);
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzm() throws RemoteException {
        ((zzg) zzq()).zzn();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzj zzj;
        if (zzp.zza(context, "com.google.android.gms.vision.dynamite.face")) {
            zzj = zzk.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.NativeFaceDetectorV2Creator"));
        } else {
            zzj = zzk.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
        }
        if (zzj == null) {
            return null;
        }
        return zzj.newFaceDetector(ObjectWrapper.wrap(context), this.zzda);
    }
}
