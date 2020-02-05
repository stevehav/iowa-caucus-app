package com.lwansbrough.RCTCamera;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

public class RCTCameraView extends ViewGroup {
    private int _actualDeviceOrientation = -1;
    private int _aspect = 1;
    private int _captureMode = 0;
    private String _captureQuality = RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH;
    private boolean _clearWindowBackground = false;
    /* access modifiers changed from: private */
    public final Context _context;
    private int _flashMode = -1;
    private final OrientationEventListener _orientationListener;
    private int _torchMode = -1;
    private RCTCameraViewFinder _viewFinder = null;
    private int _zoom = 0;

    public RCTCameraView(Context context) {
        super(context);
        this._context = context;
        RCTCamera.createInstance(getDeviceOrientation(context));
        this._orientationListener = new OrientationEventListener(context, 3) {
            public void onOrientationChanged(int i) {
                RCTCameraView rCTCameraView = RCTCameraView.this;
                if (rCTCameraView.setActualDeviceOrientation(rCTCameraView._context)) {
                    RCTCameraView.this.layoutViewFinder();
                }
            }
        };
        if (this._orientationListener.canDetectOrientation()) {
            this._orientationListener.enable();
        } else {
            this._orientationListener.disable();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutViewFinder(i, i2, i3, i4);
    }

    public void onViewAdded(View view) {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != view) {
            removeView(rCTCameraViewFinder);
            addView(this._viewFinder, 0);
        }
    }

    public void setAspect(int i) {
        this._aspect = i;
        layoutViewFinder();
    }

    public void setCameraType(int i) {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCameraType(i);
            RCTCamera.getInstance().adjustPreviewLayout(i);
            return;
        }
        this._viewFinder = new RCTCameraViewFinder(this._context, i);
        int i2 = this._flashMode;
        if (-1 != i2) {
            this._viewFinder.setFlashMode(i2);
        }
        int i3 = this._torchMode;
        if (-1 != i3) {
            this._viewFinder.setTorchMode(i3);
        }
        int i4 = this._zoom;
        if (i4 != 0) {
            this._viewFinder.setZoom(i4);
        }
        this._viewFinder.setClearWindowBackground(this._clearWindowBackground);
        addView(this._viewFinder);
    }

    public void setCaptureMode(int i) {
        this._captureMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCaptureMode(i);
        }
    }

    public void setCaptureQuality(String str) {
        this._captureQuality = str;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCaptureQuality(str);
        }
    }

    public void setTorchMode(int i) {
        this._torchMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setTorchMode(i);
        }
    }

    public void setFlashMode(int i) {
        this._flashMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setFlashMode(i);
        }
    }

    public void setZoom(int i) {
        this._zoom = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setZoom(i);
        }
    }

    public void setOrientation(int i) {
        RCTCamera.getInstance().setOrientation(i);
        if (this._viewFinder != null) {
            layoutViewFinder();
        }
    }

    public void setBarcodeScannerEnabled(boolean z) {
        RCTCamera.getInstance().setBarcodeScannerEnabled(z);
    }

    public void setBarCodeTypes(List<String> list) {
        RCTCamera.getInstance().setBarCodeTypes(list);
    }

    public void setClearWindowBackground(boolean z) {
        this._clearWindowBackground = z;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setClearWindowBackground(z);
        }
    }

    public void stopPreview() {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.stopPreview();
        }
    }

    public void startPreview() {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.startPreview();
        }
    }

    /* access modifiers changed from: private */
    public boolean setActualDeviceOrientation(Context context) {
        int deviceOrientation = getDeviceOrientation(context);
        if (this._actualDeviceOrientation == deviceOrientation) {
            return false;
        }
        this._actualDeviceOrientation = deviceOrientation;
        RCTCamera.getInstance().setActualDeviceOrientation(this._actualDeviceOrientation);
        return true;
    }

    private int getDeviceOrientation(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    /* access modifiers changed from: private */
    public void layoutViewFinder() {
        layoutViewFinder(getLeft(), getTop(), getRight(), getBottom());
    }

    private void layoutViewFinder(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        double d;
        double d2;
        double d3;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            int i7 = this._aspect;
            if (i7 == 0) {
                d2 = rCTCameraViewFinder.getRatio();
                double d4 = (double) f2;
                Double.isNaN(d4);
                d = d4 * d2;
                d3 = (double) f;
                if (d < d3) {
                    Double.isNaN(d3);
                    i5 = (int) (d3 / d2);
                    i6 = (int) f;
                    int i8 = (int) ((f - ((float) i6)) / 2.0f);
                    int i9 = (int) ((f2 - ((float) i5)) / 2.0f);
                    RCTCamera.getInstance().setPreviewVisibleSize(this._viewFinder.getCameraType(), (int) f, (int) f2);
                    this._viewFinder.layout(i8, i9, i6 + i8, i5 + i9);
                    postInvalidate(getLeft(), getTop(), getRight(), getBottom());
                }
                i6 = (int) d;
            } else if (i7 != 1) {
                i6 = (int) f;
            } else {
                d2 = rCTCameraViewFinder.getRatio();
                double d5 = (double) f2;
                Double.isNaN(d5);
                d = d5 * d2;
                d3 = (double) f;
                if (d > d3) {
                    Double.isNaN(d3);
                    i5 = (int) (d3 / d2);
                    i6 = (int) f;
                    int i82 = (int) ((f - ((float) i6)) / 2.0f);
                    int i92 = (int) ((f2 - ((float) i5)) / 2.0f);
                    RCTCamera.getInstance().setPreviewVisibleSize(this._viewFinder.getCameraType(), (int) f, (int) f2);
                    this._viewFinder.layout(i82, i92, i6 + i82, i5 + i92);
                    postInvalidate(getLeft(), getTop(), getRight(), getBottom());
                }
                i6 = (int) d;
            }
            i5 = (int) f2;
            int i822 = (int) ((f - ((float) i6)) / 2.0f);
            int i922 = (int) ((f2 - ((float) i5)) / 2.0f);
            RCTCamera.getInstance().setPreviewVisibleSize(this._viewFinder.getCameraType(), (int) f, (int) f2);
            this._viewFinder.layout(i822, i922, i6 + i822, i5 + i922);
            postInvalidate(getLeft(), getTop(), getRight(), getBottom());
        }
    }
}
