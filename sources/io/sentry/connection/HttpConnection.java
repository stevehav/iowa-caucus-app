package io.sentry.connection;

import com.google.common.net.HttpHeaders;
import io.grpc.internal.GrpcUtil;
import io.sentry.environment.SentryEnvironment;
import io.sentry.marshaller.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnection extends AbstractConnection {
    private static final int DEFAULT_CONNECTION_TIMEOUT = ((int) TimeUnit.SECONDS.toMillis(1));
    private static final int DEFAULT_READ_TIMEOUT = ((int) TimeUnit.SECONDS.toMillis(5));
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final HostnameVerifier NAIVE_VERIFIER = new HostnameVerifier() {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    private static final String SENTRY_AUTH = "X-Sentry-Auth";
    private static final String USER_AGENT = "User-Agent";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) HttpConnection.class);
    private boolean bypassSecurity = false;
    private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private EventSampler eventSampler;
    private Marshaller marshaller;
    private final Proxy proxy;
    private int readTimeout = DEFAULT_READ_TIMEOUT;
    private final URL sentryUrl;

    public void close() throws IOException {
    }

    public HttpConnection(URL url, String str, String str2, Proxy proxy2, EventSampler eventSampler2) {
        super(str, str2);
        this.sentryUrl = url;
        this.proxy = proxy2;
        this.eventSampler = eventSampler2;
    }

    public static URL getSentryApiUrl(URI uri, String str) {
        try {
            return new URL(uri.toString() + "api/" + str + "/store/");
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Couldn't build a valid URL from the Sentry API.", e);
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection getConnection() {
        HttpURLConnection httpURLConnection;
        try {
            if (this.proxy != null) {
                httpURLConnection = (HttpURLConnection) this.sentryUrl.openConnection(this.proxy);
            } else {
                httpURLConnection = (HttpURLConnection) this.sentryUrl.openConnection();
            }
            if (this.bypassSecurity && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(NAIVE_VERIFIER);
            }
            httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(this.connectionTimeout);
            httpURLConnection.setReadTimeout(this.readTimeout);
            httpURLConnection.setRequestProperty("User-Agent", SentryEnvironment.getSentryName());
            httpURLConnection.setRequestProperty(SENTRY_AUTH, getAuthHeader());
            if (this.marshaller.getContentType() != null) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, this.marshaller.getContentType());
            }
            if (this.marshaller.getContentEncoding() != null) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, this.marshaller.getContentEncoding());
            }
            return httpURLConnection;
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't set up a connection to the Sentry server.", e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058 A[Catch:{ IOException -> 0x002c, all -> 0x0029, IOException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b A[SYNTHETIC, Splitter:B:29:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ IOException -> 0x002c, all -> 0x0029, IOException -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doSend(io.sentry.event.Event r9) throws io.sentry.connection.ConnectionException {
        /*
            r8 = this;
            io.sentry.connection.EventSampler r0 = r8.eventSampler
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.shouldSendEvent(r9)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.net.HttpURLConnection r0 = r8.getConnection()
            r0.connect()     // Catch:{ IOException -> 0x002c }
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ IOException -> 0x002c }
            io.sentry.marshaller.Marshaller r2 = r8.marshaller     // Catch:{ IOException -> 0x002c }
            r2.marshall(r9, r1)     // Catch:{ IOException -> 0x002c }
            r1.close()     // Catch:{ IOException -> 0x002c }
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ IOException -> 0x002c }
            r1.close()     // Catch:{ IOException -> 0x002c }
            r0.disconnect()
            return
        L_0x0029:
            r9 = move-exception
            goto L_0x00a7
        L_0x002c:
            r1 = move-exception
            java.lang.String r2 = "Retry-After"
            java.lang.String r2 = r0.getHeaderField(r2)     // Catch:{ all -> 0x0029 }
            r3 = 0
            if (r2 == 0) goto L_0x0047
            double r4 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0047 }
            r6 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r4 = r4 * r6
            long r4 = (long) r4     // Catch:{ NumberFormatException -> 0x0047 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
            r2 = r3
        L_0x0048:
            int r4 = r0.getResponseCode()     // Catch:{ IOException -> 0x008c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x008c }
            int r5 = r4.intValue()     // Catch:{ IOException -> 0x008d }
            r6 = 403(0x193, float:5.65E-43)
            if (r5 != r6) goto L_0x007b
            org.slf4j.Logger r5 = logger     // Catch:{ IOException -> 0x008d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008d }
            r6.<init>()     // Catch:{ IOException -> 0x008d }
            java.lang.String r7 = "Event '"
            r6.append(r7)     // Catch:{ IOException -> 0x008d }
            java.util.UUID r9 = r9.getId()     // Catch:{ IOException -> 0x008d }
            r6.append(r9)     // Catch:{ IOException -> 0x008d }
            java.lang.String r9 = "' was rejected by the Sentry server due to a filter."
            r6.append(r9)     // Catch:{ IOException -> 0x008d }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x008d }
            r5.debug(r9)     // Catch:{ IOException -> 0x008d }
            r0.disconnect()
            return
        L_0x007b:
            int r9 = r4.intValue()     // Catch:{ IOException -> 0x008d }
            r5 = 429(0x1ad, float:6.01E-43)
            if (r9 == r5) goto L_0x0084
            goto L_0x008d
        L_0x0084:
            io.sentry.connection.TooManyRequestsException r9 = new io.sentry.connection.TooManyRequestsException     // Catch:{ IOException -> 0x008d }
            java.lang.String r5 = "Too many requests to Sentry: https://docs.sentry.io/learn/quotas/"
            r9.<init>(r5, r1, r2, r4)     // Catch:{ IOException -> 0x008d }
            throw r9     // Catch:{ IOException -> 0x008d }
        L_0x008c:
            r4 = r3
        L_0x008d:
            java.io.InputStream r9 = r0.getErrorStream()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x0097
            java.lang.String r3 = r8.getErrorMessageFromStream(r9)     // Catch:{ all -> 0x0029 }
        L_0x0097:
            if (r3 == 0) goto L_0x009f
            boolean r9 = r3.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x00a1
        L_0x009f:
            java.lang.String r3 = "An exception occurred while submitting the event to the Sentry server."
        L_0x00a1:
            io.sentry.connection.ConnectionException r9 = new io.sentry.connection.ConnectionException     // Catch:{ all -> 0x0029 }
            r9.<init>(r3, r1, r2, r4)     // Catch:{ all -> 0x0029 }
            throw r9     // Catch:{ all -> 0x0029 }
        L_0x00a7:
            r0.disconnect()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.connection.HttpConnection.doSend(io.sentry.event.Event):void");
    }

    private String getErrorMessageFromStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!z) {
                    sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                }
                sb.append(readLine);
                z = false;
            } catch (Exception e) {
                logger.error("Exception while reading the error message from the connection.", (Throwable) e);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public void setTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setMarshaller(Marshaller marshaller2) {
        this.marshaller = marshaller2;
    }

    public void setBypassSecurity(boolean z) {
        this.bypassSecurity = z;
    }
}
