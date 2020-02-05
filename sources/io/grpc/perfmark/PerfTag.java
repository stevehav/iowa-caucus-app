package io.grpc.perfmark;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class PerfTag {
    private static final long NULL_NUMERIC_TAG = 0;
    /* access modifiers changed from: private */
    public static final String NULL_STRING_TAG = null;
    private final long numericTag;
    private final String stringTag;

    private PerfTag(long j, @Nullable String str) {
        this.numericTag = j;
        this.stringTag = str;
    }

    public long getNumericTag() {
        return this.numericTag;
    }

    @Nullable
    public String getStringTag() {
        return this.stringTag;
    }

    public String toString() {
        return "Tag(numericTag=" + this.numericTag + ",stringTag='" + this.stringTag + "')";
    }

    public int hashCode() {
        long j = this.numericTag;
        int i = (int) (j ^ (j >>> 32));
        String str = this.stringTag;
        return i + (str != null ? str.hashCode() : 31);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PerfTag)) {
            return false;
        }
        PerfTag perfTag = (PerfTag) obj;
        if (this.numericTag != perfTag.numericTag) {
            return false;
        }
        String str = this.stringTag;
        String str2 = perfTag.stringTag;
        if (str == str2 || (str != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    static final class TagFactory {
        private TagFactory() {
            throw new AssertionError("nope");
        }

        public static PerfTag create(long j, String str) {
            return new PerfTag(j, str);
        }

        public static PerfTag create(String str) {
            return new PerfTag(0, str);
        }

        public static PerfTag create(long j) {
            return new PerfTag(j, PerfTag.NULL_STRING_TAG);
        }

        static PerfTag create() {
            return new PerfTag(0, PerfTag.NULL_STRING_TAG);
        }
    }
}
