package io.opencensus.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Timestamp implements Comparable<Timestamp> {
    public abstract int getNanos();

    public abstract long getSeconds();

    Timestamp() {
    }

    public static Timestamp create(long j, int i) {
        if (j < -315576000000L) {
            throw new IllegalArgumentException("'seconds' is less than minimum (-315576000000): " + j);
        } else if (j > 315576000000L) {
            throw new IllegalArgumentException("'seconds' is greater than maximum (315576000000): " + j);
        } else if (i < 0) {
            throw new IllegalArgumentException("'nanos' is less than zero: " + i);
        } else if (i <= 999999999) {
            return new AutoValue_Timestamp(j, i);
        } else {
            throw new IllegalArgumentException("'nanos' is greater than maximum (999999999): " + i);
        }
    }

    public static Timestamp fromMillis(long j) {
        return create(floorDiv(j, 1000), (int) (((long) ((int) floorMod(j, 1000))) * 1000000));
    }

    public Timestamp addNanos(long j) {
        return plus(0, j);
    }

    public Timestamp addDuration(Duration duration) {
        return plus(duration.getSeconds(), (long) duration.getNanos());
    }

    public Duration subtractTimestamp(Timestamp timestamp) {
        long j;
        long seconds = getSeconds() - timestamp.getSeconds();
        int nanos = getNanos() - timestamp.getNanos();
        if (seconds >= 0 || nanos <= 0) {
            if (seconds > 0 && nanos < 0) {
                seconds--;
                j = ((long) nanos) + 1000000000;
            }
            return Duration.create(seconds, nanos);
        }
        seconds++;
        j = ((long) nanos) - 1000000000;
        nanos = (int) j;
        return Duration.create(seconds, nanos);
    }

    public int compareTo(Timestamp timestamp) {
        int compareLongs = TimeUtils.compareLongs(getSeconds(), timestamp.getSeconds());
        if (compareLongs != 0) {
            return compareLongs;
        }
        return TimeUtils.compareLongs((long) getNanos(), (long) timestamp.getNanos());
    }

    private Timestamp plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(TimeUtils.checkedAdd(TimeUtils.checkedAdd(getSeconds(), j), j2 / 1000000000), ((long) getNanos()) + (j2 % 1000000000));
    }

    private static Timestamp ofEpochSecond(long j, long j2) {
        return create(TimeUtils.checkedAdd(j, floorDiv(j2, 1000000000)), (int) floorMod(j2, 1000000000));
    }

    private static long floorDiv(long j, long j2) {
        return BigDecimal.valueOf(j).divide(BigDecimal.valueOf(j2), 0, RoundingMode.FLOOR).longValue();
    }

    private static long floorMod(long j, long j2) {
        return j - (floorDiv(j, j2) * j2);
    }
}
