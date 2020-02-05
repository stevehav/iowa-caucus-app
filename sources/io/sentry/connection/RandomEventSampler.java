package io.sentry.connection;

import io.sentry.event.Event;
import java.util.Random;

public class RandomEventSampler implements EventSampler {
    private Random random;
    private double sampleRate;

    public RandomEventSampler(double d) {
        this(d, new Random());
    }

    public RandomEventSampler(double d, Random random2) {
        this.sampleRate = d;
        this.random = random2;
    }

    public boolean shouldSendEvent(Event event) {
        return this.sampleRate >= Math.abs(this.random.nextDouble());
    }
}
