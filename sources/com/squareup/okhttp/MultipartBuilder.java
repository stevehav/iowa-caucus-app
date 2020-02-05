package com.squareup.okhttp;

import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBuilder {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    /* access modifiers changed from: private */
    public static final byte[] COLONSPACE = {58, 32};
    /* access modifiers changed from: private */
    public static final byte[] CRLF = {Ascii.CR, 10};
    /* access modifiers changed from: private */
    public static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    private MediaType type;

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = ByteString.encodeUtf8(str);
    }

    public MultipartBuilder type(MediaType mediaType) {
        if (mediaType == null) {
            throw new NullPointerException("type == null");
        } else if (mediaType.type().equals("multipart")) {
            this.type = mediaType;
            return this;
        } else {
            throw new IllegalArgumentException("multipart != " + mediaType);
        }
    }

    public MultipartBuilder addPart(RequestBody requestBody) {
        return addPart((Headers) null, requestBody);
    }

    public MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody == null) {
            throw new NullPointerException("body == null");
        } else if (headers != null && headers.get(HttpHeaders.CONTENT_TYPE) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        } else if (headers == null || headers.get(HttpHeaders.CONTENT_LENGTH) == null) {
            this.partHeaders.add(headers);
            this.partBodies.add(requestBody);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    private static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    public MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, (String) null, RequestBody.create((MediaType) null, str2));
    }

    public MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=");
            appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                appendQuotedString(sb, str2);
            }
            return addPart(Headers.of(HttpHeaders.CONTENT_DISPOSITION, sb.toString()), requestBody);
        }
        throw new NullPointerException("name == null");
    }

    public RequestBody build() {
        if (!this.partHeaders.isEmpty()) {
            return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }

    private static final class MultipartRequestBody extends RequestBody {
        private final ByteString boundary;
        private long contentLength = -1;
        private final MediaType contentType;
        private final List<RequestBody> partBodies;
        private final List<Headers> partHeaders;

        public MultipartRequestBody(MediaType mediaType, ByteString byteString, List<Headers> list, List<RequestBody> list2) {
            if (mediaType != null) {
                this.boundary = byteString;
                this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
                this.partHeaders = Util.immutableList(list);
                this.partBodies = Util.immutableList(list2);
                return;
            }
            throw new NullPointerException("type == null");
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public long contentLength() throws IOException {
            long j = this.contentLength;
            if (j != -1) {
                return j;
            }
            long writeOrCountBytes = writeOrCountBytes((BufferedSink) null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.BufferedSink} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.BufferedSink} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long writeOrCountBytes(okio.BufferedSink r13, boolean r14) throws java.io.IOException {
            /*
                r12 = this;
                if (r14 == 0) goto L_0x0009
                okio.Buffer r13 = new okio.Buffer
                r13.<init>()
                r0 = r13
                goto L_0x000a
            L_0x0009:
                r0 = 0
            L_0x000a:
                java.util.List<com.squareup.okhttp.Headers> r1 = r12.partHeaders
                int r1 = r1.size()
                r2 = 0
                r3 = 0
                r4 = r3
                r3 = 0
            L_0x0015:
                if (r3 >= r1) goto L_0x00c3
                java.util.List<com.squareup.okhttp.Headers> r6 = r12.partHeaders
                java.lang.Object r6 = r6.get(r3)
                com.squareup.okhttp.Headers r6 = (com.squareup.okhttp.Headers) r6
                java.util.List<com.squareup.okhttp.RequestBody> r7 = r12.partBodies
                java.lang.Object r7 = r7.get(r3)
                com.squareup.okhttp.RequestBody r7 = (com.squareup.okhttp.RequestBody) r7
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.write((byte[]) r8)
                okio.ByteString r8 = r12.boundary
                r13.write((okio.ByteString) r8)
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.write((byte[]) r8)
                if (r6 == 0) goto L_0x0065
                int r8 = r6.size()
                r9 = 0
            L_0x0041:
                if (r9 >= r8) goto L_0x0065
                java.lang.String r10 = r6.name(r9)
                okio.BufferedSink r10 = r13.writeUtf8(r10)
                byte[] r11 = com.squareup.okhttp.MultipartBuilder.COLONSPACE
                okio.BufferedSink r10 = r10.write((byte[]) r11)
                java.lang.String r11 = r6.value(r9)
                okio.BufferedSink r10 = r10.writeUtf8(r11)
                byte[] r11 = com.squareup.okhttp.MultipartBuilder.CRLF
                r10.write((byte[]) r11)
                int r9 = r9 + 1
                goto L_0x0041
            L_0x0065:
                com.squareup.okhttp.MediaType r6 = r7.contentType()
                if (r6 == 0) goto L_0x0080
                java.lang.String r8 = "Content-Type: "
                okio.BufferedSink r8 = r13.writeUtf8(r8)
                java.lang.String r6 = r6.toString()
                okio.BufferedSink r6 = r8.writeUtf8(r6)
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r6.write((byte[]) r8)
            L_0x0080:
                long r6 = r7.contentLength()
                r8 = -1
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 == 0) goto L_0x009c
                java.lang.String r8 = "Content-Length: "
                okio.BufferedSink r8 = r13.writeUtf8(r8)
                okio.BufferedSink r8 = r8.writeDecimalLong(r6)
                byte[] r9 = com.squareup.okhttp.MultipartBuilder.CRLF
                r8.write((byte[]) r9)
                goto L_0x00a2
            L_0x009c:
                if (r14 == 0) goto L_0x00a2
                r0.clear()
                return r8
            L_0x00a2:
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.write((byte[]) r8)
                if (r14 == 0) goto L_0x00ad
                long r4 = r4 + r6
                goto L_0x00b8
            L_0x00ad:
                java.util.List<com.squareup.okhttp.RequestBody> r6 = r12.partBodies
                java.lang.Object r6 = r6.get(r3)
                com.squareup.okhttp.RequestBody r6 = (com.squareup.okhttp.RequestBody) r6
                r6.writeTo(r13)
            L_0x00b8:
                byte[] r6 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.write((byte[]) r6)
                int r3 = r3 + 1
                goto L_0x0015
            L_0x00c3:
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.write((byte[]) r1)
                okio.ByteString r1 = r12.boundary
                r13.write((okio.ByteString) r1)
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.write((byte[]) r1)
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.write((byte[]) r1)
                if (r14 == 0) goto L_0x00e7
                long r13 = r0.size()
                long r4 = r4 + r13
                r0.clear()
            L_0x00e7:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.MultipartBuilder.MultipartRequestBody.writeOrCountBytes(okio.BufferedSink, boolean):long");
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            writeOrCountBytes(bufferedSink, false);
        }
    }
}
