package com.google.android.cameraview;

import androidx.collection.ArrayMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class SizeMap {
    private final ArrayMap<AspectRatio, SortedSet<Size>> mRatios = new ArrayMap<>();

    SizeMap() {
    }

    public boolean add(Size size) {
        for (AspectRatio next : this.mRatios.keySet()) {
            if (next.matches(size)) {
                SortedSet sortedSet = this.mRatios.get(next);
                if (sortedSet.contains(size)) {
                    return false;
                }
                sortedSet.add(size);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(size);
        this.mRatios.put(AspectRatio.of(size.getWidth(), size.getHeight()), treeSet);
        return true;
    }

    public void remove(AspectRatio aspectRatio) {
        this.mRatios.remove(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> ratios() {
        return this.mRatios.keySet();
    }

    /* access modifiers changed from: package-private */
    public SortedSet<Size> sizes(AspectRatio aspectRatio) {
        return this.mRatios.get(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mRatios.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.mRatios.isEmpty();
    }
}
