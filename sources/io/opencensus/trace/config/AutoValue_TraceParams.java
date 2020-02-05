package io.opencensus.trace.config;

import io.opencensus.trace.Sampler;
import io.opencensus.trace.config.TraceParams;

final class AutoValue_TraceParams extends TraceParams {
    private final int maxNumberOfAnnotations;
    private final int maxNumberOfAttributes;
    private final int maxNumberOfLinks;
    private final int maxNumberOfMessageEvents;
    private final Sampler sampler;

    private AutoValue_TraceParams(Sampler sampler2, int i, int i2, int i3, int i4) {
        this.sampler = sampler2;
        this.maxNumberOfAttributes = i;
        this.maxNumberOfAnnotations = i2;
        this.maxNumberOfMessageEvents = i3;
        this.maxNumberOfLinks = i4;
    }

    public Sampler getSampler() {
        return this.sampler;
    }

    public int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    public int getMaxNumberOfAnnotations() {
        return this.maxNumberOfAnnotations;
    }

    public int getMaxNumberOfMessageEvents() {
        return this.maxNumberOfMessageEvents;
    }

    public int getMaxNumberOfLinks() {
        return this.maxNumberOfLinks;
    }

    public String toString() {
        return "TraceParams{sampler=" + this.sampler + ", maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxNumberOfAnnotations=" + this.maxNumberOfAnnotations + ", maxNumberOfMessageEvents=" + this.maxNumberOfMessageEvents + ", maxNumberOfLinks=" + this.maxNumberOfLinks + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceParams)) {
            return false;
        }
        TraceParams traceParams = (TraceParams) obj;
        if (this.sampler.equals(traceParams.getSampler()) && this.maxNumberOfAttributes == traceParams.getMaxNumberOfAttributes() && this.maxNumberOfAnnotations == traceParams.getMaxNumberOfAnnotations() && this.maxNumberOfMessageEvents == traceParams.getMaxNumberOfMessageEvents() && this.maxNumberOfLinks == traceParams.getMaxNumberOfLinks()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.sampler.hashCode() ^ 1000003) * 1000003) ^ this.maxNumberOfAttributes) * 1000003) ^ this.maxNumberOfAnnotations) * 1000003) ^ this.maxNumberOfMessageEvents) * 1000003) ^ this.maxNumberOfLinks;
    }

    public TraceParams.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends TraceParams.Builder {
        private Integer maxNumberOfAnnotations;
        private Integer maxNumberOfAttributes;
        private Integer maxNumberOfLinks;
        private Integer maxNumberOfMessageEvents;
        private Sampler sampler;

        Builder() {
        }

        private Builder(TraceParams traceParams) {
            this.sampler = traceParams.getSampler();
            this.maxNumberOfAttributes = Integer.valueOf(traceParams.getMaxNumberOfAttributes());
            this.maxNumberOfAnnotations = Integer.valueOf(traceParams.getMaxNumberOfAnnotations());
            this.maxNumberOfMessageEvents = Integer.valueOf(traceParams.getMaxNumberOfMessageEvents());
            this.maxNumberOfLinks = Integer.valueOf(traceParams.getMaxNumberOfLinks());
        }

        public TraceParams.Builder setSampler(Sampler sampler2) {
            if (sampler2 != null) {
                this.sampler = sampler2;
                return this;
            }
            throw new NullPointerException("Null sampler");
        }

        public TraceParams.Builder setMaxNumberOfAttributes(int i) {
            this.maxNumberOfAttributes = Integer.valueOf(i);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfAnnotations(int i) {
            this.maxNumberOfAnnotations = Integer.valueOf(i);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfMessageEvents(int i) {
            this.maxNumberOfMessageEvents = Integer.valueOf(i);
            return this;
        }

        public TraceParams.Builder setMaxNumberOfLinks(int i) {
            this.maxNumberOfLinks = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public TraceParams autoBuild() {
            String str = "";
            if (this.sampler == null) {
                str = str + " sampler";
            }
            if (this.maxNumberOfAttributes == null) {
                str = str + " maxNumberOfAttributes";
            }
            if (this.maxNumberOfAnnotations == null) {
                str = str + " maxNumberOfAnnotations";
            }
            if (this.maxNumberOfMessageEvents == null) {
                str = str + " maxNumberOfMessageEvents";
            }
            if (this.maxNumberOfLinks == null) {
                str = str + " maxNumberOfLinks";
            }
            if (str.isEmpty()) {
                return new AutoValue_TraceParams(this.sampler, this.maxNumberOfAttributes.intValue(), this.maxNumberOfAnnotations.intValue(), this.maxNumberOfMessageEvents.intValue(), this.maxNumberOfLinks.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
