package com.facebook.drawee.backends.pipeline.info;

import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.ImagesContract;

public class ImageOriginUtils {
    public static String toString(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? EnvironmentCompat.MEDIA_UNKNOWN : ImagesContract.LOCAL : "memory_bitmap" : "memory_encoded" : "disk" : "network";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int mapProducerNameToImageOrigin(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = 6
            r2 = 2
            r3 = 3
            r4 = 4
            r5 = 5
            r6 = 1
            switch(r0) {
                case -1917159454: goto L_0x00a6;
                case -1914072202: goto L_0x009c;
                case -1683996557: goto L_0x0091;
                case -1579985851: goto L_0x0086;
                case -1307634203: goto L_0x007c;
                case -1224383234: goto L_0x0072;
                case 473552259: goto L_0x0067;
                case 656304759: goto L_0x005d;
                case 957714404: goto L_0x0053;
                case 1019542023: goto L_0x0048;
                case 1023071510: goto L_0x003d;
                case 1721672898: goto L_0x0032;
                case 1793127518: goto L_0x0026;
                case 2109593398: goto L_0x001b;
                case 2113652014: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x00b1
        L_0x000f:
            java.lang.String r0 = "LocalContentUriFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 9
            goto L_0x00b2
        L_0x001b:
            java.lang.String r0 = "PartialDiskCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 5
            goto L_0x00b2
        L_0x0026:
            java.lang.String r0 = "LocalContentUriThumbnailFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 10
            goto L_0x00b2
        L_0x0032:
            java.lang.String r0 = "DataFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 7
            goto L_0x00b2
        L_0x003d:
            java.lang.String r0 = "PostprocessedBitmapMemoryCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 2
            goto L_0x00b2
        L_0x0048:
            java.lang.String r0 = "LocalAssetFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 8
            goto L_0x00b2
        L_0x0053:
            java.lang.String r0 = "BitmapMemoryCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 1
            goto L_0x00b2
        L_0x005d:
            java.lang.String r0 = "DiskCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 4
            goto L_0x00b2
        L_0x0067:
            java.lang.String r0 = "VideoThumbnailProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 13
            goto L_0x00b2
        L_0x0072:
            java.lang.String r0 = "NetworkFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 6
            goto L_0x00b2
        L_0x007c:
            java.lang.String r0 = "EncodedMemoryCacheProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 3
            goto L_0x00b2
        L_0x0086:
            java.lang.String r0 = "LocalFileFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 11
            goto L_0x00b2
        L_0x0091:
            java.lang.String r0 = "LocalResourceFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 12
            goto L_0x00b2
        L_0x009c:
            java.lang.String r0 = "BitmapMemoryCacheGetProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 0
            goto L_0x00b2
        L_0x00a6:
            java.lang.String r0 = "QualifiedResourceFetchProducer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00b1
            r7 = 14
            goto L_0x00b2
        L_0x00b1:
            r7 = -1
        L_0x00b2:
            switch(r7) {
                case 0: goto L_0x00ba;
                case 1: goto L_0x00ba;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00b8;
                case 5: goto L_0x00b8;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00b6;
                case 8: goto L_0x00b6;
                case 9: goto L_0x00b6;
                case 10: goto L_0x00b6;
                case 11: goto L_0x00b6;
                case 12: goto L_0x00b6;
                case 13: goto L_0x00b6;
                case 14: goto L_0x00b6;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            return r6
        L_0x00b6:
            return r1
        L_0x00b7:
            return r2
        L_0x00b8:
            return r3
        L_0x00b9:
            return r4
        L_0x00ba:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.mapProducerNameToImageOrigin(java.lang.String):int");
    }

    private ImageOriginUtils() {
    }
}
