package com.facebook.react.modules.network;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@ReactModule(name = "Networking")
public final class NetworkingModule extends ReactContextBaseJavaModule {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "NetworkingModule";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    @Nullable
    private static CustomClientBuilder customClientBuilder;
    /* access modifiers changed from: private */
    public final OkHttpClient mClient;
    private final ForwardingCookieHandler mCookieHandler;
    private final CookieJarContainer mCookieJarContainer;
    @Nullable
    private final String mDefaultUserAgent;
    private final List<RequestBodyHandler> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    /* access modifiers changed from: private */
    public final List<ResponseHandler> mResponseHandlers;
    /* access modifiers changed from: private */
    public boolean mShuttingDown;
    private final List<UriHandler> mUriHandlers;

    public interface CustomClientBuilder {
        void apply(OkHttpClient.Builder builder);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    /* access modifiers changed from: private */
    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public String getName() {
        return NAME;
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient, @Nullable List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator create : list) {
                newBuilder.addNetworkInterceptor(create.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    public void initialize() {
        this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.destroy();
        this.mCookieJarContainer.removeCookieJar();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    @ReactMethod
    public void sendRequest(String str, String str2, int i, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, int i2, boolean z2) {
        try {
            sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, i2, z2);
        } catch (Throwable th) {
            FLog.e(TAG, "Failed to send url request: " + str2, th);
            ResponseUtil.onRequestError(getEventEmitter(), i, th.getMessage(), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendRequestInternal(java.lang.String r7, java.lang.String r8, final int r9, com.facebook.react.bridge.ReadableArray r10, com.facebook.react.bridge.ReadableMap r11, final java.lang.String r12, boolean r13, int r14, boolean r15) {
        /*
            r6 = this;
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r3 = r6.getEventEmitter()
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch:{ IOException -> 0x01ab }
            java.util.List<com.facebook.react.modules.network.NetworkingModule$UriHandler> r1 = r6.mUriHandlers     // Catch:{ IOException -> 0x01ab }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x01ab }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x01ab }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x01ab }
            com.facebook.react.modules.network.NetworkingModule$UriHandler r2 = (com.facebook.react.modules.network.NetworkingModule.UriHandler) r2     // Catch:{ IOException -> 0x01ab }
            boolean r4 = r2.supports(r0, r12)     // Catch:{ IOException -> 0x01ab }
            if (r4 == 0) goto L_0x000e
            com.facebook.react.bridge.WritableMap r7 = r2.fetch(r0)     // Catch:{ IOException -> 0x01ab }
            com.facebook.react.modules.network.ResponseUtil.onDataReceived((com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r3, (int) r9, (com.facebook.react.bridge.WritableMap) r7)     // Catch:{ IOException -> 0x01ab }
            com.facebook.react.modules.network.ResponseUtil.onRequestSuccess(r3, r9)     // Catch:{ IOException -> 0x01ab }
            return
        L_0x002b:
            r0 = 0
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x01a2 }
            r1.<init>()     // Catch:{ Exception -> 0x01a2 }
            okhttp3.Request$Builder r8 = r1.url((java.lang.String) r8)     // Catch:{ Exception -> 0x01a2 }
            if (r9 == 0) goto L_0x003e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r8.tag(r1)
        L_0x003e:
            okhttp3.OkHttpClient r1 = r6.mClient
            okhttp3.OkHttpClient$Builder r1 = r1.newBuilder()
            applyCustomBuilder(r1)
            if (r15 != 0) goto L_0x004e
            okhttp3.CookieJar r15 = okhttp3.CookieJar.NO_COOKIES
            r1.cookieJar(r15)
        L_0x004e:
            if (r13 == 0) goto L_0x0058
            com.facebook.react.modules.network.NetworkingModule$1 r15 = new com.facebook.react.modules.network.NetworkingModule$1
            r15.<init>(r12, r3, r9)
            r1.addNetworkInterceptor(r15)
        L_0x0058:
            okhttp3.OkHttpClient r15 = r6.mClient
            int r15 = r15.connectTimeoutMillis()
            if (r14 == r15) goto L_0x0066
            long r14 = (long) r14
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r1.connectTimeout(r14, r2)
        L_0x0066:
            okhttp3.OkHttpClient r14 = r1.build()
            okhttp3.Headers r10 = r6.extractHeaders(r10, r11)
            if (r10 != 0) goto L_0x0076
            java.lang.String r7 = "Unrecognized headers format"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r7, r0)
            return
        L_0x0076:
            java.lang.String r15 = "content-type"
            java.lang.String r15 = r10.get(r15)
            java.lang.String r1 = "content-encoding"
            java.lang.String r1 = r10.get(r1)
            r8.headers(r10)
            if (r11 == 0) goto L_0x00a0
            java.util.List<com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler> r10 = r6.mRequestBodyHandlers
            java.util.Iterator r10 = r10.iterator()
        L_0x008d:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r10.next()
            com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler r2 = (com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler) r2
            boolean r4 = r2.supports(r11)
            if (r4 == 0) goto L_0x008d
            goto L_0x00a1
        L_0x00a0:
            r2 = r0
        L_0x00a1:
            if (r11 == 0) goto L_0x017e
            java.lang.String r10 = r7.toLowerCase()
            java.lang.String r4 = "get"
            boolean r10 = r10.equals(r4)
            if (r10 != 0) goto L_0x017e
            java.lang.String r10 = r7.toLowerCase()
            java.lang.String r4 = "head"
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x00bd
            goto L_0x017e
        L_0x00bd:
            if (r2 == 0) goto L_0x00c5
            okhttp3.RequestBody r10 = r2.toRequestBody(r11, r15)
            goto L_0x0182
        L_0x00c5:
            java.lang.String r10 = "string"
            boolean r2 = r11.hasKey(r10)
            java.lang.String r4 = "Payload is set but no content-type header specified"
            if (r2 == 0) goto L_0x0104
            if (r15 != 0) goto L_0x00d5
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r4, r0)
            return
        L_0x00d5:
            java.lang.String r10 = r11.getString(r10)
            okhttp3.MediaType r11 = okhttp3.MediaType.parse(r15)
            boolean r15 = com.facebook.react.modules.network.RequestBodyUtil.isGzipEncoding(r1)
            if (r15 == 0) goto L_0x00ef
            okhttp3.RequestBody r10 = com.facebook.react.modules.network.RequestBodyUtil.createGzip(r11, r10)
            if (r10 != 0) goto L_0x0182
            java.lang.String r7 = "Failed to gzip request body"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r7, r0)
            return
        L_0x00ef:
            if (r11 != 0) goto L_0x00f4
            java.nio.charset.Charset r15 = com.facebook.react.common.StandardCharsets.UTF_8
            goto L_0x00fa
        L_0x00f4:
            java.nio.charset.Charset r15 = com.facebook.react.common.StandardCharsets.UTF_8
            java.nio.charset.Charset r15 = r11.charset(r15)
        L_0x00fa:
            byte[] r10 = r10.getBytes(r15)
            okhttp3.RequestBody r10 = okhttp3.RequestBody.create((okhttp3.MediaType) r11, (byte[]) r10)
            goto L_0x0182
        L_0x0104:
            java.lang.String r10 = "base64"
            boolean r1 = r11.hasKey(r10)
            if (r1 == 0) goto L_0x0123
            if (r15 != 0) goto L_0x0112
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r4, r0)
            return
        L_0x0112:
            java.lang.String r10 = r11.getString(r10)
            okhttp3.MediaType r11 = okhttp3.MediaType.parse(r15)
            okio.ByteString r10 = okio.ByteString.decodeBase64(r10)
            okhttp3.RequestBody r10 = okhttp3.RequestBody.create((okhttp3.MediaType) r11, (okio.ByteString) r10)
            goto L_0x0182
        L_0x0123:
            java.lang.String r10 = "uri"
            boolean r1 = r11.hasKey(r10)
            if (r1 == 0) goto L_0x015d
            if (r15 != 0) goto L_0x0131
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r4, r0)
            return
        L_0x0131:
            java.lang.String r10 = r11.getString(r10)
            com.facebook.react.bridge.ReactApplicationContext r11 = r6.getReactApplicationContext()
            java.io.InputStream r11 = com.facebook.react.modules.network.RequestBodyUtil.getFileInputStream(r11, r10)
            if (r11 != 0) goto L_0x0154
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Could not retrieve file for uri "
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r7, r0)
            return
        L_0x0154:
            okhttp3.MediaType r10 = okhttp3.MediaType.parse(r15)
            okhttp3.RequestBody r10 = com.facebook.react.modules.network.RequestBodyUtil.create(r10, r11)
            goto L_0x0182
        L_0x015d:
            java.lang.String r10 = "formData"
            boolean r0 = r11.hasKey(r10)
            if (r0 == 0) goto L_0x0179
            if (r15 != 0) goto L_0x0169
            java.lang.String r15 = "multipart/form-data"
        L_0x0169:
            com.facebook.react.bridge.ReadableArray r10 = r11.getArray(r10)
            okhttp3.MultipartBody$Builder r10 = r6.constructMultipartBody(r10, r15, r9)
            if (r10 != 0) goto L_0x0174
            return
        L_0x0174:
            okhttp3.MultipartBody r10 = r10.build()
            goto L_0x0182
        L_0x0179:
            okhttp3.RequestBody r10 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r7)
            goto L_0x0182
        L_0x017e:
            okhttp3.RequestBody r10 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r7)
        L_0x0182:
            okhttp3.RequestBody r10 = r6.wrapRequestBodyWithProgressEmitter(r10, r3, r9)
            r8.method(r7, r10)
            r6.addRequest(r9)
            okhttp3.Request r7 = r8.build()
            okhttp3.Call r7 = r14.newCall(r7)
            com.facebook.react.modules.network.NetworkingModule$2 r8 = new com.facebook.react.modules.network.NetworkingModule$2
            r0 = r8
            r1 = r6
            r2 = r9
            r4 = r12
            r5 = r13
            r0.<init>(r2, r3, r4, r5)
            r7.enqueue(r8)
            return
        L_0x01a2:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r7, r0)
            return
        L_0x01ab:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r3, r9, r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.sendRequestInternal(java.lang.String, java.lang.String, int, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, java.lang.String, boolean, int, boolean):void");
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() {
            long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    ResponseUtil.onDataSend(rCTDeviceEventEmitter, i, j, j2);
                    this.last = nanoTime;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.totalBytesRead();
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    ResponseUtil.onIncrementalDataReceived(rCTDeviceEventEmitter, i, progressiveStringDecoder.decodeNext(bArr, read), j, j2);
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    /* access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        WritableMap createMap = Arguments.createMap();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (createMap.hasKey(name)) {
                createMap.putString(name, createMap.getString(name) + ", " + headers.value(i));
            } else {
                createMap.putString(name, headers.value(i));
            }
        }
        return createMap;
    }

    @ReactMethod
    public void abortRequest(int i) {
        cancelRequest(i);
        removeRequest(i);
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(i));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public void clearCookies(Callback callback) {
        this.mCookieHandler.clearCookies(callback);
    }

    @Nullable
    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), (ReadableMap) null);
            if (extractHeaders == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", (Throwable) null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized FormData part.", (Throwable) null);
            } else if (mediaType == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", (Throwable) null);
                return null;
            } else {
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    ResponseUtil.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + string, (Throwable) null);
                    return null;
                }
                builder.addPart(extractHeaders, RequestBodyUtil.create(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    @Nullable
    private Headers extractHeaders(@Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        boolean z = false;
        int i = 0;
        while (i < size) {
            ReadableArray array = readableArray.getArray(i);
            if (array != null && array.size() == 2) {
                String stripHeaderName = HeaderUtil.stripHeaderName(array.getString(0));
                String stripHeaderValue = HeaderUtil.stripHeaderValue(array.getString(1));
                if (!(stripHeaderName == null || stripHeaderValue == null)) {
                    builder.add(stripHeaderName, stripHeaderValue);
                    i++;
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.mDefaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (readableMap != null && readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
            z = true;
        }
        if (!z) {
            builder.removeAll("content-encoding");
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter() {
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }
}
