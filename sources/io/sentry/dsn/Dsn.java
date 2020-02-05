package io.sentry.dsn;

import io.sentry.config.Lookup;
import io.sentry.util.Util;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dsn {
    public static final String DEFAULT_DSN = "noop://localhost?async=false";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Dsn.class);
    private String host;
    private Map<String, String> options;
    private String path;
    private int port;
    private String projectId;
    private String protocol;
    private Set<String> protocolSettings;
    private String publicKey;
    private String secretKey;
    private URI uri;

    public Dsn(String str) throws InvalidDsnException {
        this(URI.create(str));
    }

    public Dsn(URI uri2) throws InvalidDsnException {
        if (uri2 != null) {
            this.options = new HashMap();
            this.protocolSettings = new HashSet();
            extractProtocolInfo(uri2);
            extractUserKeys(uri2);
            extractHostInfo(uri2);
            extractPathInfo(uri2);
            extractOptions(uri2);
            makeOptionsImmutable();
            validate();
            try {
                this.uri = new URI(this.protocol, (String) null, this.host, this.port, this.path, (String) null, (String) null);
            } catch (URISyntaxException e) {
                throw new InvalidDsnException("Impossible to determine Sentry's URI from the DSN '" + uri2 + "'", e);
            }
        } else {
            throw new InvalidDsnException("DSN constructed with null value!");
        }
    }

    public static String dsnLookup() {
        String lookup = Lookup.lookup("dsn");
        if (Util.isNullOrEmpty(lookup)) {
            lookup = Lookup.lookup("dns");
        }
        if (!Util.isNullOrEmpty(lookup)) {
            return lookup;
        }
        logger.warn("*** Couldn't find a suitable DSN, Sentry operations will do nothing! See documentation: https://docs.sentry.io/clients/java/ ***");
        return DEFAULT_DSN;
    }

    private void extractPathInfo(URI uri2) {
        String path2 = uri2.getPath();
        if (path2 != null) {
            int lastIndexOf = path2.lastIndexOf("/") + 1;
            this.path = path2.substring(0, lastIndexOf);
            this.projectId = path2.substring(lastIndexOf);
        }
    }

    private void extractHostInfo(URI uri2) {
        this.host = uri2.getHost();
        this.port = uri2.getPort();
    }

    private void extractProtocolInfo(URI uri2) {
        String scheme = uri2.getScheme();
        if (scheme != null) {
            String[] split = scheme.split("\\+");
            this.protocolSettings.addAll(Arrays.asList(split).subList(0, split.length - 1));
            this.protocol = split[split.length - 1];
        }
    }

    private void extractUserKeys(URI uri2) {
        String userInfo = uri2.getUserInfo();
        if (userInfo != null) {
            String[] split = userInfo.split(":");
            this.publicKey = split[0];
            if (split.length > 1) {
                this.secretKey = split[1];
            }
        }
    }

    private void extractOptions(URI uri2) {
        String query = uri2.getQuery();
        if (query != null && !query.isEmpty()) {
            String[] split = query.split("&");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str = split[i];
                try {
                    String[] split2 = str.split("=");
                    this.options.put(URLDecoder.decode(split2[0], "UTF-8"), split2.length > 1 ? URLDecoder.decode(split2[1], "UTF-8") : null);
                    i++;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalArgumentException("Impossible to decode the query parameter '" + str + "'", e);
                }
            }
        }
    }

    private void makeOptionsImmutable() {
        this.options = Collections.unmodifiableMap(this.options);
        this.protocolSettings = Collections.unmodifiableSet(this.protocolSettings);
    }

    private void validate() {
        LinkedList linkedList = new LinkedList();
        if (this.host == null) {
            linkedList.add("host");
        }
        String str = this.protocol;
        if (str != null && !str.equalsIgnoreCase("noop") && !this.protocol.equalsIgnoreCase("out")) {
            if (this.publicKey == null) {
                linkedList.add("public key");
            }
            String str2 = this.projectId;
            if (str2 == null || str2.isEmpty()) {
                linkedList.add("project ID");
            }
        }
        if (!linkedList.isEmpty()) {
            throw new InvalidDsnException("Invalid DSN, the following properties aren't set '" + linkedList + "'");
        }
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPath() {
        return this.path;
    }

    public Set<String> getProtocolSettings() {
        return this.protocolSettings;
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dsn dsn = (Dsn) obj;
        if (this.port != dsn.port || !this.host.equals(dsn.host) || !this.options.equals(dsn.options) || !this.path.equals(dsn.path) || !this.projectId.equals(dsn.projectId)) {
            return false;
        }
        String str = this.protocol;
        if (str == null ? dsn.protocol == null : str.equals(dsn.protocol)) {
            return this.protocolSettings.equals(dsn.protocolSettings) && this.publicKey.equals(dsn.publicKey) && Util.equals(this.secretKey, dsn.secretKey);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.publicKey.hashCode() * 31) + this.projectId.hashCode()) * 31) + this.host.hashCode()) * 31) + this.port) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "Dsn{uri=" + this.uri + '}';
    }
}
