package io.sentry.event.interfaces;

import io.sentry.event.helper.BasicRemoteAddressResolver;
import io.sentry.event.helper.RemoteAddressResolver;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpInterface implements SentryInterface {
    public static final String HTTP_INTERFACE = "sentry.interfaces.Http";
    private final boolean asyncStarted;
    private final String authType;
    private final String body;
    private final Map<String, String> cookies;
    private final Map<String, Collection<String>> headers;
    private final String localAddr;
    private final String localName;
    private final int localPort;
    private final String method;
    private final Map<String, Collection<String>> parameters;
    private final String protocol;
    private final String queryString;
    private final String remoteAddr;
    private final String remoteUser;
    private final String requestUrl;
    private final boolean secure;
    private final String serverName;
    private final int serverPort;

    public String getInterfaceName() {
        return HTTP_INTERFACE;
    }

    public HttpInterface(HttpServletRequest httpServletRequest) {
        this(httpServletRequest, new BasicRemoteAddressResolver());
    }

    public HttpInterface(HttpServletRequest httpServletRequest, RemoteAddressResolver remoteAddressResolver) {
        this(httpServletRequest, remoteAddressResolver, (String) null);
    }

    public HttpInterface(HttpServletRequest httpServletRequest, RemoteAddressResolver remoteAddressResolver, String str) {
        this.requestUrl = httpServletRequest.getRequestURL().toString();
        this.method = httpServletRequest.getMethod();
        this.parameters = new HashMap();
        for (Map.Entry entry : httpServletRequest.getParameterMap().entrySet()) {
            this.parameters.put(entry.getKey(), Arrays.asList((Object[]) entry.getValue()));
        }
        this.queryString = httpServletRequest.getQueryString();
        if (httpServletRequest.getCookies() != null) {
            this.cookies = new HashMap();
            for (Cookie cookie : httpServletRequest.getCookies()) {
                this.cookies.put(cookie.getName(), cookie.getValue());
            }
        } else {
            this.cookies = Collections.emptyMap();
        }
        this.remoteAddr = remoteAddressResolver.getRemoteAddress(httpServletRequest);
        this.serverName = httpServletRequest.getServerName();
        this.serverPort = httpServletRequest.getServerPort();
        this.localAddr = httpServletRequest.getLocalAddr();
        this.localName = httpServletRequest.getLocalName();
        this.localPort = httpServletRequest.getLocalPort();
        this.protocol = httpServletRequest.getProtocol();
        this.secure = httpServletRequest.isSecure();
        this.asyncStarted = httpServletRequest.isAsyncStarted();
        this.authType = httpServletRequest.getAuthType();
        this.remoteUser = httpServletRequest.getRemoteUser();
        this.headers = new HashMap();
        Iterator it = Collections.list(httpServletRequest.getHeaderNames()).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            this.headers.put(str2, Collections.list(httpServletRequest.getHeaders(str2)));
        }
        this.body = str;
    }

    public HttpInterface(String str, String str2, Map<String, Collection<String>> map, String str3, Map<String, String> map2, String str4, String str5, int i, String str6, String str7, int i2, String str8, boolean z, boolean z2, String str9, String str10, Map<String, Collection<String>> map3, String str11) {
        this.requestUrl = str;
        this.method = str2;
        this.parameters = map;
        this.queryString = str3;
        this.cookies = map2;
        this.remoteAddr = str4;
        this.serverName = str5;
        this.serverPort = i;
        this.localAddr = str6;
        this.localName = str7;
        this.localPort = i2;
        this.protocol = str8;
        this.secure = z;
        this.asyncStarted = z2;
        this.authType = str9;
        this.remoteUser = str10;
        this.headers = map3;
        this.body = str11;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, Collection<String>> getParameters() {
        return Collections.unmodifiableMap(this.parameters);
    }

    public String getQueryString() {
        return this.queryString;
    }

    public Map<String, String> getCookies() {
        return this.cookies;
    }

    public String getRemoteAddr() {
        return this.remoteAddr;
    }

    public String getServerName() {
        return this.serverName;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getLocalAddr() {
        return this.localAddr;
    }

    public String getLocalName() {
        return this.localName;
    }

    public int getLocalPort() {
        return this.localPort;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public boolean isAsyncStarted() {
        return this.asyncStarted;
    }

    public String getAuthType() {
        return this.authType;
    }

    public String getRemoteUser() {
        return this.remoteUser;
    }

    public String getBody() {
        return this.body;
    }

    public Map<String, Collection<String>> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    public String toString() {
        return "HttpInterface{requestUrl='" + this.requestUrl + '\'' + ", method='" + this.method + '\'' + ", queryString='" + this.queryString + '\'' + ", parameters=" + this.parameters + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpInterface httpInterface = (HttpInterface) obj;
        if (this.asyncStarted != httpInterface.asyncStarted || this.localPort != httpInterface.localPort || this.secure != httpInterface.secure || this.serverPort != httpInterface.serverPort) {
            return false;
        }
        String str = this.authType;
        if (str == null ? httpInterface.authType != null : !str.equals(httpInterface.authType)) {
            return false;
        }
        if (!this.cookies.equals(httpInterface.cookies) || !this.headers.equals(httpInterface.headers)) {
            return false;
        }
        String str2 = this.localAddr;
        if (str2 == null ? httpInterface.localAddr != null : !str2.equals(httpInterface.localAddr)) {
            return false;
        }
        String str3 = this.localName;
        if (str3 == null ? httpInterface.localName != null : !str3.equals(httpInterface.localName)) {
            return false;
        }
        String str4 = this.method;
        if (str4 == null ? httpInterface.method != null : !str4.equals(httpInterface.method)) {
            return false;
        }
        if (!this.parameters.equals(httpInterface.parameters)) {
            return false;
        }
        String str5 = this.protocol;
        if (str5 == null ? httpInterface.protocol != null : !str5.equals(httpInterface.protocol)) {
            return false;
        }
        String str6 = this.queryString;
        if (str6 == null ? httpInterface.queryString != null : !str6.equals(httpInterface.queryString)) {
            return false;
        }
        String str7 = this.remoteAddr;
        if (str7 == null ? httpInterface.remoteAddr != null : !str7.equals(httpInterface.remoteAddr)) {
            return false;
        }
        String str8 = this.remoteUser;
        if (str8 == null ? httpInterface.remoteUser != null : !str8.equals(httpInterface.remoteUser)) {
            return false;
        }
        if (!this.requestUrl.equals(httpInterface.requestUrl)) {
            return false;
        }
        String str9 = this.serverName;
        if (str9 == null ? httpInterface.serverName != null : !str9.equals(httpInterface.serverName)) {
            return false;
        }
        String str10 = this.body;
        return str10 == null ? httpInterface.body == null : str10.equals(httpInterface.body);
    }

    public int hashCode() {
        int hashCode = this.requestUrl.hashCode() * 31;
        String str = this.method;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.parameters.hashCode();
    }
}
