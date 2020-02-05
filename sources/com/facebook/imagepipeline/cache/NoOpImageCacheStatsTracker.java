package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public class NoOpImageCacheStatsTracker implements ImageCacheStatsTracker {
    private static NoOpImageCacheStatsTracker sInstance;

    public void onBitmapCacheHit(CacheKey cacheKey) {
    }

    public void onBitmapCacheMiss() {
    }

    public void onBitmapCachePut() {
    }

    public void onDiskCacheGetFail() {
    }

    public void onDiskCacheHit(CacheKey cacheKey) {
    }

    public void onDiskCacheMiss() {
    }

    public void onMemoryCacheHit(CacheKey cacheKey) {
    }

    public void onMemoryCacheMiss() {
    }

    public void onMemoryCachePut() {
    }

    public void onStagingAreaHit(CacheKey cacheKey) {
    }

    public void onStagingAreaMiss() {
    }

    public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache) {
    }

    public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache) {
    }

    private NoOpImageCacheStatsTracker() {
    }

    public static synchronized NoOpImageCacheStatsTracker getInstance() {
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        synchronized (NoOpImageCacheStatsTracker.class) {
            if (sInstance == null) {
                sInstance = new NoOpImageCacheStatsTracker();
            }
            noOpImageCacheStatsTracker = sInstance;
        }
        return noOpImageCacheStatsTracker;
    }
}
