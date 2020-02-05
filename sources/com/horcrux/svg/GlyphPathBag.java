package com.horcrux.svg;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

class GlyphPathBag {
    private final int[][] data = new int[256][];
    private final Paint paint;
    private final ArrayList<Path> paths = new ArrayList<>();

    GlyphPathBag(Paint paint2) {
        this.paint = paint2;
        this.paths.add(new Path());
    }

    /* access modifiers changed from: package-private */
    public Path getOrCreateAndCache(char c, String str) {
        Path path;
        int index = getIndex(c);
        if (index != 0) {
            path = this.paths.get(index);
        } else {
            Path path2 = new Path();
            this.paint.getTextPath(str, 0, 1, 0.0f, 0.0f, path2);
            int[][] iArr = this.data;
            int i = c >> 8;
            int[] iArr2 = iArr[i];
            if (iArr2 == null) {
                iArr2 = new int[256];
                iArr[i] = iArr2;
            }
            iArr2[c & 255] = this.paths.size();
            this.paths.add(path2);
            path = path2;
        }
        Path path3 = new Path();
        path3.addPath(path);
        return path3;
    }

    private int getIndex(char c) {
        int[] iArr = this.data[c >> 8];
        if (iArr == null) {
            return 0;
        }
        return iArr[c & 255];
    }
}
