package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class BatchGetDocumentsResponse extends GeneratedMessageLite<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final BatchGetDocumentsResponse DEFAULT_INSTANCE = new BatchGetDocumentsResponse();
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile Parser<BatchGetDocumentsResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Timestamp readTime_;
    private int resultCase_ = 0;
    private Object result_;
    private ByteString transaction_ = ByteString.EMPTY;

    private BatchGetDocumentsResponse() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum ResultCase implements Internal.EnumLite {
        FOUND(1),
        MISSING(2),
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
            if (i == 1) {
                return FOUND;
            }
            if (i != 2) {
                return null;
            }
            return MISSING;
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

    public Document getFound() {
        if (this.resultCase_ == 1) {
            return (Document) this.result_;
        }
        return Document.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setFound(Document document) {
        if (document != null) {
            this.result_ = document;
            this.resultCase_ = 1;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setFound(Document.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void mergeFound(Document document) {
        if (this.resultCase_ != 1 || this.result_ == Document.getDefaultInstance()) {
            this.result_ = document;
        } else {
            this.result_ = ((Document.Builder) Document.newBuilder((Document) this.result_).mergeFrom(document)).buildPartial();
        }
        this.resultCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void clearFound() {
        if (this.resultCase_ == 1) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public String getMissing() {
        return this.resultCase_ == 2 ? (String) this.result_ : "";
    }

    public ByteString getMissingBytes() {
        return ByteString.copyFromUtf8(this.resultCase_ == 2 ? (String) this.result_ : "");
    }

    /* access modifiers changed from: private */
    public void setMissing(String str) {
        if (str != null) {
            this.resultCase_ = 2;
            this.result_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearMissing() {
        if (this.resultCase_ == 2) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setMissingBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.resultCase_ = 2;
            this.result_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public ByteString getTransaction() {
        return this.transaction_;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString != null) {
            this.transaction_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.readTime_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.readTime_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.readTime_ = timestamp;
        } else {
            this.readTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.readTime_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.resultCase_ == 1) {
            codedOutputStream.writeMessage(1, (Document) this.result_);
        }
        if (this.resultCase_ == 2) {
            codedOutputStream.writeString(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            codedOutputStream.writeBytes(3, this.transaction_);
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(4, getReadTime());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.resultCase_ == 1) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, (Document) this.result_);
        }
        if (this.resultCase_ == 2) {
            i2 += CodedOutputStream.computeStringSize(2, getMissing());
        }
        if (!this.transaction_.isEmpty()) {
            i2 += CodedOutputStream.computeBytesSize(3, this.transaction_);
        }
        if (this.readTime_ != null) {
            i2 += CodedOutputStream.computeMessageSize(4, getReadTime());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(batchGetDocumentsResponse);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(BatchGetDocumentsResponse.DEFAULT_INSTANCE);
        }

        public ResultCase getResultCase() {
            return ((BatchGetDocumentsResponse) this.instance).getResultCase();
        }

        public Builder clearResult() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearResult();
            return this;
        }

        public Document getFound() {
            return ((BatchGetDocumentsResponse) this.instance).getFound();
        }

        public Builder setFound(Document document) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setFound(document);
            return this;
        }

        public Builder setFound(Document.Builder builder) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setFound(builder);
            return this;
        }

        public Builder mergeFound(Document document) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).mergeFound(document);
            return this;
        }

        public Builder clearFound() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearFound();
            return this;
        }

        public String getMissing() {
            return ((BatchGetDocumentsResponse) this.instance).getMissing();
        }

        public ByteString getMissingBytes() {
            return ((BatchGetDocumentsResponse) this.instance).getMissingBytes();
        }

        public Builder setMissing(String str) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setMissing(str);
            return this;
        }

        public Builder clearMissing() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearMissing();
            return this;
        }

        public Builder setMissingBytes(ByteString byteString) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setMissingBytes(byteString);
            return this;
        }

        public ByteString getTransaction() {
            return ((BatchGetDocumentsResponse) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString byteString) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setTransaction(byteString);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearTransaction();
            return this;
        }

        public boolean hasReadTime() {
            return ((BatchGetDocumentsResponse) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((BatchGetDocumentsResponse) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setReadTime(timestamp);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).setReadTime(builder);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).mergeReadTime(timestamp);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((BatchGetDocumentsResponse) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsResponse$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase = new int[ResultCase.values().length];

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
                com.google.firestore.v1.BatchGetDocumentsResponse$ResultCase[] r3 = com.google.firestore.v1.BatchGetDocumentsResponse.ResultCase.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase = r3
                int[] r3 = $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase     // Catch:{ NoSuchFieldError -> 0x0075 }
                com.google.firestore.v1.BatchGetDocumentsResponse$ResultCase r4 = com.google.firestore.v1.BatchGetDocumentsResponse.ResultCase.FOUND     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r0 = $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase     // Catch:{ NoSuchFieldError -> 0x007f }
                com.google.firestore.v1.BatchGetDocumentsResponse$ResultCase r3 = com.google.firestore.v1.BatchGetDocumentsResponse.ResultCase.MISSING     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r0 = $SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.google.firestore.v1.BatchGetDocumentsResponse$ResultCase r1 = com.google.firestore.v1.BatchGetDocumentsResponse.ResultCase.RESULT_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.BatchGetDocumentsResponse.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new BatchGetDocumentsResponse();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                BatchGetDocumentsResponse batchGetDocumentsResponse = (BatchGetDocumentsResponse) obj2;
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, batchGetDocumentsResponse.transaction_ != ByteString.EMPTY, batchGetDocumentsResponse.transaction_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, batchGetDocumentsResponse.readTime_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase[batchGetDocumentsResponse.getResultCase().ordinal()];
                if (i2 == 1) {
                    if (this.resultCase_ == 1) {
                        z = true;
                    }
                    this.result_ = visitor.visitOneofMessage(z, this.result_, batchGetDocumentsResponse.result_);
                } else if (i2 == 2) {
                    if (this.resultCase_ == 2) {
                        z = true;
                    }
                    this.result_ = visitor.visitOneofString(z, this.result_, batchGetDocumentsResponse.result_);
                } else if (i2 == 3) {
                    if (this.resultCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = batchGetDocumentsResponse.resultCase_) != 0) {
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
                                Document.Builder builder = this.resultCase_ == 1 ? (Document.Builder) ((Document) this.result_).toBuilder() : null;
                                this.result_ = codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Document) this.result_);
                                    this.result_ = builder.buildPartial();
                                }
                                this.resultCase_ = 1;
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.resultCase_ = 2;
                                this.result_ = readStringRequireUtf8;
                            } else if (readTag == 26) {
                                this.transaction_ = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                Timestamp.Builder builder2 = this.readTime_ != null ? (Timestamp.Builder) this.readTime_.toBuilder() : null;
                                this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.readTime_);
                                    this.readTime_ = (Timestamp) builder2.buildPartial();
                                }
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
                    synchronized (BatchGetDocumentsResponse.class) {
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

    public static BatchGetDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BatchGetDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
