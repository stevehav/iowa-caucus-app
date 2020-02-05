package io.grpc.internal;

import android.annotation.SuppressLint;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Verify;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.internal.DnsNameResolver;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

final class JndiResourceResolverFactory implements DnsNameResolver.ResourceResolverFactory {
    /* access modifiers changed from: private */
    @Nullable
    public static final Throwable JNDI_UNAVAILABILITY_CAUSE = initJndi();

    @VisibleForTesting
    interface RecordFetcher {
        List<String> getAllRecords(String str, String str2) throws NamingException;
    }

    @Nullable
    private static Throwable initJndi() {
        if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
            return new UnsupportedOperationException("Currently running in an AppEngine restricted environment");
        }
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e) {
            return e;
        } catch (RuntimeException e2) {
            return e2;
        } catch (Error e3) {
            return e3;
        }
    }

    @Nullable
    public DnsNameResolver.ResourceResolver newResourceResolver() {
        if (unavailabilityCause() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Nullable
    public Throwable unavailabilityCause() {
        return JNDI_UNAVAILABILITY_CAUSE;
    }

    @VisibleForTesting
    static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final Logger logger = Logger.getLogger(JndiResourceResolver.class.getName());
        private static final Pattern whitespace = Pattern.compile("\\s+");
        private final RecordFetcher recordFetcher;

        static {
            Class<JndiResourceResolverFactory> cls = JndiResourceResolverFactory.class;
        }

        public JndiResourceResolver(RecordFetcher recordFetcher2) {
            this.recordFetcher = recordFetcher2;
        }

        public List<String> resolveTxt(String str) throws NamingException {
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query TXT records for {0}", new Object[]{str});
            }
            RecordFetcher recordFetcher2 = this.recordFetcher;
            List<String> allRecords = recordFetcher2.getAllRecords("TXT", "dns:///" + str);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} TXT records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            for (String unquote : allRecords) {
                arrayList.add(unquote(unquote));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public List<EquivalentAddressGroup> resolveSrv(DnsNameResolver.AddressResolver addressResolver, String str) throws Exception {
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "About to query SRV records for {0}", new Object[]{str});
            }
            RecordFetcher recordFetcher2 = this.recordFetcher;
            List<String> allRecords = recordFetcher2.getAllRecords("SRV", "dns:///" + str);
            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Found {0} SRV records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            Throwable th = null;
            Level level = Level.WARNING;
            for (String next : allRecords) {
                try {
                    SrvRecord parseSrvRecord = parseSrvRecord(next);
                    if (parseSrvRecord.host.endsWith(".")) {
                        String substring = parseSrvRecord.host.substring(0, parseSrvRecord.host.length() - 1);
                        List<InetAddress> resolveAddress = addressResolver.resolveAddress(parseSrvRecord.host);
                        ArrayList arrayList2 = new ArrayList(resolveAddress.size());
                        for (InetAddress inetSocketAddress : resolveAddress) {
                            arrayList2.add(new InetSocketAddress(inetSocketAddress, parseSrvRecord.port));
                        }
                        arrayList.add(new EquivalentAddressGroup((List<SocketAddress>) Collections.unmodifiableList(arrayList2), Attributes.newBuilder().set(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY, substring).build()));
                    } else {
                        throw new RuntimeException("Returned SRV host does not end in period: " + parseSrvRecord.host);
                    }
                } catch (UnknownHostException e) {
                    e = e;
                    Logger logger2 = logger;
                    logger2.log(level, "Can't find address for SRV record " + next, e);
                    if (th == null) {
                        level = Level.FINE;
                        th = e;
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    Logger logger3 = logger;
                    logger3.log(level, "Failed to construct SRV record " + next, e);
                    if (th == null) {
                        level = Level.FINE;
                        th = e;
                    }
                }
            }
            if (!arrayList.isEmpty() || th == null) {
                return Collections.unmodifiableList(arrayList);
            }
            throw th;
        }

        private static final class SrvRecord {
            final String host;
            final int port;

            SrvRecord(String str, int i) {
                this.host = str;
                this.port = i;
            }
        }

        private static SrvRecord parseSrvRecord(String str) {
            String[] split = whitespace.split(str);
            Verify.verify(split.length == 4, "Bad SRV Record: %s", (Object) str);
            return new SrvRecord(split[3], Integer.parseInt(split[2]));
        }

        @VisibleForTesting
        static String unquote(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            int i = 0;
            boolean z = false;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (!z) {
                    if (charAt != ' ') {
                        if (charAt == '\"') {
                            z = true;
                        }
                    }
                    i++;
                } else if (charAt == '\"') {
                    z = false;
                    i++;
                } else if (charAt == '\\') {
                    i++;
                    charAt = str.charAt(i);
                }
                sb.append(charAt);
                i++;
            }
            return sb.toString();
        }
    }

    @SuppressLint({"all"})
    @VisibleForTesting
    @IgnoreJRERequirement
    static final class JndiRecordFetcher implements RecordFetcher {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class<JndiResourceResolverFactory> cls = JndiResourceResolverFactory.class;
        }

        JndiRecordFetcher() {
        }

        public List<String> getAllRecords(String str, String str2) throws NamingException {
            checkAvailable();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e) {
                                closeThenThrow((NamingEnumeration<?>) all2, e);
                            }
                        }
                        all2.close();
                    } catch (NamingException e2) {
                        closeThenThrow((NamingEnumeration<?>) all, e2);
                    }
                }
                all.close();
            } catch (NamingException e3) {
                closeThenThrow((DirContext) initialDirContext, e3);
            }
            initialDirContext.close();
            return arrayList;
        }

        private static void closeThenThrow(NamingEnumeration<?> namingEnumeration, NamingException namingException) throws NamingException {
            try {
                namingEnumeration.close();
            } catch (NamingException unused) {
            }
            throw namingException;
        }

        private static void closeThenThrow(DirContext dirContext, NamingException namingException) throws NamingException {
            try {
                dirContext.close();
            } catch (NamingException unused) {
            }
            throw namingException;
        }

        private static void checkAvailable() {
            if (JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE);
            }
        }
    }
}
