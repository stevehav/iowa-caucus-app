package com.google.android.cameraview;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

abstract class PreviewImpl {
    private Callback mCallback;
    private int mHeight;
    private int mWidth;

    interface Callback {
        void onSurfaceChanged();

        void onSurfaceDestroyed();
    }

    /* access modifiers changed from: package-private */
    public abstract Class getOutputClass();

    /* access modifiers changed from: package-private */
    public abstract Surface getSurface();

    /* access modifiers changed from: package-private */
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public Object getSurfaceTexture() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract View getView();

    /* access modifiers changed from: package-private */
    public abstract boolean isReady();

    /* access modifiers changed from: package-private */
    public void setBufferSize(int i, int i2) {
    }

    /* access modifiers changed from: package-private */
    public abstract void setDisplayOrientation(int i);

    PreviewImpl() {
    }

    /* access modifiers changed from: package-private */
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: protected */
    public void dispatchSurfaceChanged() {
        this.mCallback.onSurfaceChanged();
    }

    /* access modifiers changed from: protected */
    public void dispatchSurfaceDestroyed() {
        this.mCallback.onSurfaceDestroyed();
    }

    /* access modifiers changed from: package-private */
    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return this.mWidth;
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return this.mHeight;
    }
}
