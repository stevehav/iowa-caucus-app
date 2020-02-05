package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.util.Assert;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class NumericIncrementTransformOperation implements TransformOperation {
    private NumberValue operand;

    private long safeIncrement(long j, long j2) {
        long j3 = j + j2;
        return ((j ^ j3) & (j2 ^ j3)) >= 0 ? j3 : j3 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    public FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2) {
        return fieldValue2;
    }

    public NumericIncrementTransformOperation(NumberValue numberValue) {
        this.operand = numberValue;
    }

    public FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp) {
        NumberValue computeBaseValue = computeBaseValue(fieldValue);
        boolean z = computeBaseValue instanceof IntegerValue;
        if (z && (this.operand instanceof IntegerValue)) {
            return IntegerValue.valueOf(Long.valueOf(safeIncrement(((IntegerValue) computeBaseValue).getInternalValue(), operandAsLong())));
        }
        if (z) {
            double internalValue = (double) ((IntegerValue) computeBaseValue).getInternalValue();
            double operandAsDouble = operandAsDouble();
            Double.isNaN(internalValue);
            return DoubleValue.valueOf(Double.valueOf(internalValue + operandAsDouble));
        }
        Assert.hardAssert(computeBaseValue instanceof DoubleValue, "Expected NumberValue to be of type DoubleValue, but was ", fieldValue.getClass().getCanonicalName());
        return DoubleValue.valueOf(Double.valueOf(((DoubleValue) computeBaseValue).getInternalValue() + operandAsDouble()));
    }

    public FieldValue getOperand() {
        return this.operand;
    }

    public NumberValue computeBaseValue(@Nullable FieldValue fieldValue) {
        if (fieldValue instanceof NumberValue) {
            return (NumberValue) fieldValue;
        }
        return IntegerValue.valueOf(0L);
    }

    private double operandAsDouble() {
        NumberValue numberValue = this.operand;
        if (numberValue instanceof DoubleValue) {
            return ((DoubleValue) numberValue).getInternalValue();
        }
        if (numberValue instanceof IntegerValue) {
            return (double) ((IntegerValue) numberValue).getInternalValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }

    private long operandAsLong() {
        NumberValue numberValue = this.operand;
        if (numberValue instanceof DoubleValue) {
            return (long) ((DoubleValue) numberValue).getInternalValue();
        }
        if (numberValue instanceof IntegerValue) {
            return ((IntegerValue) numberValue).getInternalValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }
}
