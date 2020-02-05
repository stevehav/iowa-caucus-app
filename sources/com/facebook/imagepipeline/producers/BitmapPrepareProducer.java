package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "BitmapPrepareProducer";
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final int mMaxBitmapSizeBytes;
    private final int mMinBitmapSizeBytes;
    private final boolean mPreparePrefetch;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BitmapPrepareProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r2, int r3, int r4, boolean r5) {
        /*
            r1 = this;
            r1.<init>()
            if (r3 > r4) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            com.facebook.common.internal.Preconditions.checkArgument(r0)
            java.lang.Object r2 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.imagepipeline.producers.Producer r2 = (com.facebook.imagepipeline.producers.Producer) r2
            r1.mInputProducer = r2
            r1.mMinBitmapSizeBytes = r3
            r1.mMaxBitmapSizeBytes = r4
            r1.mPreparePrefetch = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.BitmapPrepareProducer.<init>(com.facebook.imagepipeline.producers.Producer, int, int, boolean):void");
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        if (!producerContext.isPrefetch() || this.mPreparePrefetch) {
            this.mInputProducer.produceResults(new BitmapPrepareConsumer(consumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), producerContext);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    private static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final int mMaxBitmapSizeBytes;
        private final int mMinBitmapSizeBytes;

        BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> consumer, int i, int i2) {
            super(consumer);
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            internalPrepareBitmap(closeableReference);
            getConsumer().onNewResult(closeableReference, i);
        }

        private void internalPrepareBitmap(CloseableReference<CloseableImage> closeableReference) {
            CloseableImage closeableImage;
            Bitmap underlyingBitmap;
            int rowBytes;
            if (closeableReference != null && closeableReference.isValid() && (closeableImage = closeableReference.get()) != null && !closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null && (rowBytes = underlyingBitmap.getRowBytes() * underlyingBitmap.getHeight()) >= this.mMinBitmapSizeBytes && rowBytes <= this.mMaxBitmapSizeBytes) {
                underlyingBitmap.prepareToDraw();
            }
        }
    }
}
