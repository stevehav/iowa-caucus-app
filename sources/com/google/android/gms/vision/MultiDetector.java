package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    /* access modifiers changed from: private */
    public List<Detector<? extends Object>> zzax;

    public void release() {
        for (Detector<? extends Object> release : this.zzax) {
            release.release();
        }
        this.zzax.clear();
    }

    public static class Builder {
        private MultiDetector zzay = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzay.zzax.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzay.zzax.size() != 0) {
                return this.zzay;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        for (Detector<? extends Object> detect : this.zzax) {
            SparseArray detect2 = detect.detect(frame);
            int i = 0;
            while (true) {
                if (i < detect2.size()) {
                    int keyAt = detect2.keyAt(i);
                    if (sparseArray.get(keyAt) == null) {
                        sparseArray.append(keyAt, detect2.valueAt(i));
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder(104);
                        sb.append("Detection ID overlap for id = ");
                        sb.append(keyAt);
                        sb.append("  This means that one of the detectors is not using global IDs.");
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
        }
        return sparseArray;
    }

    public void receiveFrame(Frame frame) {
        for (Detector<? extends Object> receiveFrame : this.zzax) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void setProcessor(Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }

    public boolean isOperational() {
        for (Detector<? extends Object> isOperational : this.zzax) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    private MultiDetector() {
        this.zzax = new ArrayList();
    }
}
