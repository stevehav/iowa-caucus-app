package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ChannelTracer {
    static final Logger logger = Logger.getLogger(ChannelLogger.class.getName());
    private final long channelCreationTimeNanos;
    @GuardedBy("lock")
    @Nullable
    private final Collection<InternalChannelz.ChannelTrace.Event> events;
    @GuardedBy("lock")
    private int eventsLogged;
    private final Object lock = new Object();
    private final InternalLogId logId;

    static /* synthetic */ int access$008(ChannelTracer channelTracer) {
        int i = channelTracer.eventsLogged;
        channelTracer.eventsLogged = i + 1;
        return i;
    }

    ChannelTracer(InternalLogId internalLogId, final int i, long j, String str) {
        Preconditions.checkNotNull(str, "description");
        this.logId = (InternalLogId) Preconditions.checkNotNull(internalLogId, "logId");
        if (i > 0) {
            this.events = new ArrayDeque<InternalChannelz.ChannelTrace.Event>() {
                @GuardedBy("lock")
                public boolean add(InternalChannelz.ChannelTrace.Event event) {
                    if (size() == i) {
                        removeFirst();
                    }
                    ChannelTracer.access$008(ChannelTracer.this);
                    return super.add(event);
                }
            };
        } else {
            this.events = null;
        }
        this.channelCreationTimeNanos = j;
        InternalChannelz.ChannelTrace.Event.Builder builder = new InternalChannelz.ChannelTrace.Event.Builder();
        reportEvent(builder.setDescription(str + " created").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(j).build());
    }

    /* renamed from: io.grpc.internal.ChannelTracer$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity = new int[InternalChannelz.ChannelTrace.Event.Severity.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                io.grpc.InternalChannelz$ChannelTrace$Event$Severity[] r0 = io.grpc.InternalChannelz.ChannelTrace.Event.Severity.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity = r0
                int[] r0 = $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.grpc.InternalChannelz$ChannelTrace$Event$Severity r1 = io.grpc.InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity     // Catch:{ NoSuchFieldError -> 0x001f }
                io.grpc.InternalChannelz$ChannelTrace$Event$Severity r1 = io.grpc.InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ChannelTracer.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void reportEvent(InternalChannelz.ChannelTrace.Event event) {
        Level level;
        int i = AnonymousClass2.$SwitchMap$io$grpc$InternalChannelz$ChannelTrace$Event$Severity[event.severity.ordinal()];
        if (i == 1) {
            level = Level.FINE;
        } else if (i != 2) {
            level = Level.FINEST;
        } else {
            level = Level.FINER;
        }
        traceOnly(event);
        logOnly(this.logId, level, event.description);
    }

    /* access modifiers changed from: package-private */
    public boolean isTraceEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.events != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void traceOnly(InternalChannelz.ChannelTrace.Event event) {
        synchronized (this.lock) {
            if (this.events != null) {
                this.events.add(event);
            }
        }
    }

    static void logOnly(InternalLogId internalLogId, Level level, String str) {
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + internalLogId + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    /* access modifiers changed from: package-private */
    public InternalLogId getLogId() {
        return this.logId;
    }

    /* access modifiers changed from: package-private */
    public void updateBuilder(InternalChannelz.ChannelStats.Builder builder) {
        synchronized (this.lock) {
            if (this.events != null) {
                int i = this.eventsLogged;
                ArrayList arrayList = new ArrayList(this.events);
                builder.setChannelTrace(new InternalChannelz.ChannelTrace.Builder().setNumEventsLogged((long) i).setCreationTimeNanos(this.channelCreationTimeNanos).setEvents(arrayList).build());
            }
        }
    }
}
