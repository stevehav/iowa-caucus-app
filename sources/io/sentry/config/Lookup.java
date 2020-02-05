package io.sentry.config;

import io.sentry.dsn.Dsn;
import io.sentry.util.Util;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Lookup {
    private static final String CONFIG_FILE_NAME = "sentry.properties";
    private static boolean checkJndi = true;
    private static Properties configProps;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Lookup.class);

    static {
        String configFilePath = getConfigFilePath();
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(configFilePath);
            if (inputStream != null) {
                configProps = new Properties();
                configProps.load(inputStream);
            } else {
                logger.debug("Sentry configuration file not found in filesystem or classpath: '{}'.", (Object) configFilePath);
            }
        } catch (Exception e) {
            logger.error("Error loading Sentry configuration file '{}': ", (Object) configFilePath, (Object) e);
        } catch (Throwable th) {
            Util.closeQuietly((Closeable) null);
            throw th;
        }
        Util.closeQuietly(inputStream);
    }

    private Lookup() {
    }

    private static String getConfigFilePath() {
        String property = System.getProperty("sentry.properties.file");
        if (property == null) {
            property = System.getenv("SENTRY_PROPERTIES_FILE");
        }
        return property == null ? CONFIG_FILE_NAME : property;
    }

    private static InputStream getInputStream(String str) throws FileNotFoundException {
        File file = new File(str);
        if (!file.isFile() || !file.canRead()) {
            return Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
        }
        return new FileInputStream(file);
    }

    public static String lookup(String str) {
        return lookup(str, (Dsn) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d4 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String lookup(java.lang.String r7, io.sentry.dsn.Dsn r8) {
        /*
            boolean r0 = checkJndi
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = "javax.naming.InitialContext"
            java.lang.Class<io.sentry.dsn.Dsn> r3 = io.sentry.dsn.Dsn.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0025, NoClassDefFoundError -> 0x0023 }
            java.lang.Class.forName(r0, r2, r3)     // Catch:{ ClassNotFoundException -> 0x0025, NoClassDefFoundError -> 0x0023 }
            java.lang.String r0 = io.sentry.config.JndiLookup.jndiLookup(r7)     // Catch:{ ClassNotFoundException -> 0x0025, NoClassDefFoundError -> 0x0023 }
            if (r0 == 0) goto L_0x0045
            org.slf4j.Logger r3 = logger     // Catch:{ ClassNotFoundException -> 0x0021, NoClassDefFoundError -> 0x001f }
            java.lang.String r4 = "Found {}={} in JNDI."
            r3.debug((java.lang.String) r4, (java.lang.Object) r7, (java.lang.Object) r0)     // Catch:{ ClassNotFoundException -> 0x0021, NoClassDefFoundError -> 0x001f }
            goto L_0x0045
        L_0x001f:
            r3 = move-exception
            goto L_0x0027
        L_0x0021:
            r3 = move-exception
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            goto L_0x0026
        L_0x0025:
            r3 = move-exception
        L_0x0026:
            r0 = r1
        L_0x0027:
            org.slf4j.Logger r4 = logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "JNDI is not available: "
            r5.append(r6)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.trace(r3)
            checkJndi = r2
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            if (r0 != 0) goto L_0x0069
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "sentry."
            r0.append(r3)
            java.lang.String r3 = r7.toLowerCase()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x0069
            org.slf4j.Logger r3 = logger
            java.lang.String r4 = "Found {}={} in Java System Properties."
            r3.debug((java.lang.String) r4, (java.lang.Object) r7, (java.lang.Object) r0)
        L_0x0069:
            if (r0 != 0) goto L_0x0095
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "SENTRY_"
            r0.append(r3)
            java.lang.String r3 = "."
            java.lang.String r4 = "_"
            java.lang.String r3 = r7.replace(r3, r4)
            java.lang.String r3 = r3.toUpperCase()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = java.lang.System.getenv(r0)
            if (r0 == 0) goto L_0x0095
            org.slf4j.Logger r3 = logger
            java.lang.String r4 = "Found {}={} in System Environment Variables."
            r3.debug((java.lang.String) r4, (java.lang.Object) r7, (java.lang.Object) r0)
        L_0x0095:
            if (r0 != 0) goto L_0x00ad
            if (r8 == 0) goto L_0x00ad
            java.util.Map r8 = r8.getOptions()
            java.lang.Object r8 = r8.get(r7)
            r0 = r8
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00ad
            org.slf4j.Logger r8 = logger
            java.lang.String r3 = "Found {}={} in DSN."
            r8.debug((java.lang.String) r3, (java.lang.Object) r7, (java.lang.Object) r0)
        L_0x00ad:
            if (r0 != 0) goto L_0x00cd
            java.util.Properties r8 = configProps
            if (r8 == 0) goto L_0x00cd
            java.lang.String r0 = r8.getProperty(r7)
            if (r0 == 0) goto L_0x00cd
            org.slf4j.Logger r8 = logger
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r7
            r7 = 1
            r3[r7] = r0
            r7 = 2
            java.lang.String r2 = "sentry.properties"
            r3[r7] = r2
            java.lang.String r7 = "Found {}={} in {}."
            r8.debug((java.lang.String) r7, (java.lang.Object[]) r3)
        L_0x00cd:
            if (r0 == 0) goto L_0x00d4
            java.lang.String r7 = r0.trim()
            return r7
        L_0x00d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.config.Lookup.lookup(java.lang.String, io.sentry.dsn.Dsn):java.lang.String");
    }
}
