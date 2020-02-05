package com.squareup.okhttp.internal.tls;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class RealTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public RealTrustRootIndex(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List list = this.subjectToCaCerts.get(subjectX500Principal);
            if (list == null) {
                list = new ArrayList(1);
                this.subjectToCaCerts.put(subjectX500Principal, list);
            }
            list.add(x509Certificate);
        }
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        List<X509Certificate> list = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
