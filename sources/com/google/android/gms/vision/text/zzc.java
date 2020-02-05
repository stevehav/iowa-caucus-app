package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzy;

final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            i = Math.min(i, point.x);
            i3 = Math.max(i3, point.x);
            i2 = Math.min(i2, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i, i2, i3, i4);
    }

    static Point[] zza(zzy zzy) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzy.zzfb));
        double cos = Math.cos(Math.toRadians((double) zzy.zzfb));
        pointArr[0] = new Point(zzy.left, zzy.top);
        double d = (double) zzy.left;
        double d2 = (double) zzy.width;
        Double.isNaN(d2);
        Double.isNaN(d);
        double d3 = (double) zzy.top;
        double d4 = (double) zzy.width;
        Double.isNaN(d4);
        Double.isNaN(d3);
        pointArr[1] = new Point((int) (d + (d2 * cos)), (int) (d3 + (d4 * sin)));
        double d5 = (double) pointArr[1].x;
        double d6 = (double) zzy.height;
        Double.isNaN(d6);
        Double.isNaN(d5);
        int i = (int) (d5 - (d6 * sin));
        double d7 = (double) pointArr[1].y;
        double d8 = (double) zzy.height;
        Double.isNaN(d8);
        Double.isNaN(d7);
        pointArr[2] = new Point(i, (int) (d7 + (d8 * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
