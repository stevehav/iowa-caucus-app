package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;

public class MultiProcessor<T> implements Detector.Processor<T> {
    /* access modifiers changed from: private */
    public int zzal;
    /* access modifiers changed from: private */
    public Factory<T> zzaz;
    private SparseArray<zza> zzba;

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    public void release() {
        for (int i = 0; i < this.zzba.size(); i++) {
            this.zzba.valueAt(i).zzak.onDone();
        }
        this.zzba.clear();
    }

    class zza {
        /* access modifiers changed from: private */
        public Tracker<T> zzak;
        /* access modifiers changed from: private */
        public int zzao;

        private zza(MultiProcessor multiProcessor) {
            this.zzao = 0;
        }

        static /* synthetic */ int zzb(zza zza) {
            int i = zza.zzao;
            zza.zzao = i + 1;
            return i;
        }
    }

    public static class Builder<T> {
        private MultiProcessor<T> zzbb = new MultiProcessor<>();

        public Builder(Factory<T> factory) {
            if (factory != null) {
                Factory unused = this.zzbb.zzaz = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                int unused = this.zzbb.zzal = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid max gap: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public MultiProcessor<T> build() {
            return this.zzbb;
        }
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            if (this.zzba.get(keyAt) == null) {
                zza zza2 = new zza();
                Tracker unused = zza2.zzak = this.zzaz.create(valueAt);
                zza2.zzak.onNewItem(keyAt, valueAt);
                this.zzba.append(keyAt, zza2);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i2 = 0; i2 < this.zzba.size(); i2++) {
            int keyAt2 = this.zzba.keyAt(i2);
            if (detectedItems2.get(keyAt2) == null) {
                zza valueAt2 = this.zzba.valueAt(i2);
                zza.zzb(valueAt2);
                if (valueAt2.zzao >= this.zzal) {
                    valueAt2.zzak.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.zzak.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzba.delete(intValue.intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int keyAt3 = detectedItems3.keyAt(i3);
            T valueAt3 = detectedItems3.valueAt(i3);
            zza zza3 = this.zzba.get(keyAt3);
            int unused2 = zza3.zzao = 0;
            zza3.zzak.onUpdate(detections, valueAt3);
        }
    }

    private MultiProcessor() {
        this.zzba = new SparseArray<>();
        this.zzal = 3;
    }
}
