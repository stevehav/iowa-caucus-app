package io.opencensus.trace;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class AttributeValue {
    @Deprecated
    public abstract <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4);

    public abstract <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5);

    public static AttributeValue stringAttributeValue(String str) {
        return AttributeValueString.create(str);
    }

    public static AttributeValue booleanAttributeValue(boolean z) {
        return AttributeValueBoolean.create(Boolean.valueOf(z));
    }

    public static AttributeValue longAttributeValue(long j) {
        return AttributeValueLong.create(Long.valueOf(j));
    }

    public static AttributeValue doubleAttributeValue(double d) {
        return AttributeValueDouble.create(Double.valueOf(d));
    }

    AttributeValue() {
    }

    @Immutable
    static abstract class AttributeValueString extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract String getStringValue();

        AttributeValueString() {
        }

        static AttributeValue create(String str) {
            return new AutoValue_AttributeValue_AttributeValueString((String) Utils.checkNotNull(str, "stringValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4) {
            return function.apply(getStringValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5) {
            return function.apply(getStringValue());
        }
    }

    @Immutable
    static abstract class AttributeValueBoolean extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Boolean getBooleanValue();

        AttributeValueBoolean() {
        }

        static AttributeValue create(Boolean bool) {
            return new AutoValue_AttributeValue_AttributeValueBoolean((Boolean) Utils.checkNotNull(bool, "booleanValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4) {
            return function2.apply(getBooleanValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5) {
            return function2.apply(getBooleanValue());
        }
    }

    @Immutable
    static abstract class AttributeValueLong extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Long getLongValue();

        AttributeValueLong() {
        }

        static AttributeValue create(Long l) {
            return new AutoValue_AttributeValue_AttributeValueLong((Long) Utils.checkNotNull(l, "longValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4) {
            return function3.apply(getLongValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5) {
            return function3.apply(getLongValue());
        }
    }

    @Immutable
    static abstract class AttributeValueDouble extends AttributeValue {
        /* access modifiers changed from: package-private */
        public abstract Double getDoubleValue();

        AttributeValueDouble() {
        }

        static AttributeValue create(Double d) {
            return new AutoValue_AttributeValue_AttributeValueDouble((Double) Utils.checkNotNull(d, "doubleValue"));
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<Object, T> function4) {
            return function4.apply(getDoubleValue());
        }

        public final <T> T match(Function<? super String, T> function, Function<? super Boolean, T> function2, Function<? super Long, T> function3, Function<? super Double, T> function4, Function<Object, T> function5) {
            return function4.apply(getDoubleValue());
        }
    }
}
