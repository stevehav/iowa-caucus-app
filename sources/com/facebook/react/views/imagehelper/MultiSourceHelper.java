package com.facebook.react.views.imagehelper;

import androidx.annotation.Nullable;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.List;

public class MultiSourceHelper {

    public static class MultiSourceResult {
        @Nullable
        private final ImageSource bestResult;
        @Nullable
        private final ImageSource bestResultInCache;

        private MultiSourceResult(@Nullable ImageSource imageSource, @Nullable ImageSource imageSource2) {
            this.bestResult = imageSource;
            this.bestResultInCache = imageSource2;
        }

        @Nullable
        public ImageSource getBestResult() {
            return this.bestResult;
        }

        @Nullable
        public ImageSource getBestResultInCache() {
            return this.bestResultInCache;
        }
    }

    public static MultiSourceResult getBestSourceForSize(int i, int i2, List<ImageSource> list) {
        return getBestSourceForSize(i, i2, list, 1.0d);
    }

    public static MultiSourceResult getBestSourceForSize(int i, int i2, List<ImageSource> list, double d) {
        if (list.isEmpty()) {
            return new MultiSourceResult((ImageSource) null, (ImageSource) null);
        }
        if (list.size() == 1) {
            return new MultiSourceResult(list.get(0), (ImageSource) null);
        }
        if (i <= 0 || i2 <= 0) {
            return new MultiSourceResult((ImageSource) null, (ImageSource) null);
        }
        ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
        double d2 = (double) (i * i2);
        Double.isNaN(d2);
        double d3 = d2 * d;
        double d4 = Double.MAX_VALUE;
        double d5 = Double.MAX_VALUE;
        ImageSource imageSource = null;
        ImageSource imageSource2 = null;
        for (ImageSource next : list) {
            double abs = Math.abs(1.0d - (next.getSize() / d3));
            if (abs < d4) {
                imageSource2 = next;
                d4 = abs;
            }
            if (abs < d5 && (imagePipeline.isInBitmapMemoryCache(next.getUri()) || imagePipeline.isInDiskCacheSync(next.getUri()))) {
                imageSource = next;
                d5 = abs;
            }
        }
        if (!(imageSource == null || imageSource2 == null || !imageSource.getSource().equals(imageSource2.getSource()))) {
            imageSource = null;
        }
        return new MultiSourceResult(imageSource2, imageSource);
    }
}
