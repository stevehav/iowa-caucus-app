package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zze;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int CONTOUR_LANDMARKS = 2;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    public static final int SELFIE_MODE = 2;
    private final Object lock;
    private final zzc zzcj;
    @GuardedBy("lock")
    private final com.google.android.gms.vision.face.internal.client.zzc zzck;
    @GuardedBy("lock")
    private boolean zzcl;

    public final void release() {
        super.release();
        synchronized (this.lock) {
            if (this.zzcl) {
                this.zzck.zzp();
                this.zzcl = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this.lock) {
                if (this.zzcl) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public static class Builder {
        private int landmarkType = 0;
        private int mode = 0;
        private float proportionalMinFaceSize = -1.0f;
        private boolean trackingEnabled = true;
        private boolean zzcm = false;
        private int zzcn = 0;
        private final Context zze;

        public Builder(Context context) {
            this.zze = context;
        }

        public Builder setLandmarkType(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.landmarkType = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid landmark type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setProminentFaceOnly(boolean z) {
            this.zzcm = z;
            return this;
        }

        public Builder setClassificationType(int i) {
            if (i == 0 || i == 1) {
                this.zzcn = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Invalid classification type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setTrackingEnabled(boolean z) {
            this.trackingEnabled = z;
            return this;
        }

        public Builder setMode(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.mode = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid mode: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setMinFaceSize(float f) {
            if (f < 0.0f || f > 1.0f) {
                StringBuilder sb = new StringBuilder(47);
                sb.append("Invalid proportional face size: ");
                sb.append(f);
                throw new IllegalArgumentException(sb.toString());
            }
            this.proportionalMinFaceSize = f;
            return this;
        }

        public FaceDetector build() {
            zze zze2 = new zze();
            zze2.mode = this.mode;
            zze2.landmarkType = this.landmarkType;
            zze2.zzcn = this.zzcn;
            zze2.zzcm = this.zzcm;
            zze2.trackingEnabled = this.trackingEnabled;
            zze2.proportionalMinFaceSize = this.proportionalMinFaceSize;
            if (FaceDetector.zza(zze2)) {
                return new FaceDetector(new com.google.android.gms.vision.face.internal.client.zzc(this.zze, zze2));
            }
            throw new IllegalArgumentException("Invalid build options");
        }
    }

    public final SparseArray<Face> detect(Frame frame) {
        ByteBuffer byteBuffer;
        Face[] zzb;
        if (frame != null) {
            if (frame.getBitmap() != null) {
                Bitmap bitmap = frame.getBitmap();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = width * height;
                byteBuffer = ByteBuffer.allocateDirect(((((width + 1) / 2) * ((height + 1) / 2)) << 1) + i);
                int i2 = i;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = i3 % width;
                    int i5 = i3 / width;
                    int pixel = bitmap.getPixel(i4, i5);
                    float red = (float) Color.red(pixel);
                    float green = (float) Color.green(pixel);
                    float blue = (float) Color.blue(pixel);
                    byteBuffer.put(i3, (byte) ((int) ((0.299f * red) + (0.587f * green) + (0.114f * blue))));
                    if (i5 % 2 == 0 && i4 % 2 == 0) {
                        int i6 = i2 + 1;
                        byteBuffer.put(i2, (byte) ((int) ((-0.169f * red) + (-0.331f * green) + (blue * 0.5f) + 128.0f)));
                        i2 = i6 + 1;
                        byteBuffer.put(i6, (byte) ((int) ((red * 0.5f) + (green * -0.419f) + (blue * -0.081f) + 128.0f)));
                    }
                }
            } else {
                byteBuffer = frame.getGrayscaleImageData();
            }
            synchronized (this.lock) {
                if (this.zzcl) {
                    zzb = this.zzck.zzb(byteBuffer, zzn.zzc(frame));
                } else {
                    throw new RuntimeException("Cannot use detector after release()");
                }
            }
            HashSet hashSet = new HashSet();
            SparseArray<Face> sparseArray = new SparseArray<>(zzb.length);
            int i7 = 0;
            for (Face face : zzb) {
                int id = face.getId();
                i7 = Math.max(i7, id);
                if (hashSet.contains(Integer.valueOf(id))) {
                    id = i7 + 1;
                    i7 = id;
                }
                hashSet.add(Integer.valueOf(id));
                sparseArray.append(this.zzcj.zzb(id), face);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean setFocus(int i) {
        boolean zzd;
        int zzc = this.zzcj.zzc(i);
        synchronized (this.lock) {
            if (this.zzcl) {
                zzd = this.zzck.zzd(zzc);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzd;
    }

    public final boolean isOperational() {
        return this.zzck.isOperational();
    }

    private FaceDetector() {
        this.zzcj = new zzc();
        this.lock = new Object();
        this.zzcl = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(com.google.android.gms.vision.face.internal.client.zzc zzc) {
        this.zzcj = new zzc();
        this.lock = new Object();
        this.zzcl = true;
        this.zzck = zzc;
    }

    /* access modifiers changed from: private */
    public static boolean zza(zze zze) {
        boolean z;
        if (zze.mode == 2 || zze.landmarkType != 2) {
            z = true;
        } else {
            Log.e("FaceDetector", "Contour is not supported for non-SELFIE mode.");
            z = false;
        }
        if (zze.landmarkType != 2 || zze.zzcn != 1) {
            return z;
        }
        Log.e("FaceDetector", "Classification is not supported with contour.");
        return false;
    }
}
