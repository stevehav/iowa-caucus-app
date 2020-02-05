package io.sentry.event.helper;

import javax.servlet.http.HttpServletRequest;

public class BasicRemoteAddressResolver implements RemoteAddressResolver {
    public String getRemoteAddress(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRemoteAddr();
    }
}
