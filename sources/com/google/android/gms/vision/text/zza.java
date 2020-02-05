package com.google.android.gms.vision.text;

import java.util.Comparator;
import java.util.Map;

final class zza implements Comparator<Map.Entry<String, Integer>> {
    zza(TextBlock textBlock) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
    }
}
