package org.reactnative.frame;

import android.graphics.Bitmap;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;
import org.reactnative.camera.utils.ImageDimensions;

public class RNFrameFactory {
    public static RNFrame buildFrame(byte[] bArr, int i, int i2, int i3) {
        Frame.Builder builder = new Frame.Builder();
        builder.setImageData(ByteBuffer.wrap(bArr), i, i2, 17);
        if (i3 == 90) {
            builder.setRotation(1);
        } else if (i3 == 180) {
            builder.setRotation(2);
        } else if (i3 != 270) {
            builder.setRotation(0);
        } else {
            builder.setRotation(3);
        }
        return new RNFrame(builder.build(), new ImageDimensions(i, i2, i3));
    }

    public static RNFrame buildFrame(Bitmap bitmap) {
        Frame.Builder builder = new Frame.Builder();
        builder.setBitmap(bitmap);
        return new RNFrame(builder.build(), new ImageDimensions(bitmap.getWidth(), bitmap.getHeight()));
    }
}
