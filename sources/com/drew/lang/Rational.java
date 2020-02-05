package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.io.Serializable;

public class Rational extends Number implements Comparable<Rational>, Serializable {
    private static final long serialVersionUID = 510688928138848770L;
    private final long _denominator;
    private final long _numerator;

    public Rational(long j, long j2) {
        this._numerator = j;
        this._denominator = j2;
    }

    public double doubleValue() {
        long j = this._numerator;
        if (j == 0) {
            return 0.0d;
        }
        double d = (double) j;
        double d2 = (double) this._denominator;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public float floatValue() {
        long j = this._numerator;
        if (j == 0) {
            return 0.0f;
        }
        return ((float) j) / ((float) this._denominator);
    }

    public final byte byteValue() {
        return (byte) ((int) doubleValue());
    }

    public final int intValue() {
        return (int) doubleValue();
    }

    public final long longValue() {
        return (long) doubleValue();
    }

    public final short shortValue() {
        return (short) ((int) doubleValue());
    }

    public final long getDenominator() {
        return this._denominator;
    }

    public final long getNumerator() {
        return this._numerator;
    }

    @NotNull
    public Rational getReciprocal() {
        return new Rational(this._denominator, this._numerator);
    }

    public boolean isInteger() {
        long j = this._denominator;
        return j == 1 || (j != 0 && this._numerator % j == 0) || (this._denominator == 0 && this._numerator == 0);
    }

    public boolean isZero() {
        return this._numerator == 0 || this._denominator == 0;
    }

    @NotNull
    public String toString() {
        return this._numerator + "/" + this._denominator;
    }

    @NotNull
    public String toSimpleString(boolean z) {
        if (this._denominator == 0 && this._numerator != 0) {
            return toString();
        }
        if (isInteger()) {
            return Integer.toString(intValue());
        }
        long j = this._numerator;
        if (j != 1) {
            long j2 = this._denominator;
            if (j2 % j == 0) {
                return new Rational(1, j2 / j).toSimpleString(z);
            }
        }
        Rational simplifiedInstance = getSimplifiedInstance();
        if (z) {
            String d = Double.toString(simplifiedInstance.doubleValue());
            if (d.length() < 5) {
                return d;
            }
        }
        return simplifiedInstance.toString();
    }

    public int compareTo(@NotNull Rational rational) {
        return Double.compare(doubleValue(), rational.doubleValue());
    }

    public boolean equals(Rational rational) {
        return rational.doubleValue() == doubleValue();
    }

    public boolean equalsExact(Rational rational) {
        return getDenominator() == rational.getDenominator() && getNumerator() == rational.getNumerator();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Rational) || doubleValue() != ((Rational) obj).doubleValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((int) this._denominator) * 23) + ((int) this._numerator);
    }

    @NotNull
    public Rational getSimplifiedInstance() {
        long GCD = GCD(this._numerator, this._denominator);
        return new Rational(this._numerator / GCD, this._denominator / GCD);
    }

    private static long GCD(long j, long j2) {
        if (j < 0) {
            j = -j;
        }
        if (j2 < 0) {
            j2 = -j2;
        }
        while (j != 0 && j2 != 0) {
            if (j > j2) {
                j %= j2;
            } else {
                j2 %= j;
            }
        }
        return j == 0 ? j2 : j;
    }
}
