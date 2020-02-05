package com.facebook.drawee.backends.pipeline.info;

import androidx.core.os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? EnvironmentCompat.MEDIA_UNKNOWN : "error" : "canceled" : FirebaseAnalytics.Param.SUCCESS : "intermediate_available" : "origin_available" : "requested";
    }

    private ImagePerfUtils() {
    }
}
