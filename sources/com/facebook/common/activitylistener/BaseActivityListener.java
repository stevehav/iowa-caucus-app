package com.facebook.common.activitylistener;

import android.app.Activity;

public class BaseActivityListener implements ActivityListener {
    public int getPriority() {
        return 1;
    }

    public void onActivityCreate(Activity activity) {
    }

    public void onDestroy(Activity activity) {
    }

    public void onPause(Activity activity) {
    }

    public void onResume(Activity activity) {
    }

    public void onStart(Activity activity) {
    }

    public void onStop(Activity activity) {
    }
}
