package com.facebook.react.devsupport;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class DoubleTapReloadRecognizer {
    private static final long DOUBLE_TAP_DELAY = 200;
    /* access modifiers changed from: private */
    public boolean mDoRefresh = false;

    public boolean didDoubleTapR(int i, View view) {
        if (i == 46 && !(view instanceof EditText)) {
            if (this.mDoRefresh) {
                this.mDoRefresh = false;
                return true;
            }
            this.mDoRefresh = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    boolean unused = DoubleTapReloadRecognizer.this.mDoRefresh = false;
                }
            }, DOUBLE_TAP_DELAY);
        }
        return false;
    }
}
