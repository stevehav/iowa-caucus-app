package io.opencensus.resource;

import io.opencensus.internal.StringUtils;
import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Resource {
    private static final Map<String, String> ENV_LABEL_MAP = parseResourceLabels(System.getenv(OC_RESOURCE_LABELS_ENV));
    @Nullable
    private static final String ENV_TYPE = parseResourceType(System.getenv(OC_RESOURCE_TYPE_ENV));
    private static final String ERROR_MESSAGE_INVALID_CHARS = " should be a ASCII string with a length greater than 0 and not exceed 255 characters.";
    private static final String ERROR_MESSAGE_INVALID_VALUE = " should be a ASCII string with a length not exceed 255 characters.";
    private static final String LABEL_KEY_VALUE_SPLITTER = "=";
    private static final String LABEL_LIST_SPLITTER = ",";
    static final int MAX_LENGTH = 255;
    private static final String OC_RESOURCE_LABELS_ENV = "OC_RESOURCE_LABELS";
    private static final String OC_RESOURCE_TYPE_ENV = "OC_RESOURCE_TYPE";

    public abstract Map<String, String> getLabels();

    @Nullable
    public abstract String getType();

    Resource() {
    }

    public static Resource createFromEnvironmentVariables() {
        return createInternal(ENV_TYPE, ENV_LABEL_MAP);
    }

    public static Resource create(@Nullable String str, Map<String, String> map) {
        return createInternal(str, Collections.unmodifiableMap(new LinkedHashMap((Map) Utils.checkNotNull(map, "labels"))));
    }

    @Nullable
    public static Resource mergeResources(List<Resource> list) {
        Resource resource = null;
        for (Resource merge : list) {
            resource = merge(resource, merge);
        }
        return resource;
    }

    private static Resource createInternal(@Nullable String str, Map<String, String> map) {
        return new AutoValue_Resource(str, map);
    }

    @Nullable
    static String parseResourceType(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        Utils.checkArgument(isValidAndNotEmpty(str), "Type should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
        return str.trim();
    }

    static Map<String, String> parseResourceLabels(@Nullable String str) {
        if (str == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String split : str.split(LABEL_LIST_SPLITTER, -1)) {
            String[] split2 = split.split(LABEL_KEY_VALUE_SPLITTER, -1);
            if (split2.length == 2) {
                String trim = split2[0].trim();
                String replaceAll = split2[1].trim().replaceAll("^\"|\"$", "");
                Utils.checkArgument(isValidAndNotEmpty(trim), "Label key should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
                Utils.checkArgument(isValid(replaceAll), "Label value should be a ASCII string with a length not exceed 255 characters.");
                hashMap.put(trim, replaceAll);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @Nullable
    private static Resource merge(@Nullable Resource resource, @Nullable Resource resource2) {
        if (resource2 == null) {
            return resource;
        }
        if (resource == null) {
            return resource2;
        }
        String type = resource.getType() != null ? resource.getType() : resource2.getType();
        LinkedHashMap linkedHashMap = new LinkedHashMap(resource2.getLabels());
        for (Map.Entry next : resource.getLabels().entrySet()) {
            linkedHashMap.put(next.getKey(), next.getValue());
        }
        return createInternal(type, Collections.unmodifiableMap(linkedHashMap));
    }

    private static boolean isValid(String str) {
        return str.length() <= 255 && StringUtils.isPrintableString(str);
    }

    private static boolean isValidAndNotEmpty(String str) {
        return !str.isEmpty() && isValid(str);
    }
}
