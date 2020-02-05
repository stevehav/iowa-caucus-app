package io.sentry.time;

import java.util.Date;

public class SystemClock implements Clock {
    public long millis() {
        return System.currentTimeMillis();
    }

    public Date date() {
        return new Date();
    }
}
