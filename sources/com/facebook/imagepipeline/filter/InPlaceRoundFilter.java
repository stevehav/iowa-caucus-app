package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public final class InPlaceRoundFilter {
    private InPlaceRoundFilter() {
    }

    public static void roundBitmapInPlace(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height) / 2;
        int i = width / 2;
        int i2 = height / 2;
        if (min != 0) {
            Preconditions.checkArgument(min >= 1);
            Preconditions.checkArgument(width > 0 && ((float) width) <= 2048.0f);
            Preconditions.checkArgument(height > 0 && ((float) height) <= 2048.0f);
            Preconditions.checkArgument(i > 0 && i < width);
            Preconditions.checkArgument(i2 > 0 && i2 < height);
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i3 = min - 1;
            Preconditions.checkArgument(i - i3 >= 0 && i2 - i3 >= 0 && i + i3 < width && i2 + i3 < height);
            int i4 = (-min) * 2;
            int[] iArr2 = new int[width];
            int i5 = i4 + 1;
            int i6 = 0;
            int i7 = 1;
            int i8 = 1;
            while (i3 >= i6) {
                int i9 = i + i3;
                int i10 = i - i3;
                int i11 = i + i6;
                int i12 = min;
                int i13 = i - i6;
                int i14 = i2 + i3;
                int i15 = i2 - i3;
                int i16 = i;
                int i17 = i2 + i6;
                int i18 = i2 - i6;
                Preconditions.checkArgument(i3 >= 0 && i11 < width && i13 >= 0 && i17 < height && i18 >= 0);
                int i19 = i17 * width;
                int i20 = height;
                int i21 = width * i18;
                int i22 = i2;
                int i23 = width * i14;
                int i24 = i4;
                int i25 = width * i15;
                int i26 = i7;
                System.arraycopy(iArr2, 0, iArr, i19, i10);
                System.arraycopy(iArr2, 0, iArr, i21, i10);
                System.arraycopy(iArr2, 0, iArr, i23, i13);
                System.arraycopy(iArr2, 0, iArr, i25, i13);
                int i27 = width - i9;
                System.arraycopy(iArr2, 0, iArr, i19 + i9, i27);
                System.arraycopy(iArr2, 0, iArr, i21 + i9, i27);
                int i28 = width - i11;
                System.arraycopy(iArr2, 0, iArr, i23 + i11, i28);
                System.arraycopy(iArr2, 0, iArr, i25 + i11, i28);
                if (i5 <= 0) {
                    i6++;
                    i8 += 2;
                    i5 += i8;
                }
                if (i5 > 0) {
                    i3--;
                    i7 = i26 + 2;
                    i5 += i7 + i24;
                    min = i12;
                    i4 = i24;
                } else {
                    min = i12;
                    i4 = i24;
                    i7 = i26;
                }
                i = i16;
                i2 = i22;
                height = i20;
            }
            int i29 = height;
            int i30 = min;
            int i31 = i2;
            for (int i32 = i31 - i30; i32 >= 0; i32--) {
                System.arraycopy(iArr2, 0, iArr, i32 * width, width);
            }
            int i33 = i29;
            for (int i34 = i31 + i30; i34 < i33; i34++) {
                System.arraycopy(iArr2, 0, iArr, i34 * width, width);
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, i33);
        }
    }
}
