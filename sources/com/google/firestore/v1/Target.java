package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
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
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    /* access modifiers changed from: private */
    public static final Target DEFAULT_INSTANCE = new Target();
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private boolean once_;
    private int resumeTypeCase_ = 0;
    private Object resumeType_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public interface DocumentsTargetOrBuilder extends MessageLiteOrBuilder {
        String getDocuments(int i);

        ByteString getDocumentsBytes(int i);

        int getDocumentsCount();

        List<String> getDocumentsList();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public interface QueryTargetOrBuilder extends MessageLiteOrBuilder {
        String getParent();

        ByteString getParentBytes();

        QueryTarget.QueryTypeCase getQueryTypeCase();

        StructuredQuery getStructuredQuery();
    }

    private Target() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class DocumentsTarget extends GeneratedMessageLite<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
        /* access modifiers changed from: private */
        public static final DocumentsTarget DEFAULT_INSTANCE = new DocumentsTarget();
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile Parser<DocumentsTarget> PARSER;
        private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.emptyProtobufList();

        private DocumentsTarget() {
        }

        public List<String> getDocumentsList() {
            return this.documents_;
        }

        public int getDocumentsCount() {
            return this.documents_.size();
        }

        public String getDocuments(int i) {
            return (String) this.documents_.get(i);
        }

        public ByteString getDocumentsBytes(int i) {
            return ByteString.copyFromUtf8((String) this.documents_.get(i));
        }

        private void ensureDocumentsIsMutable() {
            if (!this.documents_.isModifiable()) {
                this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
            }
        }

        /* access modifiers changed from: private */
        public void setDocuments(int i, String str) {
            if (str != null) {
                ensureDocumentsIsMutable();
                this.documents_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addDocuments(String str) {
            if (str != null) {
                ensureDocumentsIsMutable();
                this.documents_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllDocuments(Iterable<String> iterable) {
            ensureDocumentsIsMutable();
            AbstractMessageLite.addAll(iterable, this.documents_);
        }

        /* access modifiers changed from: private */
        public void clearDocuments() {
            this.documents_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addDocumentsBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                ensureDocumentsIsMutable();
                this.documents_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.documents_.size(); i++) {
                codedOutputStream.writeString(2, (String) this.documents_.get(i));
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.documents_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.documents_.get(i3));
            }
            int size = 0 + i2 + (getDocumentsList().size() * 1);
            this.memoizedSerializedSize = size;
            return size;
        }

        public static DocumentsTarget parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DocumentsTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DocumentsTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DocumentsTarget) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DocumentsTarget documentsTarget) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(documentsTarget);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
        public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(DocumentsTarget.DEFAULT_INSTANCE);
            }

            public List<String> getDocumentsList() {
                return Collections.unmodifiableList(((DocumentsTarget) this.instance).getDocumentsList());
            }

            public int getDocumentsCount() {
                return ((DocumentsTarget) this.instance).getDocumentsCount();
            }

            public String getDocuments(int i) {
                return ((DocumentsTarget) this.instance).getDocuments(i);
            }

            public ByteString getDocumentsBytes(int i) {
                return ((DocumentsTarget) this.instance).getDocumentsBytes(i);
            }

            public Builder setDocuments(int i, String str) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).setDocuments(i, str);
                return this;
            }

            public Builder addDocuments(String str) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addDocuments(str);
                return this;
            }

            public Builder addAllDocuments(Iterable<String> iterable) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addAllDocuments(iterable);
                return this;
            }

            public Builder clearDocuments() {
                copyOnWrite();
                ((DocumentsTarget) this.instance).clearDocuments();
                return this;
            }

            public Builder addDocumentsBytes(ByteString byteString) {
                copyOnWrite();
                ((DocumentsTarget) this.instance).addDocumentsBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new DocumentsTarget();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.documents_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder((AnonymousClass1) null);
                case VISIT:
                    this.documents_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.documents_, ((DocumentsTarget) obj2).documents_);
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
                                if (readTag == 18) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.documents_.isModifiable()) {
                                        this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_);
                                    }
                                    this.documents_.add(readStringRequireUtf8);
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
                        synchronized (DocumentsTarget.class) {
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

        public static DocumentsTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DocumentsTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class QueryTarget extends GeneratedMessageLite<QueryTarget, Builder> implements QueryTargetOrBuilder {
        /* access modifiers changed from: private */
        public static final QueryTarget DEFAULT_INSTANCE = new QueryTarget();
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile Parser<QueryTarget> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private String parent_ = "";
        private int queryTypeCase_ = 0;
        private Object queryType_;

        private QueryTarget() {
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

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.parent_.isEmpty()) {
                codedOutputStream.writeString(1, getParent());
            }
            if (this.queryTypeCase_ == 2) {
                codedOutputStream.writeMessage(2, (StructuredQuery) this.queryType_);
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
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static QueryTarget parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static QueryTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static QueryTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(InputStream inputStream) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (QueryTarget) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryTarget queryTarget) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(queryTarget);
        }

        /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
        public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, Builder> implements QueryTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(QueryTarget.DEFAULT_INSTANCE);
            }

            public QueryTypeCase getQueryTypeCase() {
                return ((QueryTarget) this.instance).getQueryTypeCase();
            }

            public Builder clearQueryType() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearQueryType();
                return this;
            }

            public String getParent() {
                return ((QueryTarget) this.instance).getParent();
            }

            public ByteString getParentBytes() {
                return ((QueryTarget) this.instance).getParentBytes();
            }

            public Builder setParent(String str) {
                copyOnWrite();
                ((QueryTarget) this.instance).setParent(str);
                return this;
            }

            public Builder clearParent() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearParent();
                return this;
            }

            public Builder setParentBytes(ByteString byteString) {
                copyOnWrite();
                ((QueryTarget) this.instance).setParentBytes(byteString);
                return this;
            }

            public StructuredQuery getStructuredQuery() {
                return ((QueryTarget) this.instance).getStructuredQuery();
            }

            public Builder setStructuredQuery(StructuredQuery structuredQuery) {
                copyOnWrite();
                ((QueryTarget) this.instance).setStructuredQuery(structuredQuery);
                return this;
            }

            public Builder setStructuredQuery(StructuredQuery.Builder builder) {
                copyOnWrite();
                ((QueryTarget) this.instance).setStructuredQuery(builder);
                return this;
            }

            public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
                copyOnWrite();
                ((QueryTarget) this.instance).mergeStructuredQuery(structuredQuery);
                return this;
            }

            public Builder clearStructuredQuery() {
                copyOnWrite();
                ((QueryTarget) this.instance).clearStructuredQuery();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new QueryTarget();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder((AnonymousClass1) null);
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    QueryTarget queryTarget = (QueryTarget) obj2;
                    this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !queryTarget.parent_.isEmpty(), queryTarget.parent_);
                    int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase[queryTarget.getQueryTypeCase().ordinal()];
                    if (i2 == 1) {
                        if (this.queryTypeCase_ == 2) {
                            z = true;
                        }
                        this.queryType_ = visitor.visitOneofMessage(z, this.queryType_, queryTarget.queryType_);
                    } else if (i2 == 2) {
                        if (this.queryTypeCase_ != 0) {
                            z = true;
                        }
                        visitor.visitOneofNotSet(z);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = queryTarget.queryTypeCase_) != 0) {
                        this.queryTypeCase_ = i;
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
                        synchronized (QueryTarget.class) {
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

        public static QueryTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum TargetTypeCase implements Internal.EnumLite {
        QUERY(2),
        DOCUMENTS(3),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        private TargetTypeCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i) {
            return forNumber(i);
        }

        public static TargetTypeCase forNumber(int i) {
            if (i == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i == 2) {
                return QUERY;
            }
            if (i != 3) {
                return null;
            }
            return DOCUMENTS;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum ResumeTypeCase implements Internal.EnumLite {
        RESUME_TOKEN(4),
        READ_TIME(11),
        RESUMETYPE_NOT_SET(0);
        
        private final int value;

        private ResumeTypeCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static ResumeTypeCase valueOf(int i) {
            return forNumber(i);
        }

        public static ResumeTypeCase forNumber(int i) {
            if (i == 0) {
                return RESUMETYPE_NOT_SET;
            }
            if (i == 4) {
                return RESUME_TOKEN;
            }
            if (i != 11) {
                return null;
            }
            return READ_TIME;
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ResumeTypeCase getResumeTypeCase() {
        return ResumeTypeCase.forNumber(this.resumeTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearResumeType() {
        this.resumeTypeCase_ = 0;
        this.resumeType_ = null;
    }

    public QueryTarget getQuery() {
        if (this.targetTypeCase_ == 2) {
            return (QueryTarget) this.targetType_;
        }
        return QueryTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setQuery(QueryTarget queryTarget) {
        if (queryTarget != null) {
            this.targetType_ = queryTarget;
            this.targetTypeCase_ = 2;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setQuery(QueryTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void mergeQuery(QueryTarget queryTarget) {
        if (this.targetTypeCase_ != 2 || this.targetType_ == QueryTarget.getDefaultInstance()) {
            this.targetType_ = queryTarget;
        } else {
            this.targetType_ = ((QueryTarget.Builder) QueryTarget.newBuilder((QueryTarget) this.targetType_).mergeFrom(queryTarget)).buildPartial();
        }
        this.targetTypeCase_ = 2;
    }

    /* access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 2) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public DocumentsTarget getDocuments() {
        if (this.targetTypeCase_ == 3) {
            return (DocumentsTarget) this.targetType_;
        }
        return DocumentsTarget.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setDocuments(DocumentsTarget documentsTarget) {
        if (documentsTarget != null) {
            this.targetType_ = documentsTarget;
            this.targetTypeCase_ = 3;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setDocuments(DocumentsTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void mergeDocuments(DocumentsTarget documentsTarget) {
        if (this.targetTypeCase_ != 3 || this.targetType_ == DocumentsTarget.getDefaultInstance()) {
            this.targetType_ = documentsTarget;
        } else {
            this.targetType_ = ((DocumentsTarget.Builder) DocumentsTarget.newBuilder((DocumentsTarget) this.targetType_).mergeFrom(documentsTarget)).buildPartial();
        }
        this.targetTypeCase_ = 3;
    }

    /* access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 3) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    public ByteString getResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            return (ByteString) this.resumeType_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setResumeToken(ByteString byteString) {
        if (byteString != null) {
            this.resumeTypeCase_ = 4;
            this.resumeType_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    public Timestamp getReadTime() {
        if (this.resumeTypeCase_ == 11) {
            return (Timestamp) this.resumeType_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.resumeType_ = timestamp;
            this.resumeTypeCase_ = 11;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.resumeType_ = builder.build();
        this.resumeTypeCase_ = 11;
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        if (this.resumeTypeCase_ != 11 || this.resumeType_ == Timestamp.getDefaultInstance()) {
            this.resumeType_ = timestamp;
        } else {
            this.resumeType_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.resumeType_).mergeFrom(timestamp)).buildPartial();
        }
        this.resumeTypeCase_ = 11;
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        if (this.resumeTypeCase_ == 11) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    public int getTargetId() {
        return this.targetId_;
    }

    /* access modifiers changed from: private */
    public void setTargetId(int i) {
        this.targetId_ = i;
    }

    /* access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    public boolean getOnce() {
        return this.once_;
    }

    /* access modifiers changed from: private */
    public void setOnce(boolean z) {
        this.once_ = z;
    }

    /* access modifiers changed from: private */
    public void clearOnce() {
        this.once_ = false;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.targetTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 3) {
            codedOutputStream.writeMessage(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            codedOutputStream.writeBytes(4, (ByteString) this.resumeType_);
        }
        int i = this.targetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(5, i);
        }
        boolean z = this.once_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            codedOutputStream.writeMessage(11, (Timestamp) this.resumeType_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.targetTypeCase_ == 2) {
            i2 = 0 + CodedOutputStream.computeMessageSize(2, (QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 3) {
            i2 += CodedOutputStream.computeMessageSize(3, (DocumentsTarget) this.targetType_);
        }
        if (this.resumeTypeCase_ == 4) {
            i2 += CodedOutputStream.computeBytesSize(4, (ByteString) this.resumeType_);
        }
        int i3 = this.targetId_;
        if (i3 != 0) {
            i2 += CodedOutputStream.computeInt32Size(5, i3);
        }
        boolean z = this.once_;
        if (z) {
            i2 += CodedOutputStream.computeBoolSize(6, z);
        }
        if (this.resumeTypeCase_ == 11) {
            i2 += CodedOutputStream.computeMessageSize(11, (Timestamp) this.resumeType_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Target parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Target parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Target parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Target parseFrom(InputStream inputStream) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Target parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Target target) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(target);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.instance).getTargetTypeCase();
        }

        public Builder clearTargetType() {
            copyOnWrite();
            ((Target) this.instance).clearTargetType();
            return this;
        }

        public ResumeTypeCase getResumeTypeCase() {
            return ((Target) this.instance).getResumeTypeCase();
        }

        public Builder clearResumeType() {
            copyOnWrite();
            ((Target) this.instance).clearResumeType();
            return this;
        }

        public QueryTarget getQuery() {
            return ((Target) this.instance).getQuery();
        }

        public Builder setQuery(QueryTarget queryTarget) {
            copyOnWrite();
            ((Target) this.instance).setQuery(queryTarget);
            return this;
        }

        public Builder setQuery(QueryTarget.Builder builder) {
            copyOnWrite();
            ((Target) this.instance).setQuery(builder);
            return this;
        }

        public Builder mergeQuery(QueryTarget queryTarget) {
            copyOnWrite();
            ((Target) this.instance).mergeQuery(queryTarget);
            return this;
        }

        public Builder clearQuery() {
            copyOnWrite();
            ((Target) this.instance).clearQuery();
            return this;
        }

        public DocumentsTarget getDocuments() {
            return ((Target) this.instance).getDocuments();
        }

        public Builder setDocuments(DocumentsTarget documentsTarget) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(documentsTarget);
            return this;
        }

        public Builder setDocuments(DocumentsTarget.Builder builder) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(builder);
            return this;
        }

        public Builder mergeDocuments(DocumentsTarget documentsTarget) {
            copyOnWrite();
            ((Target) this.instance).mergeDocuments(documentsTarget);
            return this;
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((Target) this.instance).clearDocuments();
            return this;
        }

        public ByteString getResumeToken() {
            return ((Target) this.instance).getResumeToken();
        }

        public Builder setResumeToken(ByteString byteString) {
            copyOnWrite();
            ((Target) this.instance).setResumeToken(byteString);
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((Target) this.instance).clearResumeToken();
            return this;
        }

        public Timestamp getReadTime() {
            return ((Target) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((Target) this.instance).setReadTime(timestamp);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((Target) this.instance).setReadTime(builder);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((Target) this.instance).mergeReadTime(timestamp);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((Target) this.instance).clearReadTime();
            return this;
        }

        public int getTargetId() {
            return ((Target) this.instance).getTargetId();
        }

        public Builder setTargetId(int i) {
            copyOnWrite();
            ((Target) this.instance).setTargetId(i);
            return this;
        }

        public Builder clearTargetId() {
            copyOnWrite();
            ((Target) this.instance).clearTargetId();
            return this;
        }

        public boolean getOnce() {
            return ((Target) this.instance).getOnce();
        }

        public Builder setOnce(boolean z) {
            copyOnWrite();
            ((Target) this.instance).setOnce(z);
            return this;
        }

        public Builder clearOnce() {
            copyOnWrite();
            ((Target) this.instance).clearOnce();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Target();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder((AnonymousClass1) null);
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Target target = (Target) obj2;
                this.targetId_ = visitor.visitInt(this.targetId_ != 0, this.targetId_, target.targetId_ != 0, target.targetId_);
                boolean z2 = this.once_;
                boolean z3 = target.once_;
                this.once_ = visitor.visitBoolean(z2, z2, z3, z3);
                int i = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$TargetTypeCase[target.getTargetTypeCase().ordinal()];
                if (i == 1) {
                    this.targetType_ = visitor.visitOneofMessage(this.targetTypeCase_ == 2, this.targetType_, target.targetType_);
                } else if (i == 2) {
                    this.targetType_ = visitor.visitOneofMessage(this.targetTypeCase_ == 3, this.targetType_, target.targetType_);
                } else if (i == 3) {
                    visitor.visitOneofNotSet(this.targetTypeCase_ != 0);
                }
                int i2 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase[target.getResumeTypeCase().ordinal()];
                if (i2 == 1) {
                    if (this.resumeTypeCase_ == 4) {
                        z = true;
                    }
                    this.resumeType_ = visitor.visitOneofByteString(z, this.resumeType_, target.resumeType_);
                } else if (i2 == 2) {
                    if (this.resumeTypeCase_ == 11) {
                        z = true;
                    }
                    this.resumeType_ = visitor.visitOneofMessage(z, this.resumeType_, target.resumeType_);
                } else if (i2 == 3) {
                    if (this.resumeTypeCase_ != 0) {
                        z = true;
                    }
                    visitor.visitOneofNotSet(z);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    int i3 = target.targetTypeCase_;
                    if (i3 != 0) {
                        this.targetTypeCase_ = i3;
                    }
                    int i4 = target.resumeTypeCase_;
                    if (i4 != 0) {
                        this.resumeTypeCase_ = i4;
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
                            if (readTag == 18) {
                                QueryTarget.Builder builder = this.targetTypeCase_ == 2 ? (QueryTarget.Builder) ((QueryTarget) this.targetType_).toBuilder() : null;
                                this.targetType_ = codedInputStream.readMessage(QueryTarget.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((QueryTarget) this.targetType_);
                                    this.targetType_ = builder.buildPartial();
                                }
                                this.targetTypeCase_ = 2;
                            } else if (readTag == 26) {
                                DocumentsTarget.Builder builder2 = this.targetTypeCase_ == 3 ? (DocumentsTarget.Builder) ((DocumentsTarget) this.targetType_).toBuilder() : null;
                                this.targetType_ = codedInputStream.readMessage(DocumentsTarget.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((DocumentsTarget) this.targetType_);
                                    this.targetType_ = builder2.buildPartial();
                                }
                                this.targetTypeCase_ = 3;
                            } else if (readTag == 34) {
                                this.resumeTypeCase_ = 4;
                                this.resumeType_ = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.targetId_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.once_ = codedInputStream.readBool();
                            } else if (readTag == 90) {
                                Timestamp.Builder builder3 = this.resumeTypeCase_ == 11 ? (Timestamp.Builder) ((Timestamp) this.resumeType_).toBuilder() : null;
                                this.resumeType_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((Timestamp) this.resumeType_);
                                    this.resumeType_ = builder3.buildPartial();
                                }
                                this.resumeTypeCase_ = 11;
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
                    synchronized (Target.class) {
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

    /* renamed from: com.google.firestore.v1.Target$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase = new int[QueryTarget.QueryTypeCase.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase = new int[ResumeTypeCase.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase = new int[TargetTypeCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0081 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c1 */
        static {
            /*
                com.google.firestore.v1.Target$ResumeTypeCase[] r0 = com.google.firestore.v1.Target.ResumeTypeCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firestore.v1.Target$ResumeTypeCase r2 = com.google.firestore.v1.Target.ResumeTypeCase.RESUME_TOKEN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firestore.v1.Target$ResumeTypeCase r3 = com.google.firestore.v1.Target.ResumeTypeCase.READ_TIME     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firestore.v1.Target$ResumeTypeCase r4 = com.google.firestore.v1.Target.ResumeTypeCase.RESUMETYPE_NOT_SET     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.google.firestore.v1.Target$TargetTypeCase[] r3 = com.google.firestore.v1.Target.TargetTypeCase.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase = r3
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase     // Catch:{ NoSuchFieldError -> 0x003d }
                com.google.firestore.v1.Target$TargetTypeCase r4 = com.google.firestore.v1.Target.TargetTypeCase.QUERY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.google.firestore.v1.Target$TargetTypeCase r4 = com.google.firestore.v1.Target.TargetTypeCase.DOCUMENTS     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$TargetTypeCase     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.google.firestore.v1.Target$TargetTypeCase r4 = com.google.firestore.v1.Target.TargetTypeCase.TARGETTYPE_NOT_SET     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                com.google.firestore.v1.Target$QueryTarget$QueryTypeCase[] r3 = com.google.firestore.v1.Target.QueryTarget.QueryTypeCase.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase = r3
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.google.firestore.v1.Target$QueryTarget$QueryTypeCase r4 = com.google.firestore.v1.Target.QueryTarget.QueryTypeCase.STRUCTURED_QUERY     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r3 = $SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.firestore.v1.Target$QueryTarget$QueryTypeCase r4 = com.google.firestore.v1.Target.QueryTarget.QueryTypeCase.QUERYTYPE_NOT_SET     // Catch:{ NoSuchFieldError -> 0x006e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r3 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r3
                int[] r3 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0081 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r4 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0081 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0081 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x008b }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r3 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x008b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x008b }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x00a0 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x00c1 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x00cd }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Target.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
