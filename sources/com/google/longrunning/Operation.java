package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {
    /* access modifiers changed from: private */
    public static final Operation DEFAULT_INSTANCE = new Operation();
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Operation> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private boolean done_;
    private Any metadata_;
    private String name_ = "";
    private int resultCase_ = 0;
    private Object result_;

    private Operation() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public enum ResultCase implements Internal.EnumLite {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);
        
        private final int value;

        private ResultCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        public static ResultCase forNumber(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return ERROR;
            }
            if (i != 5) {
                return null;
            }
            return RESPONSE;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    /* access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* access modifiers changed from: private */
    public void setName(String str) {
        if (str != null) {
            this.name_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    public Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* access modifiers changed from: private */
    public void setMetadata(Any any) {
        if (any != null) {
            this.metadata_ = any;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMetadata(Any.Builder builder) {
        this.metadata_ = (Any) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeMetadata(Any any) {
        Any any2 = this.metadata_;
        if (any2 == null || any2 == Any.getDefaultInstance()) {
            this.metadata_ = any;
        } else {
            this.metadata_ = (Any) ((Any.Builder) Any.newBuilder(this.metadata_).mergeFrom(any)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    public boolean getDone() {
        return this.done_;
    }

    /* access modifiers changed from: private */
    public void setDone(boolean z) {
        this.done_ = z;
    }

    /* access modifiers changed from: private */
    public void clearDone() {
        this.done_ = false;
    }

    public Status getError() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setError(Status status) {
        if (status != null) {
            this.result_ = status;
            this.resultCase_ = 4;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setError(Status.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void mergeError(Status status) {
        if (this.resultCase_ != 4 || this.result_ == Status.getDefaultInstance()) {
            this.result_ = status;
        } else {
            this.result_ = ((Status.Builder) Status.newBuilder((Status) this.result_).mergeFrom(status)).buildPartial();
        }
        this.resultCase_ = 4;
    }

    /* access modifiers changed from: private */
    public void clearError() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public Any getResponse() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setResponse(Any any) {
        if (any != null) {
            this.result_ = any;
            this.resultCase_ = 5;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setResponse(Any.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void mergeResponse(Any any) {
        if (this.resultCase_ != 5 || this.result_ == Any.getDefaultInstance()) {
            this.result_ = any;
        } else {
            this.result_ = ((Any.Builder) Any.newBuilder((Any) this.result_).mergeFrom(any)).buildPartial();
        }
        this.resultCase_ = 5;
    }

    /* access modifiers changed from: private */
    public void clearResponse() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (this.resultCase_ == 4) {
            codedOutputStream.writeMessage(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            codedOutputStream.writeMessage(5, (Any) this.result_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.name_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getName());
        }
        if (this.metadata_ != null) {
            i2 += CodedOutputStream.computeMessageSize(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            i2 += CodedOutputStream.computeBoolSize(3, z);
        }
        if (this.resultCase_ == 4) {
            i2 += CodedOutputStream.computeMessageSize(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            i2 += CodedOutputStream.computeMessageSize(5, (Any) this.result_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Operation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Operation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Operation parseFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Operation operation) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(operation);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Operation.DEFAULT_INSTANCE);
        }

        public ResultCase getResultCase() {
            return ((Operation) this.instance).getResultCase();
        }

        public Builder clearResult() {
            copyOnWrite();
            ((Operation) this.instance).clearResult();
            return this;
        }

        public String getName() {
            return ((Operation) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Operation) this.instance).getNameBytes();
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Operation) this.instance).setName(str);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Operation) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Operation) this.instance).setNameBytes(byteString);
            return this;
        }

        public boolean hasMetadata() {
            return ((Operation) this.instance).hasMetadata();
        }

        public Any getMetadata() {
            return ((Operation) this.instance).getMetadata();
        }

        public Builder setMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(any);
            return this;
        }

        public Builder setMetadata(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(builder);
            return this;
        }

        public Builder mergeMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeMetadata(any);
            return this;
        }

        public Builder clearMetadata() {
            copyOnWrite();
            ((Operation) this.instance).clearMetadata();
            return this;
        }

        public boolean getDone() {
            return ((Operation) this.instance).getDone();
        }

        public Builder setDone(boolean z) {
            copyOnWrite();
            ((Operation) this.instance).setDone(z);
            return this;
        }

        public Builder clearDone() {
            copyOnWrite();
            ((Operation) this.instance).clearDone();
            return this;
        }

        public Status getError() {
            return ((Operation) this.instance).getError();
        }

        public Builder setError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).setError(status);
            return this;
        }

        public Builder setError(Status.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setError(builder);
            return this;
        }

        public Builder mergeError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).mergeError(status);
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((Operation) this.instance).clearError();
            return this;
        }

        public Any getResponse() {
            return ((Operation) this.instance).getResponse();
        }

        public Builder setResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(any);
            return this;
        }

        public Builder setResponse(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(builder);
            return this;
        }

        public Builder mergeResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeResponse(any);
            return this;
        }

        public Builder clearResponse() {
            copyOnWrite();
            ((Operation) this.instance).clearResponse();
            return this;
        }
    }

    /* renamed from: com.google.longrunning.Operation$1  reason: invalid class name */
    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$longrunning$Operation$ResultCase = new int[ResultCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007f */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r2 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r3 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x004b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                com.google.longrunning.Operation$ResultCase[] r3 = com.google.longrunning.Operation.ResultCase.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$longrunning$Operation$ResultCase = r3
                int[] r3 = $SwitchMap$com$google$longrunning$Operation$ResultCase     // Catch:{ NoSuchFieldError -> 0x0075 }
                com.google.longrunning.Operation$ResultCase r4 = com.google.longrunning.Operation.ResultCase.ERROR     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r0 = $SwitchMap$com$google$longrunning$Operation$ResultCase     // Catch:{ NoSuchFieldError -> 0x007f }
                com.google.longrunning.Operation$ResultCase r3 = com.google.longrunning.Operation.ResultCase.RESPONSE     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r0 = $SwitchMap$com$google$longrunning$Operation$ResultCase     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.google.longrunning.Operation$ResultCase r1 = com.google.longrunning.Operation.ResultCase.RESULT_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.longrunning.Operation.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Operation();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Operation operation = (Operation) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !operation.name_.isEmpty(), operation.name_);
                this.metadata_ = (Any) visitor.visitMessage(this.metadata_, operation.metadata_);
                boolean z2 = this.done_;
                boolean z3 = operation.done_;
                this.done_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i2 = AnonymousClass1.$SwitchMap$com$google$longrunning$Operation$ResultCase[operation.getResultCase().ordinal()];
                if (i2 == 1) {
                    if (this.resultCase_ == 4) {
                        z = true;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, operation.result_);
                } else if (i2 == 2) {
                    if (this.resultCase_ == 5) {
                        z = true;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, operation.result_);
                } else if (i2 == 3) {
                    if (this.resultCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = operation.resultCase_) != 0) {
                    this.resultCase_ = i;
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                Any.Builder builder = this.metadata_ != null ? (Any.Builder) this.metadata_.toBuilder() : null;
                                this.metadata_ = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.metadata_);
                                    this.metadata_ = (Any) builder.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.done_ = codedInputStream.readBool();
                            } else if (readTag == 34) {
                                Status.Builder builder2 = this.resultCase_ == 4 ? (Status.Builder) ((Status) this.result_).toBuilder() : null;
                                this.result_ = codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Status) this.result_);
                                    this.result_ = builder2.buildPartial();
                                }
                                this.resultCase_ = 4;
                            } else if (readTag == 42) {
                                Any.Builder builder3 = this.resultCase_ == 5 ? (Any.Builder) ((Any) this.result_).toBuilder() : null;
                                this.result_ = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((Any) this.result_);
                                    this.result_ = builder3.buildPartial();
                                }
                                this.resultCase_ = 5;
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
                    synchronized (Operation.class) {
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

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Operation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
