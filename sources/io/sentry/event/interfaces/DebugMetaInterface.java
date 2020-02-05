package io.sentry.event.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

public class DebugMetaInterface implements SentryInterface {
    public static final String DEBUG_META_INTERFACE = "debug_meta";
    private ArrayList<DebugImage> debugImages = new ArrayList<>();

    public String getInterfaceName() {
        return DEBUG_META_INTERFACE;
    }

    public ArrayList<DebugImage> getDebugImages() {
        return this.debugImages;
    }

    public void addDebugImage(DebugImage debugImage) {
        this.debugImages.add(debugImage);
    }

    public int hashCode() {
        return this.debugImages.hashCode();
    }

    public String toString() {
        return "DebugMetaInterface{debugImages=" + this.debugImages + '}';
    }

    public static class DebugImage implements Serializable {
        private static final String DEFAULT_TYPE = "proguard";
        private final String type;
        private final String uuid;

        public DebugImage(String str) {
            this(str, DEFAULT_TYPE);
        }

        public DebugImage(String str, String str2) {
            this.uuid = str;
            this.type = str2;
        }

        public String getUuid() {
            return this.uuid;
        }

        public String getType() {
            return this.type;
        }

        public String toString() {
            return "DebugImage{uuid='" + this.uuid + '\'' + ", type='" + this.type + '\'' + '}';
        }
    }
}
