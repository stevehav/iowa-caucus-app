package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    /* access modifiers changed from: protected */
    public int getBucketedSize(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public int getSizeInBytes(int i) {
        return i;
    }

    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        initialize();
    }

    /* access modifiers changed from: protected */
    public Bitmap alloc(int i) {
        double d = (double) i;
        Double.isNaN(d);
        return Bitmap.createBitmap(1, (int) Math.ceil(d / 2.0d), Bitmap.Config.RGB_565);
    }

    /* access modifiers changed from: protected */
    public void free(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    /* access modifiers changed from: protected */
    public int getBucketedSizeForValue(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.facebook.imagepipeline.memory.Bucket, com.facebook.imagepipeline.memory.Bucket<android.graphics.Bitmap>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getValue(com.facebook.imagepipeline.memory.Bucket<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            java.lang.Object r2 = super.getValue(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x000c
            r0 = 0
            r2.eraseColor(r0)
        L_0x000c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BucketsBitmapPool.getValue(com.facebook.imagepipeline.memory.Bucket):android.graphics.Bitmap");
    }
}
