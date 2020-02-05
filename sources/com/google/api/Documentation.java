package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    /* access modifiers changed from: private */
    public static final Documentation DEFAULT_INSTANCE = new Documentation();
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private int bitField0_;
    private String documentationRootUrl_ = "";
    private String overview_ = "";
    private Internal.ProtobufList<Page> pages_ = emptyProtobufList();
    private Internal.ProtobufList<DocumentationRule> rules_ = emptyProtobufList();
    private String summary_ = "";

    private Documentation() {
    }

    public String getSummary() {
        return this.summary_;
    }

    public ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    /* access modifiers changed from: private */
    public void setSummary(String str) {
        if (str != null) {
            this.summary_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    /* access modifiers changed from: private */
    public void setSummaryBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.summary_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<Page> getPagesList() {
        return this.pages_;
    }

    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    public int getPagesCount() {
        return this.pages_.size();
    }

    public Page getPages(int i) {
        return (Page) this.pages_.get(i);
    }

    public PageOrBuilder getPagesOrBuilder(int i) {
        return (PageOrBuilder) this.pages_.get(i);
    }

    private void ensurePagesIsMutable() {
        if (!this.pages_.isModifiable()) {
            this.pages_ = GeneratedMessageLite.mutableCopy(this.pages_);
        }
    }

    /* access modifiers changed from: private */
    public void setPages(int i, Page page) {
        if (page != null) {
            ensurePagesIsMutable();
            this.pages_.set(i, page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setPages(int i, Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.set(i, (Page) builder.build());
    }

    /* access modifiers changed from: private */
    public void addPages(Page page) {
        if (page != null) {
            ensurePagesIsMutable();
            this.pages_.add(page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addPages(int i, Page page) {
        if (page != null) {
            ensurePagesIsMutable();
            this.pages_.add(i, page);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addPages(Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.add((Page) builder.build());
    }

    /* access modifiers changed from: private */
    public void addPages(int i, Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.add(i, (Page) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllPages(Iterable<? extends Page> iterable) {
        ensurePagesIsMutable();
        AbstractMessageLite.addAll(iterable, this.pages_);
    }

    /* access modifiers changed from: private */
    public void clearPages() {
        this.pages_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removePages(int i) {
        ensurePagesIsMutable();
        this.pages_.remove(i);
    }

    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    public int getRulesCount() {
        return this.rules_.size();
    }

    public DocumentationRule getRules(int i) {
        return (DocumentationRule) this.rules_.get(i);
    }

    public DocumentationRuleOrBuilder getRulesOrBuilder(int i) {
        return (DocumentationRuleOrBuilder) this.rules_.get(i);
    }

    private void ensureRulesIsMutable() {
        if (!this.rules_.isModifiable()) {
            this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
        }
    }

    /* access modifiers changed from: private */
    public void setRules(int i, DocumentationRule documentationRule) {
        if (documentationRule != null) {
            ensureRulesIsMutable();
            this.rules_.set(i, documentationRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRules(int i, DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, (DocumentationRule) builder.build());
    }

    /* access modifiers changed from: private */
    public void addRules(DocumentationRule documentationRule) {
        if (documentationRule != null) {
            ensureRulesIsMutable();
            this.rules_.add(documentationRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRules(int i, DocumentationRule documentationRule) {
        if (documentationRule != null) {
            ensureRulesIsMutable();
            this.rules_.add(i, documentationRule);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRules(DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add((DocumentationRule) builder.build());
    }

    /* access modifiers changed from: private */
    public void addRules(int i, DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, (DocumentationRule) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllRules(Iterable<? extends DocumentationRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll(iterable, this.rules_);
    }

    /* access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    public String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    public ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    /* access modifiers changed from: private */
    public void setDocumentationRootUrl(String str) {
        if (str != null) {
            this.documentationRootUrl_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearDocumentationRootUrl() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* access modifiers changed from: private */
    public void setDocumentationRootUrlBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.documentationRootUrl_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getOverview() {
        return this.overview_;
    }

    public ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    /* access modifiers changed from: private */
    public void setOverview(String str) {
        if (str != null) {
            this.overview_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearOverview() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* access modifiers changed from: private */
    public void setOverviewBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.overview_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.summary_.isEmpty()) {
            codedOutputStream.writeString(1, getSummary());
        }
        if (!this.overview_.isEmpty()) {
            codedOutputStream.writeString(2, getOverview());
        }
        for (int i = 0; i < this.rules_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.rules_.get(i));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            codedOutputStream.writeString(4, getDocumentationRootUrl());
        }
        for (int i2 = 0; i2 < this.pages_.size(); i2++) {
            codedOutputStream.writeMessage(5, (MessageLite) this.pages_.get(i2));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.summary_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSummary()) + 0 : 0;
        if (!this.overview_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getOverview());
        }
        int i2 = computeStringSize;
        for (int i3 = 0; i3 < this.rules_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.rules_.get(i3));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(4, getDocumentationRootUrl());
        }
        for (int i4 = 0; i4 < this.pages_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.pages_.get(i4));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Documentation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Documentation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Documentation parseFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Documentation documentation) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(documentation);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        public String getSummary() {
            return ((Documentation) this.instance).getSummary();
        }

        public ByteString getSummaryBytes() {
            return ((Documentation) this.instance).getSummaryBytes();
        }

        public Builder setSummary(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setSummary(str);
            return this;
        }

        public Builder clearSummary() {
            copyOnWrite();
            ((Documentation) this.instance).clearSummary();
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setSummaryBytes(byteString);
            return this;
        }

        public List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getPagesList());
        }

        public int getPagesCount() {
            return ((Documentation) this.instance).getPagesCount();
        }

        public Page getPages(int i) {
            return ((Documentation) this.instance).getPages(i);
        }

        public Builder setPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, page);
            return this;
        }

        public Builder setPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, builder);
            return this;
        }

        public Builder addPages(Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(page);
            return this;
        }

        public Builder addPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, page);
            return this;
        }

        public Builder addPages(Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(builder);
            return this;
        }

        public Builder addPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, builder);
            return this;
        }

        public Builder addAllPages(Iterable<? extends Page> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllPages(iterable);
            return this;
        }

        public Builder clearPages() {
            copyOnWrite();
            ((Documentation) this.instance).clearPages();
            return this;
        }

        public Builder removePages(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removePages(i);
            return this;
        }

        public List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getRulesList());
        }

        public int getRulesCount() {
            return ((Documentation) this.instance).getRulesCount();
        }

        public DocumentationRule getRules(int i) {
            return ((Documentation) this.instance).getRules(i);
        }

        public Builder setRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, documentationRule);
            return this;
        }

        public Builder setRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, builder);
            return this;
        }

        public Builder addRules(DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(documentationRule);
            return this;
        }

        public Builder addRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, documentationRule);
            return this;
        }

        public Builder addRules(DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(builder);
            return this;
        }

        public Builder addRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, builder);
            return this;
        }

        public Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllRules(iterable);
            return this;
        }

        public Builder clearRules() {
            copyOnWrite();
            ((Documentation) this.instance).clearRules();
            return this;
        }

        public Builder removeRules(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removeRules(i);
            return this;
        }

        public String getDocumentationRootUrl() {
            return ((Documentation) this.instance).getDocumentationRootUrl();
        }

        public ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.instance).getDocumentationRootUrlBytes();
        }

        public Builder setDocumentationRootUrl(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrl(str);
            return this;
        }

        public Builder clearDocumentationRootUrl() {
            copyOnWrite();
            ((Documentation) this.instance).clearDocumentationRootUrl();
            return this;
        }

        public Builder setDocumentationRootUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrlBytes(byteString);
            return this;
        }

        public String getOverview() {
            return ((Documentation) this.instance).getOverview();
        }

        public ByteString getOverviewBytes() {
            return ((Documentation) this.instance).getOverviewBytes();
        }

        public Builder setOverview(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setOverview(str);
            return this;
        }

        public Builder clearOverview() {
            copyOnWrite();
            ((Documentation) this.instance).clearOverview();
            return this;
        }

        public Builder setOverviewBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setOverviewBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Documentation();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.pages_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Documentation documentation = (Documentation) obj2;
                this.summary_ = visitor.visitString(!this.summary_.isEmpty(), this.summary_, !documentation.summary_.isEmpty(), documentation.summary_);
                this.pages_ = visitor.visitList(this.pages_, documentation.pages_);
                this.rules_ = visitor.visitList(this.rules_, documentation.rules_);
                this.documentationRootUrl_ = visitor.visitString(!this.documentationRootUrl_.isEmpty(), this.documentationRootUrl_, !documentation.documentationRootUrl_.isEmpty(), documentation.documentationRootUrl_);
                this.overview_ = visitor.visitString(!this.overview_.isEmpty(), this.overview_, true ^ documentation.overview_.isEmpty(), documentation.overview_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentation.bitField0_;
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
                                this.summary_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.overview_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.rules_.isModifiable()) {
                                    this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_);
                                }
                                this.rules_.add((DocumentationRule) codedInputStream.readMessage(DocumentationRule.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                this.documentationRootUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                if (!this.pages_.isModifiable()) {
                                    this.pages_ = GeneratedMessageLite.mutableCopy(this.pages_);
                                }
                                this.pages_.add((Page) codedInputStream.readMessage(Page.parser(), extensionRegistryLite));
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
                    synchronized (Documentation.class) {
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

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
