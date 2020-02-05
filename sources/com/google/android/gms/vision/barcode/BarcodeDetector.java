package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zze;
import com.google.android.gms.internal.vision.zzg;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

public final class BarcodeDetector extends Detector<Barcode> {
    private final zzg zzbl;

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(zzg zzg) {
        this.zzbl = zzg;
    }

    public static class Builder {
        private zze zzbm = new zze();
        private Context zze;

        public Builder(Context context) {
            this.zze = context;
        }

        public Builder setBarcodeFormats(int i) {
            this.zzbm.zzbn = i;
            return this;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new zzg(this.zze, this.zzbm));
        }
    }

    public final void release() {
        super.release();
        this.zzbl.zzp();
    }

    public final SparseArray<Barcode> detect(Frame frame) {
        Barcode[] barcodeArr;
        if (frame != null) {
            zzn zzc = zzn.zzc(frame);
            if (frame.getBitmap() != null) {
                barcodeArr = this.zzbl.zza(frame.getBitmap(), zzc);
                if (barcodeArr == null) {
                    throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                }
            } else {
                barcodeArr = this.zzbl.zza(frame.getGrayscaleImageData(), zzc);
            }
            SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArr.length);
            for (Barcode barcode : barcodeArr) {
                sparseArray.append(barcode.rawValue.hashCode(), barcode);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzbl.isOperational();
    }
}
