package com.facebook.common.disk;

import javax.annotation.Nullable;

public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    @Nullable
    private static NoOpDiskTrimmableRegistry sInstance;

    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (sInstance == null) {
                sInstance = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = sInstance;
        }
        return noOpDiskTrimmableRegistry;
    }
}
