package com.facebook.react.touch;

import android.graphics.Rect;
import androidx.annotation.Nullable;

public interface ReactHitSlopView {
    @Nullable
    Rect getHitSlopRect();
}
