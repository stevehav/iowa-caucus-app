package com.facebook.imagepipeline.memory;

public class NoOpPoolStatsTracker implements PoolStatsTracker {
    private static NoOpPoolStatsTracker sInstance;

    public void onAlloc(int i) {
    }

    public void onFree(int i) {
    }

    public void onHardCapReached() {
    }

    public void onSoftCapReached() {
    }

    public void onValueRelease(int i) {
    }

    public void onValueReuse(int i) {
    }

    public void setBasePool(BasePool basePool) {
    }

    private NoOpPoolStatsTracker() {
    }

    public static synchronized NoOpPoolStatsTracker getInstance() {
        NoOpPoolStatsTracker noOpPoolStatsTracker;
        synchronized (NoOpPoolStatsTracker.class) {
            if (sInstance == null) {
                sInstance = new NoOpPoolStatsTracker();
            }
            noOpPoolStatsTracker = sInstance;
        }
        return noOpPoolStatsTracker;
    }
}
