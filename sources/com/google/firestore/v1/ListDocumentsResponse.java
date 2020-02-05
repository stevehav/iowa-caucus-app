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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class ListDocumentsResponse extends GeneratedMessageLite<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final ListDocumentsResponse DEFAULT_INSTANCE = new ListDocumentsResponse();
    public static final int DOCUMENTS_FIELD_NUMBER = 1;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListDocumentsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<Document> documents_ = emptyProtobufList();
    private String nextPageToken_ = "";

    private ListDocumentsResponse() {
    }

    public List<Document> getDocumentsList() {
        return this.documents_;
    }

    public List<? extends DocumentOrBuilder> getDocumentsOrBuilderList() {
        return this.documents_;
    }

    public int getDocumentsCount() {
        return this.documents_.size();
    }

    public Document getDocuments(int i) {
        return (Document) this.documents_.get(i);
    }

    public DocumentOrBuilder getDocumentsOrBuilder(int i) {
        return (DocumentOrBuilder) this.documents_.get(i);
    }

    private void ensureDocumentsIsMutable() {
        if (!this.documents_.isModifiable()) {
            this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
        }
    }

    /* access modifiers changed from: private */
    public void setDocuments(int i, Document document) {
        if (document != null) {
            ensureDocumentsIsMutable();
            this.documents_.set(i, document);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setDocuments(int i, Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.set(i, (Document) builder.build());
    }

    /* access modifiers changed from: private */
    public void addDocuments(Document document) {
        if (document != null) {
            ensureDocumentsIsMutable();
            this.documents_.add(document);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addDocuments(int i, Document document) {
        if (document != null) {
            ensureDocumentsIsMutable();
            this.documents_.add(i, document);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addDocuments(Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.add((Document) builder.build());
    }

    /* access modifiers changed from: private */
    public void addDocuments(int i, Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.add(i, (Document) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllDocuments(Iterable<? extends Document> iterable) {
        ensureDocumentsIsMutable();
        AbstractMessageLite.addAll(iterable, this.documents_);
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        this.documents_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeDocuments(int i) {
        ensureDocumentsIsMutable();
        this.documents_.remove(i);
    }

    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    /* access modifiers changed from: private */
    public void setNextPageToken(String str) {
        if (str != null) {
            this.nextPageToken_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* access modifiers changed from: private */
    public void setNextPageTokenBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.nextPageToken_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.documents_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.documents_.get(i));
        }
        if (!this.nextPageToken_.isEmpty()) {
            codedOutputStream.writeString(2, getNextPageToken());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.documents_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.documents_.get(i3));
        }
        if (!this.nextPageToken_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListDocumentsResponse listDocumentsResponse) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(listDocumentsResponse);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
        private Builder() {
            super(ListDocumentsResponse.DEFAULT_INSTANCE);
        }

        public List<Document> getDocumentsList() {
            return Collections.unmodifiableList(((ListDocumentsResponse) this.instance).getDocumentsList());
        }

        public int getDocumentsCount() {
            return ((ListDocumentsResponse) this.instance).getDocumentsCount();
        }

        public Document getDocuments(int i) {
            return ((ListDocumentsResponse) this.instance).getDocuments(i);
        }

        public Builder setDocuments(int i, Document document) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setDocuments(i, document);
            return this;
        }

        public Builder setDocuments(int i, Document.Builder builder) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setDocuments(i, builder);
            return this;
        }

        public Builder addDocuments(Document document) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(document);
            return this;
        }

        public Builder addDocuments(int i, Document document) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(i, document);
            return this;
        }

        public Builder addDocuments(Document.Builder builder) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(builder);
            return this;
        }

        public Builder addDocuments(int i, Document.Builder builder) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addDocuments(i, builder);
            return this;
        }

        public Builder addAllDocuments(Iterable<? extends Document> iterable) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).addAllDocuments(iterable);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).clearDocuments();
            return this;
        }

        public Builder removeDocuments(int i) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).removeDocuments(i);
            return this;
        }

        public String getNextPageToken() {
            return ((ListDocumentsResponse) this.instance).getNextPageToken();
        }

        public ByteString getNextPageTokenBytes() {
            return ((ListDocumentsResponse) this.instance).getNextPageTokenBytes();
        }

        public Builder setNextPageToken(String str) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setNextPageToken(str);
            return this;
        }

        public Builder clearNextPageToken() {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).clearNextPageToken();
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            copyOnWrite();
            ((ListDocumentsResponse) this.instance).setNextPageTokenBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new ListDocumentsResponse();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.documents_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListDocumentsResponse listDocumentsResponse = (ListDocumentsResponse) obj2;
                this.documents_ = visitor.visitList(this.documents_, listDocumentsResponse.documents_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, true ^ listDocumentsResponse.nextPageToken_.isEmpty(), listDocumentsResponse.nextPageToken_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= listDocumentsResponse.bitField0_;
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
                                if (!this.documents_.isModifiable()) {
                                    this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
                                }
                                this.documents_.add((Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite));
                            } else if (readTag == 18) {
                                this.nextPageToken_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ListDocumentsResponse.class) {
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

    public static ListDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
