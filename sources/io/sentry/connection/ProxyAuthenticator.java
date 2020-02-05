package io.sentry.connection;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ProxyAuthenticator extends Authenticator {
    private String pass;
    private String user;

    public ProxyAuthenticator(String str, String str2) {
        this.user = str;
        this.pass = str2;
    }

    /* access modifiers changed from: protected */
    public PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.user, this.pass.toCharArray());
        }
        return null;
    }
}
