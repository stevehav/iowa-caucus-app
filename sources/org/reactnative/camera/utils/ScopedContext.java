package org.reactnative.camera.utils;

import android.content.Context;
import java.io.File;

public class ScopedContext {
    private File cacheDirectory = null;

    public ScopedContext(Context context) {
        createCacheDirectory(context);
    }

    public void createCacheDirectory(Context context) {
        this.cacheDirectory = new File(context.getCacheDir() + "/Camera/");
    }

    public File getCacheDirectory() {
        return this.cacheDirectory;
    }
}
