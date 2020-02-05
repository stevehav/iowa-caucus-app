package io.sentry.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NoInitialContextException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JndiLookup {
    private static final String JNDI_PREFIX = "java:comp/env/sentry/";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) JndiLookup.class);

    private JndiLookup() {
    }

    public static String jndiLookup(String str) {
        try {
            InitialContext initialContext = new InitialContext();
            return (String) initialContext.lookup(JNDI_PREFIX + str);
        } catch (NoInitialContextException unused) {
            logger.trace("JNDI not configured for Sentry (NoInitialContextEx)");
        } catch (NamingException unused2) {
            Logger logger2 = logger;
            logger2.trace("No /sentry/" + str + " in JNDI");
        } catch (RuntimeException e) {
            logger.warn("Odd RuntimeException while testing for JNDI", (Throwable) e);
        }
        return null;
    }
}
