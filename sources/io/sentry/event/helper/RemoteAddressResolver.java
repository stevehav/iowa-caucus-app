package io.sentry.event.helper;

import javax.servlet.http.HttpServletRequest;

public interface RemoteAddressResolver {
    String getRemoteAddress(HttpServletRequest httpServletRequest);
}
