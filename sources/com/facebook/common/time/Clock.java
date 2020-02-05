package com.facebook.common.time;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface Clock {
    public static final long MAX_TIME = Long.MAX_VALUE;

    long now();
}
