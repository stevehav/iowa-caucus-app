package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    /* access modifiers changed from: protected */
    public abstract void onNewResultListImpl(List<Bitmap> list);

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void onNewResultImpl(com.facebook.datasource.DataSource<java.util.List<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6.isFinished()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Object r6 = r6.getResult()
            java.util.List r6 = (java.util.List) r6
            r0 = 0
            if (r6 != 0) goto L_0x0014
            r5.onNewResultListImpl(r0)
            return
        L_0x0014:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0061 }
            int r2 = r6.size()     // Catch:{ all -> 0x0061 }
            r1.<init>(r2)     // Catch:{ all -> 0x0061 }
            java.util.Iterator r2 = r6.iterator()     // Catch:{ all -> 0x0061 }
        L_0x0021:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0049
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0061 }
            com.facebook.common.references.CloseableReference r3 = (com.facebook.common.references.CloseableReference) r3     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0045
            java.lang.Object r4 = r3.get()     // Catch:{ all -> 0x0061 }
            boolean r4 = r4 instanceof com.facebook.imagepipeline.image.CloseableBitmap     // Catch:{ all -> 0x0061 }
            if (r4 == 0) goto L_0x0045
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0061 }
            com.facebook.imagepipeline.image.CloseableBitmap r3 = (com.facebook.imagepipeline.image.CloseableBitmap) r3     // Catch:{ all -> 0x0061 }
            android.graphics.Bitmap r3 = r3.getUnderlyingBitmap()     // Catch:{ all -> 0x0061 }
            r1.add(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x0021
        L_0x0045:
            r1.add(r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0021
        L_0x0049:
            r5.onNewResultListImpl(r1)     // Catch:{ all -> 0x0061 }
            java.util.Iterator r6 = r6.iterator()
        L_0x0050:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0060
            java.lang.Object r0 = r6.next()
            com.facebook.common.references.CloseableReference r0 = (com.facebook.common.references.CloseableReference) r0
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r0)
            goto L_0x0050
        L_0x0060:
            return
        L_0x0061:
            r0 = move-exception
            java.util.Iterator r6 = r6.iterator()
        L_0x0066:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r6.next()
            com.facebook.common.references.CloseableReference r1 = (com.facebook.common.references.CloseableReference) r1
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r1)
            goto L_0x0066
        L_0x0076:
            goto L_0x0078
        L_0x0077:
            throw r0
        L_0x0078:
            goto L_0x0077
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.datasource.BaseListBitmapDataSubscriber.onNewResultImpl(com.facebook.datasource.DataSource):void");
    }
}
