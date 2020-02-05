package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class HttpRequest extends GeneratedMessageLite<HttpRequest, Builder> implements HttpRequestOrBuilder {
    public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
    public static final int CACHE_HIT_FIELD_NUMBER = 9;
    public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
    public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
    /* access modifiers changed from: private */
    public static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
    public static final int LATENCY_FIELD_NUMBER = 14;
    private static volatile Parser<HttpRequest> PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 15;
    public static final int REFERER_FIELD_NUMBER = 8;
    public static final int REMOTE_IP_FIELD_NUMBER = 7;
    public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
    public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
    public static final int REQUEST_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
    public static final int SERVER_IP_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int USER_AGENT_FIELD_NUMBER = 6;
    private long cacheFillBytes_;
    private boolean cacheHit_;
    private boolean cacheLookup_;
    private boolean cacheValidatedWithOriginServer_;
    private Duration latency_;
    private String protocol_ = "";
    private String referer_ = "";
    private String remoteIp_ = "";
    private String requestMethod_ = "";
    private long requestSize_;
    private String requestUrl_ = "";
    private long responseSize_;
    private String serverIp_ = "";
    private int status_;
    private String userAgent_ = "";

    private HttpRequest() {
    }

    public String getRequestMethod() {
        return this.requestMethod_;
    }

    public ByteString getRequestMethodBytes() {
        return ByteString.copyFromUtf8(this.requestMethod_);
    }

    /* access modifiers changed from: private */
    public void setRequestMethod(String str) {
        if (str != null) {
            this.requestMethod_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearRequestMethod() {
        this.requestMethod_ = getDefaultInstance().getRequestMethod();
    }

    /* access modifiers changed from: private */
    public void setRequestMethodBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.requestMethod_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getRequestUrl() {
        return this.requestUrl_;
    }

    public ByteString getRequestUrlBytes() {
        return ByteString.copyFromUtf8(this.requestUrl_);
    }

    /* access modifiers changed from: private */
    public void setRequestUrl(String str) {
        if (str != null) {
            this.requestUrl_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearRequestUrl() {
        this.requestUrl_ = getDefaultInstance().getRequestUrl();
    }

    /* access modifiers changed from: private */
    public void setRequestUrlBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.requestUrl_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public long getRequestSize() {
        return this.requestSize_;
    }

    /* access modifiers changed from: private */
    public void setRequestSize(long j) {
        this.requestSize_ = j;
    }

    /* access modifiers changed from: private */
    public void clearRequestSize() {
        this.requestSize_ = 0;
    }

    public int getStatus() {
        return this.status_;
    }

    /* access modifiers changed from: private */
    public void setStatus(int i) {
        this.status_ = i;
    }

    /* access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    public long getResponseSize() {
        return this.responseSize_;
    }

    /* access modifiers changed from: private */
    public void setResponseSize(long j) {
        this.responseSize_ = j;
    }

    /* access modifiers changed from: private */
    public void clearResponseSize() {
        this.responseSize_ = 0;
    }

    public String getUserAgent() {
        return this.userAgent_;
    }

    public ByteString getUserAgentBytes() {
        return ByteString.copyFromUtf8(this.userAgent_);
    }

    /* access modifiers changed from: private */
    public void setUserAgent(String str) {
        if (str != null) {
            this.userAgent_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearUserAgent() {
        this.userAgent_ = getDefaultInstance().getUserAgent();
    }

    /* access modifiers changed from: private */
    public void setUserAgentBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.userAgent_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getRemoteIp() {
        return this.remoteIp_;
    }

    public ByteString getRemoteIpBytes() {
        return ByteString.copyFromUtf8(this.remoteIp_);
    }

    /* access modifiers changed from: private */
    public void setRemoteIp(String str) {
        if (str != null) {
            this.remoteIp_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearRemoteIp() {
        this.remoteIp_ = getDefaultInstance().getRemoteIp();
    }

    /* access modifiers changed from: private */
    public void setRemoteIpBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.remoteIp_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getServerIp() {
        return this.serverIp_;
    }

    public ByteString getServerIpBytes() {
        return ByteString.copyFromUtf8(this.serverIp_);
    }

    /* access modifiers changed from: private */
    public void setServerIp(String str) {
        if (str != null) {
            this.serverIp_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearServerIp() {
        this.serverIp_ = getDefaultInstance().getServerIp();
    }

    /* access modifiers changed from: private */
    public void setServerIpBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.serverIp_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getReferer() {
        return this.referer_;
    }

    public ByteString getRefererBytes() {
        return ByteString.copyFromUtf8(this.referer_);
    }

    /* access modifiers changed from: private */
    public void setReferer(String str) {
        if (str != null) {
            this.referer_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearReferer() {
        this.referer_ = getDefaultInstance().getReferer();
    }

    /* access modifiers changed from: private */
    public void setRefererBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.referer_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean hasLatency() {
        return this.latency_ != null;
    }

    public Duration getLatency() {
        Duration duration = this.latency_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    /* access modifiers changed from: private */
    public void setLatency(Duration duration) {
        if (duration != null) {
            this.latency_ = duration;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setLatency(Duration.Builder builder) {
        this.latency_ = (Duration) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeLatency(Duration duration) {
        Duration duration2 = this.latency_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.latency_ = duration;
        } else {
            this.latency_ = (Duration) ((Duration.Builder) Duration.newBuilder(this.latency_).mergeFrom(duration)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLatency() {
        this.latency_ = null;
    }

    public boolean getCacheLookup() {
        return this.cacheLookup_;
    }

    /* access modifiers changed from: private */
    public void setCacheLookup(boolean z) {
        this.cacheLookup_ = z;
    }

    /* access modifiers changed from: private */
    public void clearCacheLookup() {
        this.cacheLookup_ = false;
    }

    public boolean getCacheHit() {
        return this.cacheHit_;
    }

    /* access modifiers changed from: private */
    public void setCacheHit(boolean z) {
        this.cacheHit_ = z;
    }

    /* access modifiers changed from: private */
    public void clearCacheHit() {
        this.cacheHit_ = false;
    }

    public boolean getCacheValidatedWithOriginServer() {
        return this.cacheValidatedWithOriginServer_;
    }

    /* access modifiers changed from: private */
    public void setCacheValidatedWithOriginServer(boolean z) {
        this.cacheValidatedWithOriginServer_ = z;
    }

    /* access modifiers changed from: private */
    public void clearCacheValidatedWithOriginServer() {
        this.cacheValidatedWithOriginServer_ = false;
    }

    public long getCacheFillBytes() {
        return this.cacheFillBytes_;
    }

    /* access modifiers changed from: private */
    public void setCacheFillBytes(long j) {
        this.cacheFillBytes_ = j;
    }

    /* access modifiers changed from: private */
    public void clearCacheFillBytes() {
        this.cacheFillBytes_ = 0;
    }

    public String getProtocol() {
        return this.protocol_;
    }

    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    /* access modifiers changed from: private */
    public void setProtocol(String str) {
        if (str != null) {
            this.protocol_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* access modifiers changed from: private */
    public void setProtocolBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.protocol_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.requestMethod_.isEmpty()) {
            codedOutputStream.writeString(1, getRequestMethod());
        }
        if (!this.requestUrl_.isEmpty()) {
            codedOutputStream.writeString(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            codedOutputStream.writeInt64(3, j);
        }
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeInt32(4, i);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            codedOutputStream.writeString(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            codedOutputStream.writeString(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            codedOutputStream.writeString(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            codedOutputStream.writeBool(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            codedOutputStream.writeBool(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            codedOutputStream.writeBool(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            codedOutputStream.writeInt64(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            codedOutputStream.writeString(13, getServerIp());
        }
        if (this.latency_ != null) {
            codedOutputStream.writeMessage(14, getLatency());
        }
        if (!this.protocol_.isEmpty()) {
            codedOutputStream.writeString(15, getProtocol());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.requestMethod_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getRequestMethod());
        }
        if (!this.requestUrl_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(2, getRequestUrl());
        }
        long j = this.requestSize_;
        if (j != 0) {
            i2 += CodedOutputStream.computeInt64Size(3, j);
        }
        int i3 = this.status_;
        if (i3 != 0) {
            i2 += CodedOutputStream.computeInt32Size(4, i3);
        }
        long j2 = this.responseSize_;
        if (j2 != 0) {
            i2 += CodedOutputStream.computeInt64Size(5, j2);
        }
        if (!this.userAgent_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(6, getUserAgent());
        }
        if (!this.remoteIp_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(7, getRemoteIp());
        }
        if (!this.referer_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(8, getReferer());
        }
        boolean z = this.cacheHit_;
        if (z) {
            i2 += CodedOutputStream.computeBoolSize(9, z);
        }
        boolean z2 = this.cacheValidatedWithOriginServer_;
        if (z2) {
            i2 += CodedOutputStream.computeBoolSize(10, z2);
        }
        boolean z3 = this.cacheLookup_;
        if (z3) {
            i2 += CodedOutputStream.computeBoolSize(11, z3);
        }
        long j3 = this.cacheFillBytes_;
        if (j3 != 0) {
            i2 += CodedOutputStream.computeInt64Size(12, j3);
        }
        if (!this.serverIp_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(13, getServerIp());
        }
        if (this.latency_ != null) {
            i2 += CodedOutputStream.computeMessageSize(14, getLatency());
        }
        if (!this.protocol_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(15, getProtocol());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static HttpRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRequest httpRequest) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(httpRequest);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
        private Builder() {
            super(HttpRequest.DEFAULT_INSTANCE);
        }

        public String getRequestMethod() {
            return ((HttpRequest) this.instance).getRequestMethod();
        }

        public ByteString getRequestMethodBytes() {
            return ((HttpRequest) this.instance).getRequestMethodBytes();
        }

        public Builder setRequestMethod(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestMethod(str);
            return this;
        }

        public Builder clearRequestMethod() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestMethod();
            return this;
        }

        public Builder setRequestMethodBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestMethodBytes(byteString);
            return this;
        }

        public String getRequestUrl() {
            return ((HttpRequest) this.instance).getRequestUrl();
        }

        public ByteString getRequestUrlBytes() {
            return ((HttpRequest) this.instance).getRequestUrlBytes();
        }

        public Builder setRequestUrl(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestUrl(str);
            return this;
        }

        public Builder clearRequestUrl() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestUrl();
            return this;
        }

        public Builder setRequestUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestUrlBytes(byteString);
            return this;
        }

        public long getRequestSize() {
            return ((HttpRequest) this.instance).getRequestSize();
        }

        public Builder setRequestSize(long j) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRequestSize(j);
            return this;
        }

        public Builder clearRequestSize() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRequestSize();
            return this;
        }

        public int getStatus() {
            return ((HttpRequest) this.instance).getStatus();
        }

        public Builder setStatus(int i) {
            copyOnWrite();
            ((HttpRequest) this.instance).setStatus(i);
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearStatus();
            return this;
        }

        public long getResponseSize() {
            return ((HttpRequest) this.instance).getResponseSize();
        }

        public Builder setResponseSize(long j) {
            copyOnWrite();
            ((HttpRequest) this.instance).setResponseSize(j);
            return this;
        }

        public Builder clearResponseSize() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearResponseSize();
            return this;
        }

        public String getUserAgent() {
            return ((HttpRequest) this.instance).getUserAgent();
        }

        public ByteString getUserAgentBytes() {
            return ((HttpRequest) this.instance).getUserAgentBytes();
        }

        public Builder setUserAgent(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setUserAgent(str);
            return this;
        }

        public Builder clearUserAgent() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearUserAgent();
            return this;
        }

        public Builder setUserAgentBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setUserAgentBytes(byteString);
            return this;
        }

        public String getRemoteIp() {
            return ((HttpRequest) this.instance).getRemoteIp();
        }

        public ByteString getRemoteIpBytes() {
            return ((HttpRequest) this.instance).getRemoteIpBytes();
        }

        public Builder setRemoteIp(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRemoteIp(str);
            return this;
        }

        public Builder clearRemoteIp() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearRemoteIp();
            return this;
        }

        public Builder setRemoteIpBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRemoteIpBytes(byteString);
            return this;
        }

        public String getServerIp() {
            return ((HttpRequest) this.instance).getServerIp();
        }

        public ByteString getServerIpBytes() {
            return ((HttpRequest) this.instance).getServerIpBytes();
        }

        public Builder setServerIp(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setServerIp(str);
            return this;
        }

        public Builder clearServerIp() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearServerIp();
            return this;
        }

        public Builder setServerIpBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setServerIpBytes(byteString);
            return this;
        }

        public String getReferer() {
            return ((HttpRequest) this.instance).getReferer();
        }

        public ByteString getRefererBytes() {
            return ((HttpRequest) this.instance).getRefererBytes();
        }

        public Builder setReferer(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setReferer(str);
            return this;
        }

        public Builder clearReferer() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearReferer();
            return this;
        }

        public Builder setRefererBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setRefererBytes(byteString);
            return this;
        }

        public boolean hasLatency() {
            return ((HttpRequest) this.instance).hasLatency();
        }

        public Duration getLatency() {
            return ((HttpRequest) this.instance).getLatency();
        }

        public Builder setLatency(Duration duration) {
            copyOnWrite();
            ((HttpRequest) this.instance).setLatency(duration);
            return this;
        }

        public Builder setLatency(Duration.Builder builder) {
            copyOnWrite();
            ((HttpRequest) this.instance).setLatency(builder);
            return this;
        }

        public Builder mergeLatency(Duration duration) {
            copyOnWrite();
            ((HttpRequest) this.instance).mergeLatency(duration);
            return this;
        }

        public Builder clearLatency() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearLatency();
            return this;
        }

        public boolean getCacheLookup() {
            return ((HttpRequest) this.instance).getCacheLookup();
        }

        public Builder setCacheLookup(boolean z) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheLookup(z);
            return this;
        }

        public Builder clearCacheLookup() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheLookup();
            return this;
        }

        public boolean getCacheHit() {
            return ((HttpRequest) this.instance).getCacheHit();
        }

        public Builder setCacheHit(boolean z) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheHit(z);
            return this;
        }

        public Builder clearCacheHit() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheHit();
            return this;
        }

        public boolean getCacheValidatedWithOriginServer() {
            return ((HttpRequest) this.instance).getCacheValidatedWithOriginServer();
        }

        public Builder setCacheValidatedWithOriginServer(boolean z) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheValidatedWithOriginServer(z);
            return this;
        }

        public Builder clearCacheValidatedWithOriginServer() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheValidatedWithOriginServer();
            return this;
        }

        public long getCacheFillBytes() {
            return ((HttpRequest) this.instance).getCacheFillBytes();
        }

        public Builder setCacheFillBytes(long j) {
            copyOnWrite();
            ((HttpRequest) this.instance).setCacheFillBytes(j);
            return this;
        }

        public Builder clearCacheFillBytes() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearCacheFillBytes();
            return this;
        }

        public String getProtocol() {
            return ((HttpRequest) this.instance).getProtocol();
        }

        public ByteString getProtocolBytes() {
            return ((HttpRequest) this.instance).getProtocolBytes();
        }

        public Builder setProtocol(String str) {
            copyOnWrite();
            ((HttpRequest) this.instance).setProtocol(str);
            return this;
        }

        public Builder clearProtocol() {
            copyOnWrite();
            ((HttpRequest) this.instance).clearProtocol();
            return this;
        }

        public Builder setProtocolBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpRequest) this.instance).setProtocolBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new HttpRequest();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                HttpRequest httpRequest = (HttpRequest) obj2;
                this.requestMethod_ = visitor.visitString(!this.requestMethod_.isEmpty(), this.requestMethod_, !httpRequest.requestMethod_.isEmpty(), httpRequest.requestMethod_);
                this.requestUrl_ = visitor.visitString(!this.requestUrl_.isEmpty(), this.requestUrl_, !httpRequest.requestUrl_.isEmpty(), httpRequest.requestUrl_);
                this.requestSize_ = visitor.visitLong(this.requestSize_ != 0, this.requestSize_, httpRequest.requestSize_ != 0, httpRequest.requestSize_);
                this.status_ = visitor.visitInt(this.status_ != 0, this.status_, httpRequest.status_ != 0, httpRequest.status_);
                this.responseSize_ = visitor.visitLong(this.responseSize_ != 0, this.responseSize_, httpRequest.responseSize_ != 0, httpRequest.responseSize_);
                this.userAgent_ = visitor.visitString(!this.userAgent_.isEmpty(), this.userAgent_, !httpRequest.userAgent_.isEmpty(), httpRequest.userAgent_);
                this.remoteIp_ = visitor.visitString(!this.remoteIp_.isEmpty(), this.remoteIp_, !httpRequest.remoteIp_.isEmpty(), httpRequest.remoteIp_);
                this.serverIp_ = visitor.visitString(!this.serverIp_.isEmpty(), this.serverIp_, !httpRequest.serverIp_.isEmpty(), httpRequest.serverIp_);
                this.referer_ = visitor.visitString(!this.referer_.isEmpty(), this.referer_, !httpRequest.referer_.isEmpty(), httpRequest.referer_);
                this.latency_ = (Duration) visitor.visitMessage(this.latency_, httpRequest.latency_);
                boolean z2 = this.cacheLookup_;
                boolean z3 = httpRequest.cacheLookup_;
                this.cacheLookup_ = visitor.visitBoolean(z2, z2, z3, z3);
                boolean z4 = this.cacheHit_;
                boolean z5 = httpRequest.cacheHit_;
                this.cacheHit_ = visitor.visitBoolean(z4, z4, z5, z5);
                boolean z6 = this.cacheValidatedWithOriginServer_;
                boolean z7 = httpRequest.cacheValidatedWithOriginServer_;
                this.cacheValidatedWithOriginServer_ = visitor.visitBoolean(z6, z6, z7, z7);
                this.cacheFillBytes_ = visitor.visitLong(this.cacheFillBytes_ != 0, this.cacheFillBytes_, httpRequest.cacheFillBytes_ != 0, httpRequest.cacheFillBytes_);
                this.protocol_ = visitor.visitString(!this.protocol_.isEmpty(), this.protocol_, !httpRequest.protocol_.isEmpty(), httpRequest.protocol_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                            case 10:
                                this.requestMethod_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 18:
                                this.requestUrl_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 24:
                                this.requestSize_ = codedInputStream.readInt64();
                                break;
                            case 32:
                                this.status_ = codedInputStream.readInt32();
                                break;
                            case 40:
                                this.responseSize_ = codedInputStream.readInt64();
                                break;
                            case 50:
                                this.userAgent_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 58:
                                this.remoteIp_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 66:
                                this.referer_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 72:
                                this.cacheHit_ = codedInputStream.readBool();
                                break;
                            case 80:
                                this.cacheValidatedWithOriginServer_ = codedInputStream.readBool();
                                break;
                            case 88:
                                this.cacheLookup_ = codedInputStream.readBool();
                                break;
                            case 96:
                                this.cacheFillBytes_ = codedInputStream.readInt64();
                                break;
                            case 106:
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                                break;
                            case 114:
                                Duration.Builder builder = this.latency_ != null ? (Duration.Builder) this.latency_.toBuilder() : null;
                                this.latency_ = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                if (builder == null) {
                                    break;
                                } else {
                                    builder.mergeFrom(this.latency_);
                                    this.latency_ = (Duration) builder.buildPartial();
                                    break;
                                }
                            case 122:
                                this.protocol_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (HttpRequest.class) {
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

    public static HttpRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
