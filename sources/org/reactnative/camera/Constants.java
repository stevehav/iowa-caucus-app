package org.reactnative.camera;

import com.google.android.cameraview.AspectRatio;

public interface Constants {
    public static final AspectRatio DEFAULT_ASPECT_RATIO = AspectRatio.of(4, 3);
    public static final int FACING_BACK = 0;
    public static final int FACING_FRONT = 1;
    public static final int FLASH_AUTO = 3;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final int FLASH_RED_EYE = 4;
    public static final int FLASH_TORCH = 2;
    public static final int LANDSCAPE_270 = 270;
    public static final int LANDSCAPE_90 = 90;
    public static final int ORIENTATION_AUTO = 0;
    public static final int ORIENTATION_DOWN = 2;
    public static final int ORIENTATION_LEFT = 3;
    public static final int ORIENTATION_RIGHT = 4;
    public static final int ORIENTATION_UP = 1;
    public static final int WB_AUTO = 0;
    public static final int WB_CLOUDY = 1;
    public static final int WB_FLUORESCENT = 4;
    public static final int WB_INCANDESCENT = 5;
    public static final int WB_SHADOW = 3;
    public static final int WB_SUNNY = 2;
}
