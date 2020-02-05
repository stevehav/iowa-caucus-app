package io.sentry.util;

import java.io.Closeable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class Util {
    private Util() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static Map<String, String> parseCsv(String str, String str2) {
        if (isNullOrEmpty(str)) {
            return Collections.emptyMap();
        }
        String[] split = str.split(",");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str3 = split[i];
            String[] split2 = str3.split(":");
            if (split2.length == 2) {
                linkedHashMap.put(split2[0], split2[1]);
                i++;
            } else {
                throw new IllegalArgumentException("Invalid " + str2 + " entry: " + str3);
            }
        }
        return linkedHashMap;
    }

    public static Map<String, String> parseTags(String str) {
        return parseCsv(str, "tags");
    }

    public static Map<String, String> parseExtra(String str) {
        return parseCsv(str, "extras");
    }

    @Deprecated
    public static Set<String> parseExtraTags(String str) {
        return parseMdcTags(str);
    }

    public static Set<String> parseMdcTags(String str) {
        if (isNullOrEmpty(str)) {
            return Collections.emptySet();
        }
        return new HashSet(Arrays.asList(str.split(",")));
    }

    public static Integer parseInteger(String str, Integer num) {
        if (isNullOrEmpty(str)) {
            return num;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static Long parseLong(String str, Long l) {
        if (isNullOrEmpty(str)) {
            return l;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public static Double parseDouble(String str, Double d) {
        if (isNullOrEmpty(str)) {
            return d;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public static String trimString(String str, int i) {
        if (str == null) {
            return null;
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i - 3) + "...";
    }

    public static boolean safelyRemoveShutdownHook(Thread thread) {
        try {
            return Runtime.getRuntime().removeShutdownHook(thread);
        } catch (IllegalStateException e) {
            if (e.getMessage().equals("Shutdown in progress")) {
                return false;
            }
            throw e;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
