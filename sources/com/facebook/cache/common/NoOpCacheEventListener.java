package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheEventListener implements CacheEventListener {
    @Nullable
    private static NoOpCacheEventListener sInstance;

    public void onCleared() {
    }

    public void onEviction(CacheEvent cacheEvent) {
    }

    public void onHit(CacheEvent cacheEvent) {
    }

    public void onMiss(CacheEvent cacheEvent) {
    }

    public void onReadException(CacheEvent cacheEvent) {
    }

    public void onWriteAttempt(CacheEvent cacheEvent) {
    }

    public void onWriteException(CacheEvent cacheEvent) {
    }

    public void onWriteSuccess(CacheEvent cacheEvent) {
    }

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener getInstance() {
        NoOpCacheEventListener noOpCacheEventListener;
        synchronized (NoOpCacheEventListener.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = sInstance;
        }
        return noOpCacheEventListener;
    }
}
