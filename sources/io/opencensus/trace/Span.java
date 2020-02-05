package io.opencensus.trace;

import androidx.core.app.NotificationCompat;
import io.opencensus.internal.Utils;
import io.opencensus.trace.internal.BaseMessageEventUtils;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public abstract class Span {
    private static final Set<Options> DEFAULT_OPTIONS = Collections.unmodifiableSet(EnumSet.noneOf(Options.class));
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();
    private final SpanContext context;
    private final Set<Options> options;

    public enum Kind {
        SERVER,
        CLIENT
    }

    public enum Options {
        RECORD_EVENTS
    }

    public abstract void addAnnotation(Annotation annotation);

    public abstract void addAnnotation(String str, Map<String, AttributeValue> map);

    public abstract void addLink(Link link);

    public abstract void end(EndSpanOptions endSpanOptions);

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.EnumSet<io.opencensus.trace.Span$Options>, java.util.EnumSet] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected Span(io.opencensus.trace.SpanContext r2, @javax.annotation.Nullable java.util.EnumSet<io.opencensus.trace.Span.Options> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "context"
            java.lang.Object r0 = io.opencensus.internal.Utils.checkNotNull(r2, r0)
            io.opencensus.trace.SpanContext r0 = (io.opencensus.trace.SpanContext) r0
            r1.context = r0
            if (r3 != 0) goto L_0x0012
            java.util.Set<io.opencensus.trace.Span$Options> r3 = DEFAULT_OPTIONS
            goto L_0x001a
        L_0x0012:
            java.util.EnumSet r3 = java.util.EnumSet.copyOf(r3)
            java.util.Set r3 = java.util.Collections.unmodifiableSet(r3)
        L_0x001a:
            r1.options = r3
            io.opencensus.trace.TraceOptions r2 = r2.getTraceOptions()
            boolean r2 = r2.isSampled()
            if (r2 == 0) goto L_0x0033
            java.util.Set<io.opencensus.trace.Span$Options> r2 = r1.options
            io.opencensus.trace.Span$Options r3 = io.opencensus.trace.Span.Options.RECORD_EVENTS
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = 0
            goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            java.lang.String r3 = "Span is sampled, but does not have RECORD_EVENTS set."
            io.opencensus.internal.Utils.checkArgument(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.Span.<init>(io.opencensus.trace.SpanContext, java.util.EnumSet):void");
    }

    public void putAttribute(String str, AttributeValue attributeValue) {
        Utils.checkNotNull(str, "key");
        Utils.checkNotNull(attributeValue, "value");
        putAttributes(Collections.singletonMap(str, attributeValue));
    }

    public void putAttributes(Map<String, AttributeValue> map) {
        Utils.checkNotNull(map, "attributes");
        addAttributes(map);
    }

    @Deprecated
    public void addAttributes(Map<String, AttributeValue> map) {
        putAttributes(map);
    }

    public final void addAnnotation(String str) {
        Utils.checkNotNull(str, "description");
        addAnnotation(str, EMPTY_ATTRIBUTES);
    }

    @Deprecated
    public void addNetworkEvent(NetworkEvent networkEvent) {
        addMessageEvent(BaseMessageEventUtils.asMessageEvent(networkEvent));
    }

    public void addMessageEvent(MessageEvent messageEvent) {
        Utils.checkNotNull(messageEvent, "messageEvent");
        addNetworkEvent(BaseMessageEventUtils.asNetworkEvent(messageEvent));
    }

    public void setStatus(Status status) {
        Utils.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
    }

    public final void end() {
        end(EndSpanOptions.DEFAULT);
    }

    public final SpanContext getContext() {
        return this.context;
    }

    public final Set<Options> getOptions() {
        return this.options;
    }
}
