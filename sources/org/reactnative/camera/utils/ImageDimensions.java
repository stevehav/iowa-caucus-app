package org.reactnative.camera.utils;

public class ImageDimensions {
    private int mFacing;
    private int mHeight;
    private int mRotation;
    private int mWidth;

    public ImageDimensions(int i, int i2) {
        this(i, i2, 0);
    }

    public ImageDimensions(int i, int i2, int i3) {
        this(i, i2, i3, -1);
    }

    public ImageDimensions(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mFacing = i4;
        this.mRotation = i3;
    }

    public boolean isLandscape() {
        return this.mRotation % 180 == 90;
    }

    public int getWidth() {
        if (isLandscape()) {
            return this.mHeight;
        }
        return this.mWidth;
    }

    public int getHeight() {
        if (isLandscape()) {
            return this.mWidth;
        }
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getFacing() {
        return this.mFacing;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageDimensions)) {
            return super.equals(obj);
        }
        ImageDimensions imageDimensions = (ImageDimensions) obj;
        return imageDimensions.getWidth() == getWidth() && imageDimensions.getHeight() == getHeight() && imageDimensions.getFacing() == getFacing() && imageDimensions.getRotation() == getRotation();
    }
}
