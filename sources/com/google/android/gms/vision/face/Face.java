package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;
    private int id;
    private float width;
    private PointF zzca;
    private float zzcb;
    private float zzcc;
    private float zzcd;
    private List<Landmark> zzce;
    private final List<Contour> zzcf;
    private float zzcg;
    private float zzch;
    private float zzci;

    public PointF getPosition() {
        return new PointF(this.zzca.x - (this.width / 2.0f), this.zzca.y - (this.height / 2.0f));
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getEulerY() {
        return this.zzcb;
    }

    public float getEulerZ() {
        return this.zzcc;
    }

    public List<Landmark> getLandmarks() {
        return this.zzce;
    }

    public List<Contour> getContours() {
        return this.zzcf;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzcg;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzch;
    }

    public float getIsSmilingProbability() {
        return this.zzci;
    }

    public int getId() {
        return this.id;
    }

    public Face(int i, PointF pointF, float f, float f2, float f3, float f4, float f5, Landmark[] landmarkArr, Contour[] contourArr, float f6, float f7, float f8) {
        this.id = i;
        this.zzca = pointF;
        this.width = f;
        this.height = f2;
        this.zzcb = f3;
        this.zzcc = f4;
        this.zzcd = f5;
        this.zzce = Arrays.asList(landmarkArr);
        this.zzcf = Arrays.asList(contourArr);
        if (f6 < 0.0f || f6 > 1.0f) {
            this.zzcg = -1.0f;
        } else {
            this.zzcg = f6;
        }
        if (f7 < 0.0f || f7 > 1.0f) {
            this.zzch = -1.0f;
        } else {
            this.zzch = f7;
        }
        if (f8 < 0.0f || f8 > 1.0f) {
            this.zzci = -1.0f;
        } else {
            this.zzci = f8;
        }
    }
}
