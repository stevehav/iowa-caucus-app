package com.google.firebase.firestore.model.value;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class DoubleValue extends NumberValue {
    public static final DoubleValue NaN = new DoubleValue(Double.valueOf(Double.NaN));
    private final double internalValue;

    private DoubleValue(Double d) {
        this.internalValue = d.doubleValue();
    }

    public static DoubleValue valueOf(Double d) {
        if (Double.isNaN(d.doubleValue())) {
            return NaN;
        }
        return new DoubleValue(d);
    }

    public Double value() {
        return Double.valueOf(this.internalValue);
    }

    public boolean equals(Object obj) {
        return (obj instanceof DoubleValue) && Double.doubleToLongBits(this.internalValue) == Double.doubleToLongBits(((DoubleValue) obj).internalValue);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.internalValue);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public double getInternalValue() {
        return this.internalValue;
    }
}
