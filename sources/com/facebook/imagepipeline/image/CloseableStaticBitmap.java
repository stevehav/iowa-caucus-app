package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableStaticBitmap extends CloseableBitmap {
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private CloseableReference<Bitmap> mBitmapReference;
    private final int mExifOrientation;
    private final QualityInfo mQualityInfo;
    private final int mRotationAngle;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CloseableStaticBitmap(android.graphics.Bitmap r1, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> r2, com.facebook.imagepipeline.image.QualityInfo r3, int r4, int r5) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0.mBitmap = r1
            android.graphics.Bitmap r1 = r0.mBitmap
            java.lang.Object r2 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.references.ResourceReleaser r2 = (com.facebook.common.references.ResourceReleaser) r2
            com.facebook.common.references.CloseableReference r1 = com.facebook.common.references.CloseableReference.of(r1, r2)
            r0.mBitmapReference = r1
            r0.mQualityInfo = r3
            r0.mRotationAngle = r4
            r0.mExifOrientation = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.CloseableStaticBitmap.<init>(android.graphics.Bitmap, com.facebook.common.references.ResourceReleaser, com.facebook.imagepipeline.image.QualityInfo, int, int):void");
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.facebook.common.references.CloseableReference, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CloseableStaticBitmap(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r1, com.facebook.imagepipeline.image.QualityInfo r2, int r3, int r4) {
        /*
            r0 = this;
            r0.<init>()
            com.facebook.common.references.CloseableReference r1 = r1.cloneOrNull()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            com.facebook.common.references.CloseableReference r1 = (com.facebook.common.references.CloseableReference) r1
            r0.mBitmapReference = r1
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r1 = r0.mBitmapReference
            java.lang.Object r1 = r1.get()
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0.mBitmap = r1
            r0.mQualityInfo = r2
            r0.mRotationAngle = r3
            r0.mExifOrientation = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.CloseableStaticBitmap.<init>(com.facebook.common.references.CloseableReference, com.facebook.imagepipeline.image.QualityInfo, int, int):void");
    }

    public void close() {
        CloseableReference<Bitmap> detachBitmapReference = detachBitmapReference();
        if (detachBitmapReference != null) {
            detachBitmapReference.close();
        }
    }

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
        return detachBitmapReference();
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        return CloseableReference.cloneOrNull(this.mBitmapReference);
    }

    public synchronized boolean isClosed() {
        return this.mBitmapReference == null;
    }

    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    public int getWidth() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapHeight(this.mBitmap);
        }
        return getBitmapWidth(this.mBitmap);
    }

    public int getHeight() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapWidth(this.mBitmap);
        }
        return getBitmapHeight(this.mBitmap);
    }

    private static int getBitmapWidth(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int getBitmapHeight(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }
}
