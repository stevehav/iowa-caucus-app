package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.TransactionOptions;
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
public final class RunQueryRequest extends GeneratedMessageLite<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
    /* access modifiers changed from: private */
    public static final RunQueryRequest DEFAULT_INSTANCE = new RunQueryRequest();
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 6;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 5;
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private String parent_ = "";
    private int queryTypeCase_ = 0;
    private Object queryType_;

    private RunQueryRequest() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum QueryTypeCase implements Internal.EnumLite {
        STRUCTURED_QUERY(2),
        QUERYTYPE_NOT_SET(0);
        
        private final int value;

        private QueryTypeCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static QueryTypeCase valueOf(int i) {
            return forNumber(i);
        }

        public static QueryTypeCase forNumber(int i) {
            if (i == 0) {
                return QUERYTYPE_NOT_SET;
            }
            if (i != 2) {
                return null;
            }
            return STRUCTURED_QUERY;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearQueryType() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum ConsistencySelectorCase implements Internal.EnumLite {
        TRANSACTION(5),
        NEW_TRANSACTION(6),
        READ_TIME(7),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        private ConsistencySelectorCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static ConsistencySelectorCase valueOf(int i) {
            return forNumber(i);
        }

        public static ConsistencySelectorCase forNumber(int i) {
            if (i == 0) {
                return CONSISTENCYSELECTOR_NOT_SET;
            }
            if (i == 5) {
                return TRANSACTION;
            }
            if (i == 6) {
                return NEW_TRANSACTION;
            }
            if (i != 7) {
                return null;
            }
            return READ_TIME;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    /* access modifiers changed from: private */
    public void clearConsistencySelector() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    public String getParent() {
        return this.parent_;
    }

    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    /* access modifiers changed from: private */
    public void setParent(String str) {
        if (str != null) {
            this.parent_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* access modifiers changed from: private */
    public void setParentBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.parent_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public StructuredQuery getStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            return (StructuredQuery) this.queryType_;
        }
        return StructuredQuery.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setStructuredQuery(StructuredQuery structuredQuery) {
        if (structuredQuery != null) {
            this.queryType_ = structuredQuery;
            this.queryTypeCase_ = 2;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setStructuredQuery(StructuredQuery.Builder builder) {
        this.queryType_ = builder.build();
        this.queryTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeStructuredQuery(StructuredQuery structuredQuery) {
        if (this.queryTypeCase_ != 2 || this.queryType_ == StructuredQuery.getDefaultInstance()) {
            this.queryType_ = structuredQuery;
        } else {
            this.queryType_ = ((StructuredQuery.Builder) StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom(structuredQuery)).buildPartial();
        }
        this.queryTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setTransaction(ByteString byteString) {
        if (byteString != null) {
            this.consistencySelectorCase_ = 5;
            this.consistencySelector_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public TransactionOptions getNewTransaction() {
        if (this.consistencySelectorCase_ == 6) {
            return (TransactionOptions) this.consistencySelector_;
        }
        return TransactionOptions.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions transactionOptions) {
        if (transactionOptions != null) {
            this.consistencySelector_ = transactionOptions;
            this.consistencySelectorCase_ = 6;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setNewTransaction(TransactionOptions.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeNewTransaction(TransactionOptions transactionOptions) {
        if (this.consistencySelectorCase_ != 6 || this.consistencySelector_ == TransactionOptions.getDefaultInstance()) {
            this.consistencySelector_ = transactionOptions;
        } else {
            this.consistencySelector_ = ((TransactionOptions.Builder) TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom(transactionOptions)).buildPartial();
        }
        this.consistencySelectorCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearNewTransaction() {
        if (this.consistencySelectorCase_ == 6) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.consistencySelector_ = timestamp;
            this.consistencySelectorCase_ = 7;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.consistencySelector_ = builder.build();
        this.consistencySelectorCase_ = 7;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        if (this.consistencySelectorCase_ != 7 || this.consistencySelector_ == Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = timestamp;
        } else {
            this.consistencySelector_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom(timestamp)).buildPartial();
        }
        this.consistencySelectorCase_ = 7;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.parent_.isEmpty()) {
            codedOutputStream.writeString(1, getParent());
        }
        if (this.queryTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            codedOutputStream.writeBytes(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            codedOutputStream.writeMessage(6, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            codedOutputStream.writeMessage(7, (Timestamp) this.consistencySelector_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.parent_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getParent());
        }
        if (this.queryTypeCase_ == 2) {
            i2 += CodedOutputStream.computeMessageSize(2, (StructuredQuery) this.queryType_);
        }
        if (this.consistencySelectorCase_ == 5) {
            i2 += CodedOutputStream.computeBytesSize(5, (ByteString) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 6) {
            i2 += CodedOutputStream.computeMessageSize(6, (TransactionOptions) this.consistencySelector_);
        }
        if (this.consistencySelectorCase_ == 7) {
            i2 += CodedOutputStream.computeMessageSize(7, (Timestamp) this.consistencySelector_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static RunQueryRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RunQueryRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RunQueryRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(InputStream inputStream) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RunQueryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunQueryRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RunQueryRequest runQueryRequest) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(runQueryRequest);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(RunQueryRequest.DEFAULT_INSTANCE);
        }

        public QueryTypeCase getQueryTypeCase() {
            return ((RunQueryRequest) this.instance).getQueryTypeCase();
        }

        public Builder clearQueryType() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearQueryType();
            return this;
        }

        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((RunQueryRequest) this.instance).getConsistencySelectorCase();
        }

        public Builder clearConsistencySelector() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearConsistencySelector();
            return this;
        }

        public String getParent() {
            return ((RunQueryRequest) this.instance).getParent();
        }

        public ByteString getParentBytes() {
            return ((RunQueryRequest) this.instance).getParentBytes();
        }

        public Builder setParent(String str) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setParent(str);
            return this;
        }

        public Builder clearParent() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearParent();
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setParentBytes(byteString);
            return this;
        }

        public StructuredQuery getStructuredQuery() {
            return ((RunQueryRequest) this.instance).getStructuredQuery();
        }

        public Builder setStructuredQuery(StructuredQuery structuredQuery) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setStructuredQuery(structuredQuery);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery.Builder builder) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setStructuredQuery(builder);
            return this;
        }

        public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeStructuredQuery(structuredQuery);
            return this;
        }

        public Builder clearStructuredQuery() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearStructuredQuery();
            return this;
        }

        public ByteString getTransaction() {
            return ((RunQueryRequest) this.instance).getTransaction();
        }

        public Builder setTransaction(ByteString byteString) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setTransaction(byteString);
            return this;
        }

        public Builder clearTransaction() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearTransaction();
            return this;
        }

        public TransactionOptions getNewTransaction() {
            return ((RunQueryRequest) this.instance).getNewTransaction();
        }

        public Builder setNewTransaction(TransactionOptions transactionOptions) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setNewTransaction(transactionOptions);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builder) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setNewTransaction(builder);
            return this;
        }

        public Builder mergeNewTransaction(TransactionOptions transactionOptions) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeNewTransaction(transactionOptions);
            return this;
        }

        public Builder clearNewTransaction() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearNewTransaction();
            return this;
        }

        public Timestamp getReadTime() {
            return ((RunQueryRequest) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setReadTime(timestamp);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).setReadTime(builder);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((RunQueryRequest) this.instance).mergeReadTime(timestamp);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((RunQueryRequest) this.instance).clearReadTime();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.RunQueryRequest$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase = new int[ConsistencySelectorCase.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase = new int[QueryTypeCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a6 */
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
                r3 = 4
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x004b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r4 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r5 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                com.google.firestore.v1.RunQueryRequest$ConsistencySelectorCase[] r4 = com.google.firestore.v1.RunQueryRequest.ConsistencySelectorCase.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase = r4
                int[] r4 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase     // Catch:{ NoSuchFieldError -> 0x0075 }
                com.google.firestore.v1.RunQueryRequest$ConsistencySelectorCase r5 = com.google.firestore.v1.RunQueryRequest.ConsistencySelectorCase.TRANSACTION     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r4 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase     // Catch:{ NoSuchFieldError -> 0x007f }
                com.google.firestore.v1.RunQueryRequest$ConsistencySelectorCase r5 = com.google.firestore.v1.RunQueryRequest.ConsistencySelectorCase.NEW_TRANSACTION     // Catch:{ NoSuchFieldError -> 0x007f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r4 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.google.firestore.v1.RunQueryRequest$ConsistencySelectorCase r5 = com.google.firestore.v1.RunQueryRequest.ConsistencySelectorCase.READ_TIME     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r2 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.google.firestore.v1.RunQueryRequest$ConsistencySelectorCase r4 = com.google.firestore.v1.RunQueryRequest.ConsistencySelectorCase.CONSISTENCYSELECTOR_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                com.google.firestore.v1.RunQueryRequest$QueryTypeCase[] r2 = com.google.firestore.v1.RunQueryRequest.QueryTypeCase.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase = r2
                int[] r2 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase     // Catch:{ NoSuchFieldError -> 0x00a6 }
                com.google.firestore.v1.RunQueryRequest$QueryTypeCase r3 = com.google.firestore.v1.RunQueryRequest.QueryTypeCase.STRUCTURED_QUERY     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                int[] r0 = $SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase     // Catch:{ NoSuchFieldError -> 0x00b0 }
                com.google.firestore.v1.RunQueryRequest$QueryTypeCase r2 = com.google.firestore.v1.RunQueryRequest.QueryTypeCase.QUERYTYPE_NOT_SET     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.RunQueryRequest.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new RunQueryRequest();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RunQueryRequest runQueryRequest = (RunQueryRequest) obj2;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !runQueryRequest.parent_.isEmpty(), runQueryRequest.parent_);
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase[runQueryRequest.getQueryTypeCase().ordinal()];
                if (i == 1) {
                    this.queryType_ = visitor.visitOneofMessage(this.queryTypeCase_ == 2, this.queryType_, runQueryRequest.queryType_);
                } else if (i == 2) {
                    visitor.visitOneofNotSet(this.queryTypeCase_ != 0);
                }
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase[runQueryRequest.getConsistencySelectorCase().ordinal()];
                if (i2 == 1) {
                    if (this.consistencySelectorCase_ == 5) {
                        z = true;
                    }
                    this.consistencySelector_ = visitor.visitOneofByteString(z, this.consistencySelector_, runQueryRequest.consistencySelector_);
                } else if (i2 == 2) {
                    if (this.consistencySelectorCase_ == 6) {
                        z = true;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, runQueryRequest.consistencySelector_);
                } else if (i2 == 3) {
                    if (this.consistencySelectorCase_ == 7) {
                        z = true;
                    }
                    this.consistencySelector_ = visitor.visitOneofMessage(z, this.consistencySelector_, runQueryRequest.consistencySelector_);
                } else if (i2 == 4) {
                    if (this.consistencySelectorCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i3 = runQueryRequest.queryTypeCase_;
                    if (i3 != 0) {
                        this.queryTypeCase_ = i3;
                    }
                    int i4 = runQueryRequest.consistencySelectorCase_;
                    if (i4 != 0) {
                        this.consistencySelectorCase_ = i4;
                    }
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
                                this.parent_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                StructuredQuery.Builder builder = this.queryTypeCase_ == 2 ? (StructuredQuery.Builder) ((StructuredQuery) this.queryType_).toBuilder() : null;
                                this.queryType_ = codedInputStream.readMessage(StructuredQuery.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((StructuredQuery) this.queryType_);
                                    this.queryType_ = builder.buildPartial();
                                }
                                this.queryTypeCase_ = 2;
                            } else if (readTag == 42) {
                                this.consistencySelectorCase_ = 5;
                                this.consistencySelector_ = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                TransactionOptions.Builder builder2 = this.consistencySelectorCase_ == 6 ? (TransactionOptions.Builder) ((TransactionOptions) this.consistencySelector_).toBuilder() : null;
                                this.consistencySelector_ = codedInputStream.readMessage(TransactionOptions.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((TransactionOptions) this.consistencySelector_);
                                    this.consistencySelector_ = builder2.buildPartial();
                                }
                                this.consistencySelectorCase_ = 6;
                            } else if (readTag == 58) {
                                Timestamp.Builder builder3 = this.consistencySelectorCase_ == 7 ? (Timestamp.Builder) ((Timestamp) this.consistencySelector_).toBuilder() : null;
                                this.consistencySelector_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((Timestamp) this.consistencySelector_);
                                    this.consistencySelector_ = builder3.buildPartial();
                                }
                                this.consistencySelectorCase_ = 7;
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
                    synchronized (RunQueryRequest.class) {
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

    public static RunQueryRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RunQueryRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
