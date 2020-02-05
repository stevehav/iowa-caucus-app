package io.sentry.time;

import java.util.Date;

public interface Clock {
    Date date();

    long millis();
}
