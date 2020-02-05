package com.facebook.react.views.art;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;

class PropHelper {
    PropHelper() {
    }

    @Nullable
    static float[] toFloatArray(@Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        float[] fArr = new float[readableArray.size()];
        toFloatArray(readableArray, fArr);
        return fArr;
    }

    static int toFloatArray(ReadableArray readableArray, float[] fArr) {
        int length = readableArray.size() > fArr.length ? fArr.length : readableArray.size();
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        return readableArray.size();
    }
}
