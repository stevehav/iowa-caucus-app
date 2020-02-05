package com.google.type;

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

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    /* access modifiers changed from: private */
    public static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
    private String administrativeArea_ = "";
    private int bitField0_;
    private String languageCode_ = "";
    private String locality_ = "";
    private String organization_ = "";
    private String postalCode_ = "";
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
    private String regionCode_ = "";
    private int revision_;
    private String sortingCode_ = "";
    private String sublocality_ = "";

    private PostalAddress() {
    }

    public int getRevision() {
        return this.revision_;
    }

    /* access modifiers changed from: private */
    public void setRevision(int i) {
        this.revision_ = i;
    }

    /* access modifiers changed from: private */
    public void clearRevision() {
        this.revision_ = 0;
    }

    public String getRegionCode() {
        return this.regionCode_;
    }

    public ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    /* access modifiers changed from: private */
    public void setRegionCode(String str) {
        if (str != null) {
            this.regionCode_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearRegionCode() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* access modifiers changed from: private */
    public void setRegionCodeBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.regionCode_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getLanguageCode() {
        return this.languageCode_;
    }

    public ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    /* access modifiers changed from: private */
    public void setLanguageCode(String str) {
        if (str != null) {
            this.languageCode_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearLanguageCode() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* access modifiers changed from: private */
    public void setLanguageCodeBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.languageCode_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    /* access modifiers changed from: private */
    public void setPostalCode(String str) {
        if (str != null) {
            this.postalCode_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* access modifiers changed from: private */
    public void setPostalCodeBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.postalCode_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getSortingCode() {
        return this.sortingCode_;
    }

    public ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    /* access modifiers changed from: private */
    public void setSortingCode(String str) {
        if (str != null) {
            this.sortingCode_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearSortingCode() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* access modifiers changed from: private */
    public void setSortingCodeBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.sortingCode_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    public ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    /* access modifiers changed from: private */
    public void setAdministrativeArea(String str) {
        if (str != null) {
            this.administrativeArea_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearAdministrativeArea() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* access modifiers changed from: private */
    public void setAdministrativeAreaBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.administrativeArea_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getLocality() {
        return this.locality_;
    }

    public ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    /* access modifiers changed from: private */
    public void setLocality(String str) {
        if (str != null) {
            this.locality_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearLocality() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* access modifiers changed from: private */
    public void setLocalityBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.locality_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getSublocality() {
        return this.sublocality_;
    }

    public ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    /* access modifiers changed from: private */
    public void setSublocality(String str) {
        if (str != null) {
            this.sublocality_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearSublocality() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    /* access modifiers changed from: private */
    public void setSublocalityBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.sublocality_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    public String getAddressLines(int i) {
        return (String) this.addressLines_.get(i);
    }

    public ByteString getAddressLinesBytes(int i) {
        return ByteString.copyFromUtf8((String) this.addressLines_.get(i));
    }

    private void ensureAddressLinesIsMutable() {
        if (!this.addressLines_.isModifiable()) {
            this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_);
        }
    }

    /* access modifiers changed from: private */
    public void setAddressLines(int i, String str) {
        if (str != null) {
            ensureAddressLinesIsMutable();
            this.addressLines_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAddressLines(String str) {
        if (str != null) {
            ensureAddressLinesIsMutable();
            this.addressLines_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllAddressLines(Iterable<String> iterable) {
        ensureAddressLinesIsMutable();
        AbstractMessageLite.addAll(iterable, this.addressLines_);
    }

    /* access modifiers changed from: private */
    public void clearAddressLines() {
        this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addAddressLinesBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureAddressLinesIsMutable();
            this.addressLines_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public List<String> getRecipientsList() {
        return this.recipients_;
    }

    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    public String getRecipients(int i) {
        return (String) this.recipients_.get(i);
    }

    public ByteString getRecipientsBytes(int i) {
        return ByteString.copyFromUtf8((String) this.recipients_.get(i));
    }

    private void ensureRecipientsIsMutable() {
        if (!this.recipients_.isModifiable()) {
            this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_);
        }
    }

    /* access modifiers changed from: private */
    public void setRecipients(int i, String str) {
        if (str != null) {
            ensureRecipientsIsMutable();
            this.recipients_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addRecipients(String str) {
        if (str != null) {
            ensureRecipientsIsMutable();
            this.recipients_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllRecipients(Iterable<String> iterable) {
        ensureRecipientsIsMutable();
        AbstractMessageLite.addAll(iterable, this.recipients_);
    }

    /* access modifiers changed from: private */
    public void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addRecipientsBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureRecipientsIsMutable();
            this.recipients_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public String getOrganization() {
        return this.organization_;
    }

    public ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    /* access modifiers changed from: private */
    public void setOrganization(String str) {
        if (str != null) {
            this.organization_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearOrganization() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* access modifiers changed from: private */
    public void setOrganizationBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.organization_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.revision_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!this.regionCode_.isEmpty()) {
            codedOutputStream.writeString(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            codedOutputStream.writeString(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            codedOutputStream.writeString(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            codedOutputStream.writeString(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            codedOutputStream.writeString(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            codedOutputStream.writeString(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            codedOutputStream.writeString(8, getSublocality());
        }
        for (int i2 = 0; i2 < this.addressLines_.size(); i2++) {
            codedOutputStream.writeString(9, (String) this.addressLines_.get(i2));
        }
        for (int i3 = 0; i3 < this.recipients_.size(); i3++) {
            codedOutputStream.writeString(10, (String) this.recipients_.get(i3));
        }
        if (!this.organization_.isEmpty()) {
            codedOutputStream.writeString(11, getOrganization());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.revision_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        if (!this.regionCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(8, getSublocality());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.addressLines_.size(); i4++) {
            i3 += CodedOutputStream.computeStringSizeNoTag((String) this.addressLines_.get(i4));
        }
        int size = computeInt32Size + i3 + (getAddressLinesList().size() * 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.recipients_.size(); i6++) {
            i5 += CodedOutputStream.computeStringSizeNoTag((String) this.recipients_.get(i6));
        }
        int size2 = size + i5 + (getRecipientsList().size() * 1);
        if (!this.organization_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(11, getOrganization());
        }
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(postalAddress);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }

        public int getRevision() {
            return ((PostalAddress) this.instance).getRevision();
        }

        public Builder setRevision(int i) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRevision(i);
            return this;
        }

        public Builder clearRevision() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRevision();
            return this;
        }

        public String getRegionCode() {
            return ((PostalAddress) this.instance).getRegionCode();
        }

        public ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.instance).getRegionCodeBytes();
        }

        public Builder setRegionCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCode(str);
            return this;
        }

        public Builder clearRegionCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRegionCode();
            return this;
        }

        public Builder setRegionCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCodeBytes(byteString);
            return this;
        }

        public String getLanguageCode() {
            return ((PostalAddress) this.instance).getLanguageCode();
        }

        public ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.instance).getLanguageCodeBytes();
        }

        public Builder setLanguageCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCode(str);
            return this;
        }

        public Builder clearLanguageCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLanguageCode();
            return this;
        }

        public Builder setLanguageCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCodeBytes(byteString);
            return this;
        }

        public String getPostalCode() {
            return ((PostalAddress) this.instance).getPostalCode();
        }

        public ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.instance).getPostalCodeBytes();
        }

        public Builder setPostalCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCode(str);
            return this;
        }

        public Builder clearPostalCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearPostalCode();
            return this;
        }

        public Builder setPostalCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCodeBytes(byteString);
            return this;
        }

        public String getSortingCode() {
            return ((PostalAddress) this.instance).getSortingCode();
        }

        public ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.instance).getSortingCodeBytes();
        }

        public Builder setSortingCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCode(str);
            return this;
        }

        public Builder clearSortingCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSortingCode();
            return this;
        }

        public Builder setSortingCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCodeBytes(byteString);
            return this;
        }

        public String getAdministrativeArea() {
            return ((PostalAddress) this.instance).getAdministrativeArea();
        }

        public ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.instance).getAdministrativeAreaBytes();
        }

        public Builder setAdministrativeArea(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeArea(str);
            return this;
        }

        public Builder clearAdministrativeArea() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAdministrativeArea();
            return this;
        }

        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeAreaBytes(byteString);
            return this;
        }

        public String getLocality() {
            return ((PostalAddress) this.instance).getLocality();
        }

        public ByteString getLocalityBytes() {
            return ((PostalAddress) this.instance).getLocalityBytes();
        }

        public Builder setLocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocality(str);
            return this;
        }

        public Builder clearLocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLocality();
            return this;
        }

        public Builder setLocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocalityBytes(byteString);
            return this;
        }

        public String getSublocality() {
            return ((PostalAddress) this.instance).getSublocality();
        }

        public ByteString getSublocalityBytes() {
            return ((PostalAddress) this.instance).getSublocalityBytes();
        }

        public Builder setSublocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocality(str);
            return this;
        }

        public Builder clearSublocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSublocality();
            return this;
        }

        public Builder setSublocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocalityBytes(byteString);
            return this;
        }

        public List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getAddressLinesList());
        }

        public int getAddressLinesCount() {
            return ((PostalAddress) this.instance).getAddressLinesCount();
        }

        public String getAddressLines(int i) {
            return ((PostalAddress) this.instance).getAddressLines(i);
        }

        public ByteString getAddressLinesBytes(int i) {
            return ((PostalAddress) this.instance).getAddressLinesBytes(i);
        }

        public Builder setAddressLines(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAddressLines(i, str);
            return this;
        }

        public Builder addAddressLines(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLines(str);
            return this;
        }

        public Builder addAllAddressLines(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllAddressLines(iterable);
            return this;
        }

        public Builder clearAddressLines() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAddressLines();
            return this;
        }

        public Builder addAddressLinesBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLinesBytes(byteString);
            return this;
        }

        public List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getRecipientsList());
        }

        public int getRecipientsCount() {
            return ((PostalAddress) this.instance).getRecipientsCount();
        }

        public String getRecipients(int i) {
            return ((PostalAddress) this.instance).getRecipients(i);
        }

        public ByteString getRecipientsBytes(int i) {
            return ((PostalAddress) this.instance).getRecipientsBytes(i);
        }

        public Builder setRecipients(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRecipients(i, str);
            return this;
        }

        public Builder addRecipients(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipients(str);
            return this;
        }

        public Builder addAllRecipients(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllRecipients(iterable);
            return this;
        }

        public Builder clearRecipients() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRecipients();
            return this;
        }

        public Builder addRecipientsBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipientsBytes(byteString);
            return this;
        }

        public String getOrganization() {
            return ((PostalAddress) this.instance).getOrganization();
        }

        public ByteString getOrganizationBytes() {
            return ((PostalAddress) this.instance).getOrganizationBytes();
        }

        public Builder setOrganization(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganization(str);
            return this;
        }

        public Builder clearOrganization() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearOrganization();
            return this;
        }

        public Builder setOrganizationBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganizationBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new PostalAddress();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.addressLines_.makeImmutable();
                this.recipients_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                PostalAddress postalAddress = (PostalAddress) obj2;
                boolean z2 = this.revision_ != 0;
                int i = this.revision_;
                if (postalAddress.revision_ != 0) {
                    z = true;
                }
                this.revision_ = visitor.visitInt(z2, i, z, postalAddress.revision_);
                this.regionCode_ = visitor.visitString(!this.regionCode_.isEmpty(), this.regionCode_, !postalAddress.regionCode_.isEmpty(), postalAddress.regionCode_);
                this.languageCode_ = visitor.visitString(!this.languageCode_.isEmpty(), this.languageCode_, !postalAddress.languageCode_.isEmpty(), postalAddress.languageCode_);
                this.postalCode_ = visitor.visitString(!this.postalCode_.isEmpty(), this.postalCode_, !postalAddress.postalCode_.isEmpty(), postalAddress.postalCode_);
                this.sortingCode_ = visitor.visitString(!this.sortingCode_.isEmpty(), this.sortingCode_, !postalAddress.sortingCode_.isEmpty(), postalAddress.sortingCode_);
                this.administrativeArea_ = visitor.visitString(!this.administrativeArea_.isEmpty(), this.administrativeArea_, !postalAddress.administrativeArea_.isEmpty(), postalAddress.administrativeArea_);
                this.locality_ = visitor.visitString(!this.locality_.isEmpty(), this.locality_, !postalAddress.locality_.isEmpty(), postalAddress.locality_);
                this.sublocality_ = visitor.visitString(!this.sublocality_.isEmpty(), this.sublocality_, !postalAddress.sublocality_.isEmpty(), postalAddress.sublocality_);
                this.addressLines_ = visitor.visitList(this.addressLines_, postalAddress.addressLines_);
                this.recipients_ = visitor.visitList(this.recipients_, postalAddress.recipients_);
                this.organization_ = visitor.visitString(!this.organization_.isEmpty(), this.organization_, !postalAddress.organization_.isEmpty(), postalAddress.organization_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= postalAddress.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.revision_ = codedInputStream.readInt32();
                                break;
                            case 18:
                                this.regionCode_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 26:
                                this.languageCode_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 34:
                                this.postalCode_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 42:
                                this.sortingCode_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 50:
                                this.administrativeArea_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 58:
                                this.locality_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 66:
                                this.sublocality_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 74:
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!this.addressLines_.isModifiable()) {
                                    this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_);
                                }
                                this.addressLines_.add(readStringRequireUtf8);
                                break;
                            case 82:
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                if (!this.recipients_.isModifiable()) {
                                    this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_);
                                }
                                this.recipients_.add(readStringRequireUtf82);
                                break;
                            case 90:
                                this.organization_ = codedInputStream.readStringRequireUtf8();
                                break;
                            default:
                                if (codedInputStream.skipField(readTag)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
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
                    synchronized (PostalAddress.class) {
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

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
