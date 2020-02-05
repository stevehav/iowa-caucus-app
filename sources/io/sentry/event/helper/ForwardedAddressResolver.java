package io.sentry.event.helper;

import io.sentry.util.Util;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

public class ForwardedAddressResolver implements RemoteAddressResolver {
    private BasicRemoteAddressResolver basicRemoteAddressResolver = new BasicRemoteAddressResolver();

    private static String firstAddress(String str) {
        return ((String) Arrays.asList(str.split(",")).get(0)).trim();
    }

    public String getRemoteAddress(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (!Util.isNullOrEmpty(header)) {
            return firstAddress(header);
        }
        return this.basicRemoteAddressResolver.getRemoteAddress(httpServletRequest);
    }
}
