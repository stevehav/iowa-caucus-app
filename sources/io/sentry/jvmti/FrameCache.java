package io.sentry.jvmti;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public final class FrameCache {
    private static Set<String> appPackages = new HashSet();
    private static ThreadLocal<WeakHashMap<Throwable, Frame[]>> cache = new ThreadLocal<WeakHashMap<Throwable, Frame[]>>() {
        /* access modifiers changed from: protected */
        public WeakHashMap<Throwable, Frame[]> initialValue() {
            return new WeakHashMap<>();
        }
    };

    private FrameCache() {
    }

    public static void add(Throwable th, Frame[] frameArr) {
        cache.get().put(th, frameArr);
    }

    public static Frame[] get(Throwable th) {
        return (Frame[]) cache.get().get(th);
    }

    public static boolean shouldCacheThrowable(Throwable th, int i) {
        if (appPackages.isEmpty()) {
            return false;
        }
        Frame[] frameArr = (Frame[]) cache.get().get(th);
        if (frameArr != null && i <= frameArr.length) {
            return false;
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            for (String startsWith : appPackages) {
                if (stackTraceElement.getClassName().startsWith(startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addAppPackage(String str) {
        appPackages.add(str);
    }
}
