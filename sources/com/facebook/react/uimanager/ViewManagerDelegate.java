package com.facebook.react.uimanager;

import android.view.View;
import androidx.annotation.Nullable;

public interface ViewManagerDelegate<T extends View> {
    void setProperty(T t, String str, @Nullable Object obj);
}
