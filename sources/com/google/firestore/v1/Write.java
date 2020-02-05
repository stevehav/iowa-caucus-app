package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Precondition;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Write extends GeneratedMessageLite<Write, Builder> implements WriteOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final Write DEFAULT_INSTANCE = new Write();
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile Parser<Write> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    private Precondition currentDocument_;
    private int operationCase_ = 0;
    private Object operation_;
    private DocumentMask updateMask_;

    private Write() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum OperationCase implements Internal.EnumLite {
        UPDATE(1),
        DELETE(2),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);
        
        private final int value;

        private OperationCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static OperationCase valueOf(int i) {
            return forNumber(i);
        }

        public static OperationCase forNumber(int i) {
            if (i == 0) {
                return OPERATION_NOT_SET;
            }
            if (i == 1) {
                return UPDATE;
            }
            if (i == 2) {
                return DELETE;
            }
            if (i != 6) {
                return null;
            }
            return TRANSFORM;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public OperationCase getOperationCase() {
        return OperationCase.forNumber(this.operationCase_);
    }

    /* access modifiers changed from: private */
    public void clearOperation() {
        this.operationCase_ = 0;
        this.operation_ = null;
    }

    public Document getUpdate() {
        if (this.operationCase_ == 1) {
            return (Document) this.operation_;
        }
        return Document.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setUpdate(Document document) {
        if (document != null) {
            this.operation_ = document;
            this.operationCase_ = 1;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setUpdate(Document.Builder builder) {
        this.operation_ = builder.build();
        this.operationCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void mergeUpdate(Document document) {
        if (this.operationCase_ != 1 || this.operation_ == Document.getDefaultInstance()) {
            this.operation_ = document;
        } else {
            this.operation_ = ((Document.Builder) Document.newBuilder((Document) this.operation_).mergeFrom(document)).buildPartial();
        }
        this.operationCase_ = 1;
    }

    /* access modifiers changed from: private */
    public void clearUpdate() {
        if (this.operationCase_ == 1) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    public String getDelete() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public ByteString getDeleteBytes() {
        return ByteString.copyFromUtf8(this.operationCase_ == 2 ? (String) this.operation_ : "");
    }

    /* access modifiers changed from: private */
    public void setDelete(String str) {
        if (str != null) {
            this.operationCase_ = 2;
            this.operation_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearDelete() {
        if (this.operationCase_ == 2) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setDeleteBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.operationCase_ = 2;
            this.operation_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public DocumentTransform getTransform() {
        if (this.operationCase_ == 6) {
            return (DocumentTransform) this.operation_;
        }
        return DocumentTransform.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setTransform(DocumentTransform documentTransform) {
        if (documentTransform != null) {
            this.operation_ = documentTransform;
            this.operationCase_ = 6;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setTransform(DocumentTransform.Builder builder) {
        this.operation_ = builder.build();
        this.operationCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeTransform(DocumentTransform documentTransform) {
        if (this.operationCase_ != 6 || this.operation_ == DocumentTransform.getDefaultInstance()) {
            this.operation_ = documentTransform;
        } else {
            this.operation_ = ((DocumentTransform.Builder) DocumentTransform.newBuilder((DocumentTransform) this.operation_).mergeFrom(documentTransform)).buildPartial();
        }
        this.operationCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearTransform() {
        if (this.operationCase_ == 6) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    public boolean hasUpdateMask() {
        return this.updateMask_ != null;
    }

    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        return documentMask == null ? DocumentMask.getDefaultInstance() : documentMask;
    }

    /* access modifiers changed from: private */
    public void setUpdateMask(DocumentMask documentMask) {
        if (documentMask != null) {
            this.updateMask_ = documentMask;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setUpdateMask(DocumentMask.Builder builder) {
        this.updateMask_ = (DocumentMask) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeUpdateMask(DocumentMask documentMask) {
        DocumentMask documentMask2 = this.updateMask_;
        if (documentMask2 == null || documentMask2 == DocumentMask.getDefaultInstance()) {
            this.updateMask_ = documentMask;
        } else {
            this.updateMask_ = (DocumentMask) ((DocumentMask.Builder) DocumentMask.newBuilder(this.updateMask_).mergeFrom(documentMask)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUpdateMask() {
        this.updateMask_ = null;
    }

    public boolean hasCurrentDocument() {
        return this.currentDocument_ != null;
    }

    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        return precondition == null ? Precondition.getDefaultInstance() : precondition;
    }

    /* access modifiers changed from: private */
    public void setCurrentDocument(Precondition precondition) {
        if (precondition != null) {
            this.currentDocument_ = precondition;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setCurrentDocument(Precondition.Builder builder) {
        this.currentDocument_ = (Precondition) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeCurrentDocument(Precondition precondition) {
        Precondition precondition2 = this.currentDocument_;
        if (precondition2 == null || precondition2 == Precondition.getDefaultInstance()) {
            this.currentDocument_ = precondition;
        } else {
            this.currentDocument_ = (Precondition) ((Precondition.Builder) Precondition.newBuilder(this.currentDocument_).mergeFrom(precondition)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCurrentDocument() {
        this.currentDocument_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.operationCase_ == 1) {
            codedOutputStream.writeMessage(1, (Document) this.operation_);
        }
        if (this.operationCase_ == 2) {
            codedOutputStream.writeString(2, getDelete());
        }
        if (this.updateMask_ != null) {
            codedOutputStream.writeMessage(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            codedOutputStream.writeMessage(4, getCurrentDocument());
        }
        if (this.operationCase_ == 6) {
            codedOutputStream.writeMessage(6, (DocumentTransform) this.operation_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.operationCase_ == 1) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, (Document) this.operation_);
        }
        if (this.operationCase_ == 2) {
            i2 += CodedOutputStream.computeStringSize(2, getDelete());
        }
        if (this.updateMask_ != null) {
            i2 += CodedOutputStream.computeMessageSize(3, getUpdateMask());
        }
        if (this.currentDocument_ != null) {
            i2 += CodedOutputStream.computeMessageSize(4, getCurrentDocument());
        }
        if (this.operationCase_ == 6) {
            i2 += CodedOutputStream.computeMessageSize(6, (DocumentTransform) this.operation_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Write parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Write parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Write parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Write parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Write parseFrom(InputStream inputStream) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Write) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Write parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Write write) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(write);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<Write, Builder> implements WriteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Write.DEFAULT_INSTANCE);
        }

        public OperationCase getOperationCase() {
            return ((Write) this.instance).getOperationCase();
        }

        public Builder clearOperation() {
            copyOnWrite();
            ((Write) this.instance).clearOperation();
            return this;
        }

        public Document getUpdate() {
            return ((Write) this.instance).getUpdate();
        }

        public Builder setUpdate(Document document) {
            copyOnWrite();
            ((Write) this.instance).setUpdate(document);
            return this;
        }

        public Builder setUpdate(Document.Builder builder) {
            copyOnWrite();
            ((Write) this.instance).setUpdate(builder);
            return this;
        }

        public Builder mergeUpdate(Document document) {
            copyOnWrite();
            ((Write) this.instance).mergeUpdate(document);
            return this;
        }

        public Builder clearUpdate() {
            copyOnWrite();
            ((Write) this.instance).clearUpdate();
            return this;
        }

        public String getDelete() {
            return ((Write) this.instance).getDelete();
        }

        public ByteString getDeleteBytes() {
            return ((Write) this.instance).getDeleteBytes();
        }

        public Builder setDelete(String str) {
            copyOnWrite();
            ((Write) this.instance).setDelete(str);
            return this;
        }

        public Builder clearDelete() {
            copyOnWrite();
            ((Write) this.instance).clearDelete();
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            copyOnWrite();
            ((Write) this.instance).setDeleteBytes(byteString);
            return this;
        }

        public DocumentTransform getTransform() {
            return ((Write) this.instance).getTransform();
        }

        public Builder setTransform(DocumentTransform documentTransform) {
            copyOnWrite();
            ((Write) this.instance).setTransform(documentTransform);
            return this;
        }

        public Builder setTransform(DocumentTransform.Builder builder) {
            copyOnWrite();
            ((Write) this.instance).setTransform(builder);
            return this;
        }

        public Builder mergeTransform(DocumentTransform documentTransform) {
            copyOnWrite();
            ((Write) this.instance).mergeTransform(documentTransform);
            return this;
        }

        public Builder clearTransform() {
            copyOnWrite();
            ((Write) this.instance).clearTransform();
            return this;
        }

        public boolean hasUpdateMask() {
            return ((Write) this.instance).hasUpdateMask();
        }

        public DocumentMask getUpdateMask() {
            return ((Write) this.instance).getUpdateMask();
        }

        public Builder setUpdateMask(DocumentMask documentMask) {
            copyOnWrite();
            ((Write) this.instance).setUpdateMask(documentMask);
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builder) {
            copyOnWrite();
            ((Write) this.instance).setUpdateMask(builder);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask documentMask) {
            copyOnWrite();
            ((Write) this.instance).mergeUpdateMask(documentMask);
            return this;
        }

        public Builder clearUpdateMask() {
            copyOnWrite();
            ((Write) this.instance).clearUpdateMask();
            return this;
        }

        public boolean hasCurrentDocument() {
            return ((Write) this.instance).hasCurrentDocument();
        }

        public Precondition getCurrentDocument() {
            return ((Write) this.instance).getCurrentDocument();
        }

        public Builder setCurrentDocument(Precondition precondition) {
            copyOnWrite();
            ((Write) this.instance).setCurrentDocument(precondition);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builder) {
            copyOnWrite();
            ((Write) this.instance).setCurrentDocument(builder);
            return this;
        }

        public Builder mergeCurrentDocument(Precondition precondition) {
            copyOnWrite();
            ((Write) this.instance).mergeCurrentDocument(precondition);
            return this;
        }

        public Builder clearCurrentDocument() {
            copyOnWrite();
            ((Write) this.instance).clearCurrentDocument();
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.Write$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Write$OperationCase = new int[OperationCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0089 */
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
                com.google.firestore.v1.Write$OperationCase[] r4 = com.google.firestore.v1.Write.OperationCase.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$google$firestore$v1$Write$OperationCase = r4
                int[] r4 = $SwitchMap$com$google$firestore$v1$Write$OperationCase     // Catch:{ NoSuchFieldError -> 0x0075 }
                com.google.firestore.v1.Write$OperationCase r5 = com.google.firestore.v1.Write.OperationCase.UPDATE     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r0 = $SwitchMap$com$google$firestore$v1$Write$OperationCase     // Catch:{ NoSuchFieldError -> 0x007f }
                com.google.firestore.v1.Write$OperationCase r4 = com.google.firestore.v1.Write.OperationCase.DELETE     // Catch:{ NoSuchFieldError -> 0x007f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r0 = $SwitchMap$com$google$firestore$v1$Write$OperationCase     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.google.firestore.v1.Write$OperationCase r1 = com.google.firestore.v1.Write.OperationCase.TRANSFORM     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r0 = $SwitchMap$com$google$firestore$v1$Write$OperationCase     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.google.firestore.v1.Write$OperationCase r1 = com.google.firestore.v1.Write.OperationCase.OPERATION_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Write.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Write();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Write write = (Write) obj2;
                this.updateMask_ = (DocumentMask) visitor.visitMessage(this.updateMask_, write.updateMask_);
                this.currentDocument_ = (Precondition) visitor.visitMessage(this.currentDocument_, write.currentDocument_);
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Write$OperationCase[write.getOperationCase().ordinal()];
                if (i2 == 1) {
                    if (this.operationCase_ == 1) {
                        z = true;
                    }
                    this.operation_ = visitor.visitOneofMessage(z, this.operation_, write.operation_);
                } else if (i2 == 2) {
                    if (this.operationCase_ == 2) {
                        z = true;
                    }
                    this.operation_ = visitor.visitOneofString(z, this.operation_, write.operation_);
                } else if (i2 == 3) {
                    if (this.operationCase_ == 6) {
                        z = true;
                    }
                    this.operation_ = visitor.visitOneofMessage(z, this.operation_, write.operation_);
                } else if (i2 == 4) {
                    if (this.operationCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = write.operationCase_) != 0) {
                    this.operationCase_ = i;
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
                                Document.Builder builder = this.operationCase_ == 1 ? (Document.Builder) ((Document) this.operation_).toBuilder() : null;
                                this.operation_ = codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Document) this.operation_);
                                    this.operation_ = builder.buildPartial();
                                }
                                this.operationCase_ = 1;
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.operationCase_ = 2;
                                this.operation_ = readStringRequireUtf8;
                            } else if (readTag == 26) {
                                DocumentMask.Builder builder2 = this.updateMask_ != null ? (DocumentMask.Builder) this.updateMask_.toBuilder() : null;
                                this.updateMask_ = (DocumentMask) codedInputStream.readMessage(DocumentMask.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.updateMask_);
                                    this.updateMask_ = (DocumentMask) builder2.buildPartial();
                                }
                            } else if (readTag == 34) {
                                Precondition.Builder builder3 = this.currentDocument_ != null ? (Precondition.Builder) this.currentDocument_.toBuilder() : null;
                                this.currentDocument_ = (Precondition) codedInputStream.readMessage(Precondition.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.currentDocument_);
                                    this.currentDocument_ = (Precondition) builder3.buildPartial();
                                }
                            } else if (readTag == 50) {
                                DocumentTransform.Builder builder4 = this.operationCase_ == 6 ? (DocumentTransform.Builder) ((DocumentTransform) this.operation_).toBuilder() : null;
                                this.operation_ = codedInputStream.readMessage(DocumentTransform.parser(), extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom((DocumentTransform) this.operation_);
                                    this.operation_ = builder4.buildPartial();
                                }
                                this.operationCase_ = 6;
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
                    synchronized (Write.class) {
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

    public static Write getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Write> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
