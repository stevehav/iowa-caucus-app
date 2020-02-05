package com.facebook.react.views.text;

import androidx.annotation.Nullable;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    @VisibleForTesting
    public static final String PROP_TEXT = "text";
    @Nullable
    private String mText = null;

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "text")
    public void setText(@Nullable String str) {
        this.mText = str;
        markUpdated();
    }

    @Nullable
    public String getText() {
        return this.mText;
    }

    public String toString() {
        return getViewClass() + " [text: " + this.mText + "]";
    }
}
