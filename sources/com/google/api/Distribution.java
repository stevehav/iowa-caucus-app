package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Distribution extends GeneratedMessageLite<Distribution, Builder> implements DistributionOrBuilder {
    public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
    public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
    public static final int COUNT_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Distribution DEFAULT_INSTANCE = new Distribution();
    public static final int MEAN_FIELD_NUMBER = 2;
    private static volatile Parser<Distribution> PARSER = null;
    public static final int RANGE_FIELD_NUMBER = 4;
    public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
    private int bitField0_;
    private Internal.LongList bucketCounts_ = emptyLongList();
    private BucketOptions bucketOptions_;
    private long count_;
    private double mean_;
    private Range range_;
    private double sumOfSquaredDeviation_;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface BucketOptionsOrBuilder extends MessageLiteOrBuilder {
        BucketOptions.Explicit getExplicitBuckets();

        BucketOptions.Exponential getExponentialBuckets();

        BucketOptions.Linear getLinearBuckets();

        BucketOptions.OptionsCase getOptionsCase();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface RangeOrBuilder extends MessageLiteOrBuilder {
        double getMax();

        double getMin();
    }

    private Distribution() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Range extends GeneratedMessageLite<Range, Builder> implements RangeOrBuilder {
        /* access modifiers changed from: private */
        public static final Range DEFAULT_INSTANCE = new Range();
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static volatile Parser<Range> PARSER;
        private double max_;
        private double min_;

        private Range() {
        }

        public double getMin() {
            return this.min_;
        }

        /* access modifiers changed from: private */
        public void setMin(double d) {
            this.min_ = d;
        }

        /* access modifiers changed from: private */
        public void clearMin() {
            this.min_ = 0.0d;
        }

        public double getMax() {
            return this.max_;
        }

        /* access modifiers changed from: private */
        public void setMax(double d) {
            this.max_ = d;
        }

        /* access modifiers changed from: private */
        public void clearMax() {
            this.max_ = 0.0d;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            double d = this.min_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(1, d);
            }
            double d2 = this.max_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(2, d2);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            double d = this.min_;
            if (d != 0.0d) {
                i2 = 0 + CodedOutputStream.computeDoubleSize(1, d);
            }
            double d2 = this.max_;
            if (d2 != 0.0d) {
                i2 += CodedOutputStream.computeDoubleSize(2, d2);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static Range parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Range parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Range parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Range parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Range parseFrom(InputStream inputStream) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Range parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Range) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Range parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Range parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Range range) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(range);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements RangeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(Range.DEFAULT_INSTANCE);
            }

            public double getMin() {
                return ((Range) this.instance).getMin();
            }

            public Builder setMin(double d) {
                copyOnWrite();
                ((Range) this.instance).setMin(d);
                return this;
            }

            public Builder clearMin() {
                copyOnWrite();
                ((Range) this.instance).clearMin();
                return this;
            }

            public double getMax() {
                return ((Range) this.instance).getMax();
            }

            public Builder setMax(double d) {
                copyOnWrite();
                ((Range) this.instance).setMax(d);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((Range) this.instance).clearMax();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new Range();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder((AnonymousClass1) null);
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Range range = (Range) obj2;
                    this.min_ = visitor.visitDouble(this.min_ != 0.0d, this.min_, range.min_ != 0.0d, range.min_);
                    this.max_ = visitor.visitDouble(this.max_ != 0.0d, this.max_, range.max_ != 0.0d, range.max_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 9) {
                                    this.min_ = codedInputStream.readDouble();
                                } else if (readTag == 17) {
                                    this.max_ = codedInputStream.readDouble();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case GET_DEFAULT_INSTANCE:
                    break;
                case GET_PARSER:
                    if (PARSER == null) {
                        synchronized (Range.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static Range getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Range> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class BucketOptions extends GeneratedMessageLite<BucketOptions, Builder> implements BucketOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final BucketOptions DEFAULT_INSTANCE = new BucketOptions();
        public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
        public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
        public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
        private static volatile Parser<BucketOptions> PARSER;
        private int optionsCase_ = 0;
        private Object options_;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExplicitOrBuilder extends MessageLiteOrBuilder {
            double getBounds(int i);

            int getBoundsCount();

            List<Double> getBoundsList();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExponentialOrBuilder extends MessageLiteOrBuilder {
            double getGrowthFactor();

            int getNumFiniteBuckets();

            double getScale();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface LinearOrBuilder extends MessageLiteOrBuilder {
            int getNumFiniteBuckets();

            double getOffset();

            double getWidth();
        }

        private BucketOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Linear extends GeneratedMessageLite<Linear, Builder> implements LinearOrBuilder {
            /* access modifiers changed from: private */
            public static final Linear DEFAULT_INSTANCE = new Linear();
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int OFFSET_FIELD_NUMBER = 3;
            private static volatile Parser<Linear> PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 2;
            private int numFiniteBuckets_;
            private double offset_;
            private double width_;

            private Linear() {
            }

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            /* access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            public double getWidth() {
                return this.width_;
            }

            /* access modifiers changed from: private */
            public void setWidth(double d) {
                this.width_ = d;
            }

            /* access modifiers changed from: private */
            public void clearWidth() {
                this.width_ = 0.0d;
            }

            public double getOffset() {
                return this.offset_;
            }

            /* access modifiers changed from: private */
            public void setOffset(double d) {
                this.offset_ = d;
            }

            /* access modifiers changed from: private */
            public void clearOffset() {
                this.offset_ = 0.0d;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                double d = this.width_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(3, d2);
                }
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                int i3 = this.numFiniteBuckets_;
                if (i3 != 0) {
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
                }
                double d = this.width_;
                if (d != 0.0d) {
                    i2 += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.offset_;
                if (d2 != 0.0d) {
                    i2 += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.memoizedSerializedSize = i2;
                return i2;
            }

            public static Linear parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Linear parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Linear parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Linear parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Linear parseFrom(InputStream inputStream) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Linear) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Linear linear) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(linear);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements LinearOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                private Builder() {
                    super(Linear.DEFAULT_INSTANCE);
                }

                public int getNumFiniteBuckets() {
                    return ((Linear) this.instance).getNumFiniteBuckets();
                }

                public Builder setNumFiniteBuckets(int i) {
                    copyOnWrite();
                    ((Linear) this.instance).setNumFiniteBuckets(i);
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    copyOnWrite();
                    ((Linear) this.instance).clearNumFiniteBuckets();
                    return this;
                }

                public double getWidth() {
                    return ((Linear) this.instance).getWidth();
                }

                public Builder setWidth(double d) {
                    copyOnWrite();
                    ((Linear) this.instance).setWidth(d);
                    return this;
                }

                public Builder clearWidth() {
                    copyOnWrite();
                    ((Linear) this.instance).clearWidth();
                    return this;
                }

                public double getOffset() {
                    return ((Linear) this.instance).getOffset();
                }

                public Builder setOffset(double d) {
                    copyOnWrite();
                    ((Linear) this.instance).setOffset(d);
                    return this;
                }

                public Builder clearOffset() {
                    copyOnWrite();
                    ((Linear) this.instance).clearOffset();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new Linear();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder((AnonymousClass1) null);
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Linear linear = (Linear) obj2;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, linear.numFiniteBuckets_ != 0, linear.numFiniteBuckets_);
                        this.width_ = visitor.visitDouble(this.width_ != 0.0d, this.width_, linear.width_ != 0.0d, linear.width_);
                        this.offset_ = visitor.visitDouble(this.offset_ != 0.0d, this.offset_, linear.offset_ != 0.0d, linear.offset_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.numFiniteBuckets_ = codedInputStream.readInt32();
                                    } else if (readTag == 17) {
                                        this.width_ = codedInputStream.readDouble();
                                    } else if (readTag == 25) {
                                        this.offset_ = codedInputStream.readDouble();
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (PARSER == null) {
                            synchronized (Linear.class) {
                                if (PARSER == null) {
                                    PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                }
                            }
                        }
                        return PARSER;
                    default:
                        throw new UnsupportedOperationException();
                }
                return DEFAULT_INSTANCE;
            }

            static {
                DEFAULT_INSTANCE.makeImmutable();
            }

            public static Linear getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Linear> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Exponential extends GeneratedMessageLite<Exponential, Builder> implements ExponentialOrBuilder {
            /* access modifiers changed from: private */
            public static final Exponential DEFAULT_INSTANCE = new Exponential();
            public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            private static volatile Parser<Exponential> PARSER = null;
            public static final int SCALE_FIELD_NUMBER = 3;
            private double growthFactor_;
            private int numFiniteBuckets_;
            private double scale_;

            private Exponential() {
            }

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            /* access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            public double getGrowthFactor() {
                return this.growthFactor_;
            }

            /* access modifiers changed from: private */
            public void setGrowthFactor(double d) {
                this.growthFactor_ = d;
            }

            /* access modifiers changed from: private */
            public void clearGrowthFactor() {
                this.growthFactor_ = 0.0d;
            }

            public double getScale() {
                return this.scale_;
            }

            /* access modifiers changed from: private */
            public void setScale(double d) {
                this.scale_ = d;
            }

            /* access modifiers changed from: private */
            public void clearScale() {
                this.scale_ = 0.0d;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.numFiniteBuckets_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(3, d2);
                }
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                int i3 = this.numFiniteBuckets_;
                if (i3 != 0) {
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
                }
                double d = this.growthFactor_;
                if (d != 0.0d) {
                    i2 += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.scale_;
                if (d2 != 0.0d) {
                    i2 += CodedOutputStream.computeDoubleSize(3, d2);
                }
                this.memoizedSerializedSize = i2;
                return i2;
            }

            public static Exponential parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Exponential parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Exponential parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Exponential parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Exponential parseFrom(InputStream inputStream) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Exponential) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Exponential exponential) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(exponential);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements ExponentialOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                private Builder() {
                    super(Exponential.DEFAULT_INSTANCE);
                }

                public int getNumFiniteBuckets() {
                    return ((Exponential) this.instance).getNumFiniteBuckets();
                }

                public Builder setNumFiniteBuckets(int i) {
                    copyOnWrite();
                    ((Exponential) this.instance).setNumFiniteBuckets(i);
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearNumFiniteBuckets();
                    return this;
                }

                public double getGrowthFactor() {
                    return ((Exponential) this.instance).getGrowthFactor();
                }

                public Builder setGrowthFactor(double d) {
                    copyOnWrite();
                    ((Exponential) this.instance).setGrowthFactor(d);
                    return this;
                }

                public Builder clearGrowthFactor() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearGrowthFactor();
                    return this;
                }

                public double getScale() {
                    return ((Exponential) this.instance).getScale();
                }

                public Builder setScale(double d) {
                    copyOnWrite();
                    ((Exponential) this.instance).setScale(d);
                    return this;
                }

                public Builder clearScale() {
                    copyOnWrite();
                    ((Exponential) this.instance).clearScale();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new Exponential();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder((AnonymousClass1) null);
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Exponential exponential = (Exponential) obj2;
                        this.numFiniteBuckets_ = visitor.visitInt(this.numFiniteBuckets_ != 0, this.numFiniteBuckets_, exponential.numFiniteBuckets_ != 0, exponential.numFiniteBuckets_);
                        this.growthFactor_ = visitor.visitDouble(this.growthFactor_ != 0.0d, this.growthFactor_, exponential.growthFactor_ != 0.0d, exponential.growthFactor_);
                        this.scale_ = visitor.visitDouble(this.scale_ != 0.0d, this.scale_, exponential.scale_ != 0.0d, exponential.scale_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.numFiniteBuckets_ = codedInputStream.readInt32();
                                    } else if (readTag == 17) {
                                        this.growthFactor_ = codedInputStream.readDouble();
                                    } else if (readTag == 25) {
                                        this.scale_ = codedInputStream.readDouble();
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (PARSER == null) {
                            synchronized (Exponential.class) {
                                if (PARSER == null) {
                                    PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                }
                            }
                        }
                        return PARSER;
                    default:
                        throw new UnsupportedOperationException();
                }
                return DEFAULT_INSTANCE;
            }

            static {
                DEFAULT_INSTANCE.makeImmutable();
            }

            public static Exponential getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Exponential> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Explicit extends GeneratedMessageLite<Explicit, Builder> implements ExplicitOrBuilder {
            public static final int BOUNDS_FIELD_NUMBER = 1;
            /* access modifiers changed from: private */
            public static final Explicit DEFAULT_INSTANCE = new Explicit();
            private static volatile Parser<Explicit> PARSER;
            private Internal.DoubleList bounds_ = emptyDoubleList();

            private Explicit() {
            }

            public List<Double> getBoundsList() {
                return this.bounds_;
            }

            public int getBoundsCount() {
                return this.bounds_.size();
            }

            public double getBounds(int i) {
                return this.bounds_.getDouble(i);
            }

            private void ensureBoundsIsMutable() {
                if (!this.bounds_.isModifiable()) {
                    this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_);
                }
            }

            /* access modifiers changed from: private */
            public void setBounds(int i, double d) {
                ensureBoundsIsMutable();
                this.bounds_.setDouble(i, d);
            }

            /* access modifiers changed from: private */
            public void addBounds(double d) {
                ensureBoundsIsMutable();
                this.bounds_.addDouble(d);
            }

            /* access modifiers changed from: private */
            public void addAllBounds(Iterable<? extends Double> iterable) {
                ensureBoundsIsMutable();
                AbstractMessageLite.addAll(iterable, this.bounds_);
            }

            /* access modifiers changed from: private */
            public void clearBounds() {
                this.bounds_ = emptyDoubleList();
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                for (int i = 0; i < this.bounds_.size(); i++) {
                    codedOutputStream.writeDouble(1, this.bounds_.getDouble(i));
                }
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int size = (getBoundsList().size() * 8) + 0 + (getBoundsList().size() * 1);
                this.memoizedSerializedSize = size;
                return size;
            }

            public static Explicit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Explicit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Explicit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Explicit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Explicit parseFrom(InputStream inputStream) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Explicit) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Explicit explicit) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(explicit);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements ExplicitOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                private Builder() {
                    super(Explicit.DEFAULT_INSTANCE);
                }

                public List<Double> getBoundsList() {
                    return Collections.unmodifiableList(((Explicit) this.instance).getBoundsList());
                }

                public int getBoundsCount() {
                    return ((Explicit) this.instance).getBoundsCount();
                }

                public double getBounds(int i) {
                    return ((Explicit) this.instance).getBounds(i);
                }

                public Builder setBounds(int i, double d) {
                    copyOnWrite();
                    ((Explicit) this.instance).setBounds(i, d);
                    return this;
                }

                public Builder addBounds(double d) {
                    copyOnWrite();
                    ((Explicit) this.instance).addBounds(d);
                    return this;
                }

                public Builder addAllBounds(Iterable<? extends Double> iterable) {
                    copyOnWrite();
                    ((Explicit) this.instance).addAllBounds(iterable);
                    return this;
                }

                public Builder clearBounds() {
                    copyOnWrite();
                    ((Explicit) this.instance).clearBounds();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new Explicit();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        this.bounds_.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new Builder((AnonymousClass1) null);
                    case VISIT:
                        this.bounds_ = ((GeneratedMessageLite.Visitor) obj).visitDoubleList(this.bounds_, ((Explicit) obj2).bounds_);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        boolean z = false;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 9) {
                                        if (!this.bounds_.isModifiable()) {
                                            this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_);
                                        }
                                        this.bounds_.addDouble(codedInputStream.readDouble());
                                    } else if (readTag == 10) {
                                        int readRawVarint32 = codedInputStream.readRawVarint32();
                                        int pushLimit = codedInputStream.pushLimit(readRawVarint32);
                                        if (!this.bounds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_ = this.bounds_.mutableCopyWithCapacity(this.bounds_.size() + (readRawVarint32 / 8));
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_.addDouble(codedInputStream.readDouble());
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (PARSER == null) {
                            synchronized (Explicit.class) {
                                if (PARSER == null) {
                                    PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                }
                            }
                        }
                        return PARSER;
                    default:
                        throw new UnsupportedOperationException();
                }
                return DEFAULT_INSTANCE;
            }

            static {
                DEFAULT_INSTANCE.makeImmutable();
            }

            public static Explicit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Explicit> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum OptionsCase implements Internal.EnumLite {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);
            
            private final int value;

            private OptionsCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static OptionsCase valueOf(int i) {
                return forNumber(i);
            }

            public static OptionsCase forNumber(int i) {
                if (i == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (i == 1) {
                    return LINEAR_BUCKETS;
                }
                if (i == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (i != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }

            public int getNumber() {
                return this.value;
            }
        }

        public OptionsCase getOptionsCase() {
            return OptionsCase.forNumber(this.optionsCase_);
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.optionsCase_ = 0;
            this.options_ = null;
        }

        public Linear getLinearBuckets() {
            if (this.optionsCase_ == 1) {
                return (Linear) this.options_;
            }
            return Linear.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setLinearBuckets(Linear linear) {
            if (linear != null) {
                this.options_ = linear;
                this.optionsCase_ = 1;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setLinearBuckets(Linear.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void mergeLinearBuckets(Linear linear) {
            if (this.optionsCase_ != 1 || this.options_ == Linear.getDefaultInstance()) {
                this.options_ = linear;
            } else {
                this.options_ = ((Linear.Builder) Linear.newBuilder((Linear) this.options_).mergeFrom(linear)).buildPartial();
            }
            this.optionsCase_ = 1;
        }

        /* access modifiers changed from: private */
        public void clearLinearBuckets() {
            if (this.optionsCase_ == 1) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public Exponential getExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                return (Exponential) this.options_;
            }
            return Exponential.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setExponentialBuckets(Exponential exponential) {
            if (exponential != null) {
                this.options_ = exponential;
                this.optionsCase_ = 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setExponentialBuckets(Exponential.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void mergeExponentialBuckets(Exponential exponential) {
            if (this.optionsCase_ != 2 || this.options_ == Exponential.getDefaultInstance()) {
                this.options_ = exponential;
            } else {
                this.options_ = ((Exponential.Builder) Exponential.newBuilder((Exponential) this.options_).mergeFrom(exponential)).buildPartial();
            }
            this.optionsCase_ = 2;
        }

        /* access modifiers changed from: private */
        public void clearExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public Explicit getExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                return (Explicit) this.options_;
            }
            return Explicit.getDefaultInstance();
        }

        /* access modifiers changed from: private */
        public void setExplicitBuckets(Explicit explicit) {
            if (explicit != null) {
                this.options_ = explicit;
                this.optionsCase_ = 3;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setExplicitBuckets(Explicit.Builder builder) {
            this.options_ = builder.build();
            this.optionsCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void mergeExplicitBuckets(Explicit explicit) {
            if (this.optionsCase_ != 3 || this.options_ == Explicit.getDefaultInstance()) {
                this.options_ = explicit;
            } else {
                this.options_ = ((Explicit.Builder) Explicit.newBuilder((Explicit) this.options_).mergeFrom(explicit)).buildPartial();
            }
            this.optionsCase_ = 3;
        }

        /* access modifiers changed from: private */
        public void clearExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.optionsCase_ == 1) {
                codedOutputStream.writeMessage(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                codedOutputStream.writeMessage(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                codedOutputStream.writeMessage(3, (Explicit) this.options_);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.optionsCase_ == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                i2 += CodedOutputStream.computeMessageSize(3, (Explicit) this.options_);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static BucketOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BucketOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BucketOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(InputStream inputStream) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BucketOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BucketOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BucketOptions bucketOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(bucketOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, Builder> implements BucketOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(BucketOptions.DEFAULT_INSTANCE);
            }

            public OptionsCase getOptionsCase() {
                return ((BucketOptions) this.instance).getOptionsCase();
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearOptions();
                return this;
            }

            public Linear getLinearBuckets() {
                return ((BucketOptions) this.instance).getLinearBuckets();
            }

            public Builder setLinearBuckets(Linear linear) {
                copyOnWrite();
                ((BucketOptions) this.instance).setLinearBuckets(linear);
                return this;
            }

            public Builder setLinearBuckets(Linear.Builder builder) {
                copyOnWrite();
                ((BucketOptions) this.instance).setLinearBuckets(builder);
                return this;
            }

            public Builder mergeLinearBuckets(Linear linear) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeLinearBuckets(linear);
                return this;
            }

            public Builder clearLinearBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearLinearBuckets();
                return this;
            }

            public Exponential getExponentialBuckets() {
                return ((BucketOptions) this.instance).getExponentialBuckets();
            }

            public Builder setExponentialBuckets(Exponential exponential) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExponentialBuckets(exponential);
                return this;
            }

            public Builder setExponentialBuckets(Exponential.Builder builder) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExponentialBuckets(builder);
                return this;
            }

            public Builder mergeExponentialBuckets(Exponential exponential) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeExponentialBuckets(exponential);
                return this;
            }

            public Builder clearExponentialBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearExponentialBuckets();
                return this;
            }

            public Explicit getExplicitBuckets() {
                return ((BucketOptions) this.instance).getExplicitBuckets();
            }

            public Builder setExplicitBuckets(Explicit explicit) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExplicitBuckets(explicit);
                return this;
            }

            public Builder setExplicitBuckets(Explicit.Builder builder) {
                copyOnWrite();
                ((BucketOptions) this.instance).setExplicitBuckets(builder);
                return this;
            }

            public Builder mergeExplicitBuckets(Explicit explicit) {
                copyOnWrite();
                ((BucketOptions) this.instance).mergeExplicitBuckets(explicit);
                return this;
            }

            public Builder clearExplicitBuckets() {
                copyOnWrite();
                ((BucketOptions) this.instance).clearExplicitBuckets();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new BucketOptions();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder((AnonymousClass1) null);
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BucketOptions bucketOptions = (BucketOptions) obj2;
                    int i2 = AnonymousClass1.$SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase[bucketOptions.getOptionsCase().ordinal()];
                    if (i2 == 1) {
                        if (this.optionsCase_ == 1) {
                            z = true;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, bucketOptions.options_);
                    } else if (i2 == 2) {
                        if (this.optionsCase_ == 2) {
                            z = true;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, bucketOptions.options_);
                    } else if (i2 == 3) {
                        if (this.optionsCase_ == 3) {
                            z = true;
                        }
                        this.options_ = visitor.visitOneofMessage(z, this.options_, bucketOptions.options_);
                    } else if (i2 == 4) {
                        if (this.optionsCase_ != 0) {
                            z = true;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = bucketOptions.optionsCase_) != 0) {
                        this.optionsCase_ = i;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    Linear.Builder builder = this.optionsCase_ == 1 ? (Linear.Builder) ((Linear) this.options_).toBuilder() : null;
                                    this.options_ = codedInputStream.readMessage(Linear.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Linear) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.optionsCase_ = 1;
                                } else if (readTag == 18) {
                                    Exponential.Builder builder2 = this.optionsCase_ == 2 ? (Exponential.Builder) ((Exponential) this.options_).toBuilder() : null;
                                    this.options_ = codedInputStream.readMessage(Exponential.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Exponential) this.options_);
                                        this.options_ = builder2.buildPartial();
                                    }
                                    this.optionsCase_ = 2;
                                } else if (readTag == 26) {
                                    Explicit.Builder builder3 = this.optionsCase_ == 3 ? (Explicit.Builder) ((Explicit) this.options_).toBuilder() : null;
                                    this.options_ = codedInputStream.readMessage(Explicit.parser(), extensionRegistryLite);
                                    if (builder3 != null) {
                                        builder3.mergeFrom((Explicit) this.options_);
                                        this.options_ = builder3.buildPartial();
                                    }
                                    this.optionsCase_ = 3;
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case GET_DEFAULT_INSTANCE:
                    break;
                case GET_PARSER:
                    if (PARSER == null) {
                        synchronized (BucketOptions.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static BucketOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BucketOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Distribution$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase = new int[BucketOptions.OptionsCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
                com.google.api.Distribution$BucketOptions$OptionsCase[] r0 = com.google.api.Distribution.BucketOptions.OptionsCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.api.Distribution$BucketOptions$OptionsCase r2 = com.google.api.Distribution.BucketOptions.OptionsCase.LINEAR_BUCKETS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.api.Distribution$BucketOptions$OptionsCase r3 = com.google.api.Distribution.BucketOptions.OptionsCase.EXPONENTIAL_BUCKETS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.api.Distribution$BucketOptions$OptionsCase r4 = com.google.api.Distribution.BucketOptions.OptionsCase.EXPLICIT_BUCKETS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = $SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.api.Distribution$BucketOptions$OptionsCase r5 = com.google.api.Distribution.BucketOptions.OptionsCase.OPTIONS_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r4
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x005c }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x007c }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.AnonymousClass1.<clinit>():void");
        }
    }

    public long getCount() {
        return this.count_;
    }

    /* access modifiers changed from: private */
    public void setCount(long j) {
        this.count_ = j;
    }

    /* access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0;
    }

    public double getMean() {
        return this.mean_;
    }

    /* access modifiers changed from: private */
    public void setMean(double d) {
        this.mean_ = d;
    }

    /* access modifiers changed from: private */
    public void clearMean() {
        this.mean_ = 0.0d;
    }

    public double getSumOfSquaredDeviation() {
        return this.sumOfSquaredDeviation_;
    }

    /* access modifiers changed from: private */
    public void setSumOfSquaredDeviation(double d) {
        this.sumOfSquaredDeviation_ = d;
    }

    /* access modifiers changed from: private */
    public void clearSumOfSquaredDeviation() {
        this.sumOfSquaredDeviation_ = 0.0d;
    }

    public boolean hasRange() {
        return this.range_ != null;
    }

    public Range getRange() {
        Range range = this.range_;
        return range == null ? Range.getDefaultInstance() : range;
    }

    /* access modifiers changed from: private */
    public void setRange(Range range) {
        if (range != null) {
            this.range_ = range;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRange(Range.Builder builder) {
        this.range_ = (Range) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeRange(Range range) {
        Range range2 = this.range_;
        if (range2 == null || range2 == Range.getDefaultInstance()) {
            this.range_ = range;
        } else {
            this.range_ = (Range) ((Range.Builder) Range.newBuilder(this.range_).mergeFrom(range)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRange() {
        this.range_ = null;
    }

    public boolean hasBucketOptions() {
        return this.bucketOptions_ != null;
    }

    public BucketOptions getBucketOptions() {
        BucketOptions bucketOptions = this.bucketOptions_;
        return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
    }

    /* access modifiers changed from: private */
    public void setBucketOptions(BucketOptions bucketOptions) {
        if (bucketOptions != null) {
            this.bucketOptions_ = bucketOptions;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setBucketOptions(BucketOptions.Builder builder) {
        this.bucketOptions_ = (BucketOptions) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeBucketOptions(BucketOptions bucketOptions) {
        BucketOptions bucketOptions2 = this.bucketOptions_;
        if (bucketOptions2 == null || bucketOptions2 == BucketOptions.getDefaultInstance()) {
            this.bucketOptions_ = bucketOptions;
        } else {
            this.bucketOptions_ = (BucketOptions) ((BucketOptions.Builder) BucketOptions.newBuilder(this.bucketOptions_).mergeFrom(bucketOptions)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearBucketOptions() {
        this.bucketOptions_ = null;
    }

    public List<Long> getBucketCountsList() {
        return this.bucketCounts_;
    }

    public int getBucketCountsCount() {
        return this.bucketCounts_.size();
    }

    public long getBucketCounts(int i) {
        return this.bucketCounts_.getLong(i);
    }

    private void ensureBucketCountsIsMutable() {
        if (!this.bucketCounts_.isModifiable()) {
            this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
        }
    }

    /* access modifiers changed from: private */
    public void setBucketCounts(int i, long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.setLong(i, j);
    }

    /* access modifiers changed from: private */
    public void addBucketCounts(long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.addLong(j);
    }

    /* access modifiers changed from: private */
    public void addAllBucketCounts(Iterable<? extends Long> iterable) {
        ensureBucketCountsIsMutable();
        AbstractMessageLite.addAll(iterable, this.bucketCounts_);
    }

    /* access modifiers changed from: private */
    public void clearBucketCounts() {
        this.bucketCounts_ = emptyLongList();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        long j = this.count_;
        if (j != 0) {
            codedOutputStream.writeInt64(1, j);
        }
        double d = this.mean_;
        if (d != 0.0d) {
            codedOutputStream.writeDouble(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            codedOutputStream.writeDouble(3, d2);
        }
        if (this.range_ != null) {
            codedOutputStream.writeMessage(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            codedOutputStream.writeMessage(6, getBucketOptions());
        }
        for (int i = 0; i < this.bucketCounts_.size(); i++) {
            codedOutputStream.writeInt64(7, this.bucketCounts_.getLong(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        long j = this.count_;
        int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) + 0 : 0;
        double d = this.mean_;
        if (d != 0.0d) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(2, d);
        }
        double d2 = this.sumOfSquaredDeviation_;
        if (d2 != 0.0d) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(3, d2);
        }
        if (this.range_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(6, getBucketOptions());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.bucketCounts_.size(); i3++) {
            i2 += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i3));
        }
        int size = computeInt64Size + i2 + (getBucketCountsList().size() * 1);
        this.memoizedSerializedSize = size;
        return size;
    }

    public static Distribution parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Distribution parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Distribution parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Distribution parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Distribution parseFrom(InputStream inputStream) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Distribution) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Distribution distribution) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(distribution);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Distribution, Builder> implements DistributionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Distribution.DEFAULT_INSTANCE);
        }

        public long getCount() {
            return ((Distribution) this.instance).getCount();
        }

        public Builder setCount(long j) {
            copyOnWrite();
            ((Distribution) this.instance).setCount(j);
            return this;
        }

        public Builder clearCount() {
            copyOnWrite();
            ((Distribution) this.instance).clearCount();
            return this;
        }

        public double getMean() {
            return ((Distribution) this.instance).getMean();
        }

        public Builder setMean(double d) {
            copyOnWrite();
            ((Distribution) this.instance).setMean(d);
            return this;
        }

        public Builder clearMean() {
            copyOnWrite();
            ((Distribution) this.instance).clearMean();
            return this;
        }

        public double getSumOfSquaredDeviation() {
            return ((Distribution) this.instance).getSumOfSquaredDeviation();
        }

        public Builder setSumOfSquaredDeviation(double d) {
            copyOnWrite();
            ((Distribution) this.instance).setSumOfSquaredDeviation(d);
            return this;
        }

        public Builder clearSumOfSquaredDeviation() {
            copyOnWrite();
            ((Distribution) this.instance).clearSumOfSquaredDeviation();
            return this;
        }

        public boolean hasRange() {
            return ((Distribution) this.instance).hasRange();
        }

        public Range getRange() {
            return ((Distribution) this.instance).getRange();
        }

        public Builder setRange(Range range) {
            copyOnWrite();
            ((Distribution) this.instance).setRange(range);
            return this;
        }

        public Builder setRange(Range.Builder builder) {
            copyOnWrite();
            ((Distribution) this.instance).setRange(builder);
            return this;
        }

        public Builder mergeRange(Range range) {
            copyOnWrite();
            ((Distribution) this.instance).mergeRange(range);
            return this;
        }

        public Builder clearRange() {
            copyOnWrite();
            ((Distribution) this.instance).clearRange();
            return this;
        }

        public boolean hasBucketOptions() {
            return ((Distribution) this.instance).hasBucketOptions();
        }

        public BucketOptions getBucketOptions() {
            return ((Distribution) this.instance).getBucketOptions();
        }

        public Builder setBucketOptions(BucketOptions bucketOptions) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketOptions(bucketOptions);
            return this;
        }

        public Builder setBucketOptions(BucketOptions.Builder builder) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketOptions(builder);
            return this;
        }

        public Builder mergeBucketOptions(BucketOptions bucketOptions) {
            copyOnWrite();
            ((Distribution) this.instance).mergeBucketOptions(bucketOptions);
            return this;
        }

        public Builder clearBucketOptions() {
            copyOnWrite();
            ((Distribution) this.instance).clearBucketOptions();
            return this;
        }

        public List<Long> getBucketCountsList() {
            return Collections.unmodifiableList(((Distribution) this.instance).getBucketCountsList());
        }

        public int getBucketCountsCount() {
            return ((Distribution) this.instance).getBucketCountsCount();
        }

        public long getBucketCounts(int i) {
            return ((Distribution) this.instance).getBucketCounts(i);
        }

        public Builder setBucketCounts(int i, long j) {
            copyOnWrite();
            ((Distribution) this.instance).setBucketCounts(i, j);
            return this;
        }

        public Builder addBucketCounts(long j) {
            copyOnWrite();
            ((Distribution) this.instance).addBucketCounts(j);
            return this;
        }

        public Builder addAllBucketCounts(Iterable<? extends Long> iterable) {
            copyOnWrite();
            ((Distribution) this.instance).addAllBucketCounts(iterable);
            return this;
        }

        public Builder clearBucketCounts() {
            copyOnWrite();
            ((Distribution) this.instance).clearBucketCounts();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Distribution();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.bucketCounts_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Distribution distribution = (Distribution) obj2;
                this.count_ = visitor.visitLong(this.count_ != 0, this.count_, distribution.count_ != 0, distribution.count_);
                this.mean_ = visitor.visitDouble(this.mean_ != 0.0d, this.mean_, distribution.mean_ != 0.0d, distribution.mean_);
                this.sumOfSquaredDeviation_ = visitor.visitDouble(this.sumOfSquaredDeviation_ != 0.0d, this.sumOfSquaredDeviation_, distribution.sumOfSquaredDeviation_ != 0.0d, distribution.sumOfSquaredDeviation_);
                this.range_ = (Range) visitor.visitMessage(this.range_, distribution.range_);
                this.bucketOptions_ = (BucketOptions) visitor.visitMessage(this.bucketOptions_, distribution.bucketOptions_);
                this.bucketCounts_ = visitor.visitLongList(this.bucketCounts_, distribution.bucketCounts_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= distribution.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.count_ = codedInputStream.readInt64();
                            } else if (readTag == 17) {
                                this.mean_ = codedInputStream.readDouble();
                            } else if (readTag == 25) {
                                this.sumOfSquaredDeviation_ = codedInputStream.readDouble();
                            } else if (readTag == 34) {
                                Range.Builder builder = this.range_ != null ? (Range.Builder) this.range_.toBuilder() : null;
                                this.range_ = (Range) codedInputStream.readMessage(Range.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.range_);
                                    this.range_ = (Range) builder.buildPartial();
                                }
                            } else if (readTag == 50) {
                                BucketOptions.Builder builder2 = this.bucketOptions_ != null ? (BucketOptions.Builder) this.bucketOptions_.toBuilder() : null;
                                this.bucketOptions_ = (BucketOptions) codedInputStream.readMessage(BucketOptions.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.bucketOptions_);
                                    this.bucketOptions_ = (BucketOptions) builder2.buildPartial();
                                }
                            } else if (readTag == 56) {
                                if (!this.bucketCounts_.isModifiable()) {
                                    this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
                                }
                                this.bucketCounts_.addLong(codedInputStream.readInt64());
                            } else if (readTag == 58) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.bucketCounts_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.bucketCounts_.addLong(codedInputStream.readInt64());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case GET_DEFAULT_INSTANCE:
                break;
            case GET_PARSER:
                if (PARSER == null) {
                    synchronized (Distribution.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static Distribution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Distribution> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
