package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class DocumentChange extends GeneratedMessageLite<DocumentChange, Builder> implements DocumentChangeOrBuilder {
    /* access modifiers changed from: private */
    public static final DocumentChange DEFAULT_INSTANCE = new DocumentChange();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentChange> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private int bitField0_;
    private Document document_;
    private Internal.IntList removedTargetIds_ = emptyIntList();
    private Internal.IntList targetIds_ = emptyIntList();

    private DocumentChange() {
    }

    public boolean hasDocument() {
        return this.document_ != null;
    }

    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    /* access modifiers changed from: private */
    public void setDocument(Document document) {
        if (document != null) {
            this.document_ = document;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setDocument(Document.Builder builder) {
        this.document_ = (Document) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeDocument(Document document) {
        Document document2 = this.document_;
        if (document2 == null || document2 == Document.getDefaultInstance()) {
            this.document_ = document;
        } else {
            this.document_ = (Document) ((Document.Builder) Document.newBuilder(this.document_).mergeFrom(document)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
    }

    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    public int getTargetIds(int i) {
        return this.targetIds_.getInt(i);
    }

    private void ensureTargetIdsIsMutable() {
        if (!this.targetIds_.isModifiable()) {
            this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setTargetIds(int i, int i2) {
        ensureTargetIdsIsMutable();
        this.targetIds_.setInt(i, i2);
    }

    /* access modifiers changed from: private */
    public void addTargetIds(int i) {
        ensureTargetIdsIsMutable();
        this.targetIds_.addInt(i);
    }

    /* access modifiers changed from: private */
    public void addAllTargetIds(Iterable<? extends Integer> iterable) {
        ensureTargetIdsIsMutable();
        AbstractMessageLite.addAll(iterable, this.targetIds_);
    }

    /* access modifiers changed from: private */
    public void clearTargetIds() {
        this.targetIds_ = emptyIntList();
    }

    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    public int getRemovedTargetIds(int i) {
        return this.removedTargetIds_.getInt(i);
    }

    private void ensureRemovedTargetIdsIsMutable() {
        if (!this.removedTargetIds_.isModifiable()) {
            this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setRemovedTargetIds(int i, int i2) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.setInt(i, i2);
    }

    /* access modifiers changed from: private */
    public void addRemovedTargetIds(int i) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.addInt(i);
    }

    /* access modifiers changed from: private */
    public void addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
        ensureRemovedTargetIdsIsMutable();
        AbstractMessageLite.addAll(iterable, this.removedTargetIds_);
    }

    /* access modifiers changed from: private */
    public void clearRemovedTargetIds() {
        this.removedTargetIds_ = emptyIntList();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if (this.document_ != null) {
            codedOutputStream.writeMessage(1, getDocument());
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            codedOutputStream.writeInt32(5, this.targetIds_.getInt(i));
        }
        for (int i2 = 0; i2 < this.removedTargetIds_.size(); i2++) {
            codedOutputStream.writeInt32(6, this.removedTargetIds_.getInt(i2));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.document_ != null ? CodedOutputStream.computeMessageSize(1, getDocument()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.targetIds_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i3));
        }
        int size = computeMessageSize + i2 + (getTargetIdsList().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.removedTargetIds_.size(); i5++) {
            i4 += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(i5));
        }
        int size2 = size + i4 + (getRemovedTargetIdsList().size() * 1);
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static DocumentChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(InputStream inputStream) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DocumentChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentChange documentChange) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(documentChange);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentChange, Builder> implements DocumentChangeOrBuilder {
        private Builder() {
            super(DocumentChange.DEFAULT_INSTANCE);
        }

        public boolean hasDocument() {
            return ((DocumentChange) this.instance).hasDocument();
        }

        public Document getDocument() {
            return ((DocumentChange) this.instance).getDocument();
        }

        public Builder setDocument(Document document) {
            copyOnWrite();
            ((DocumentChange) this.instance).setDocument(document);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            copyOnWrite();
            ((DocumentChange) this.instance).setDocument(builder);
            return this;
        }

        public Builder mergeDocument(Document document) {
            copyOnWrite();
            ((DocumentChange) this.instance).mergeDocument(document);
            return this;
        }

        public Builder clearDocument() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearDocument();
            return this;
        }

        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.instance).getTargetIdsList());
        }

        public int getTargetIdsCount() {
            return ((DocumentChange) this.instance).getTargetIdsCount();
        }

        public int getTargetIds(int i) {
            return ((DocumentChange) this.instance).getTargetIds(i);
        }

        public Builder setTargetIds(int i, int i2) {
            copyOnWrite();
            ((DocumentChange) this.instance).setTargetIds(i, i2);
            return this;
        }

        public Builder addTargetIds(int i) {
            copyOnWrite();
            ((DocumentChange) this.instance).addTargetIds(i);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((DocumentChange) this.instance).addAllTargetIds(iterable);
            return this;
        }

        public Builder clearTargetIds() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearTargetIds();
            return this;
        }

        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.instance).getRemovedTargetIdsList());
        }

        public int getRemovedTargetIdsCount() {
            return ((DocumentChange) this.instance).getRemovedTargetIdsCount();
        }

        public int getRemovedTargetIds(int i) {
            return ((DocumentChange) this.instance).getRemovedTargetIds(i);
        }

        public Builder setRemovedTargetIds(int i, int i2) {
            copyOnWrite();
            ((DocumentChange) this.instance).setRemovedTargetIds(i, i2);
            return this;
        }

        public Builder addRemovedTargetIds(int i) {
            copyOnWrite();
            ((DocumentChange) this.instance).addRemovedTargetIds(i);
            return this;
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((DocumentChange) this.instance).addAllRemovedTargetIds(iterable);
            return this;
        }

        public Builder clearRemovedTargetIds() {
            copyOnWrite();
            ((DocumentChange) this.instance).clearRemovedTargetIds();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new DocumentChange();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.targetIds_.makeImmutable();
                this.removedTargetIds_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentChange documentChange = (DocumentChange) obj2;
                this.document_ = (Document) visitor.visitMessage(this.document_, documentChange.document_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, documentChange.targetIds_);
                this.removedTargetIds_ = visitor.visitIntList(this.removedTargetIds_, documentChange.removedTargetIds_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentChange.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Document.Builder builder = this.document_ != null ? (Document.Builder) this.document_.toBuilder() : null;
                                this.document_ = (Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.document_);
                                    this.document_ = (Document) builder.buildPartial();
                                }
                            } else if (readTag == 40) {
                                if (!this.targetIds_.isModifiable()) {
                                    this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                                }
                                this.targetIds_.addInt(codedInputStream.readInt32());
                            } else if (readTag == 42) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.targetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.targetIds_.addInt(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 48) {
                                if (!this.removedTargetIds_.isModifiable()) {
                                    this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                                }
                                this.removedTargetIds_.addInt(codedInputStream.readInt32());
                            } else if (readTag == 50) {
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.removedTargetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.removedTargetIds_.addInt(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(pushLimit2);
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
                    synchronized (DocumentChange.class) {
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

    public static DocumentChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DocumentChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
