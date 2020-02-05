package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class AtomicBackoff {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(AtomicBackoff.class.getName());
    /* access modifiers changed from: private */
    public final String name;
    /* access modifiers changed from: private */
    public final AtomicLong value = new AtomicLong();

    public AtomicBackoff(String str, long j) {
        Preconditions.checkArgument(j > 0, "value must be positive");
        this.name = str;
        this.value.set(j);
    }

    public State getState() {
        return new State(this.value.get());
    }

    @ThreadSafe
    public final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long savedValue;

        static {
            Class<AtomicBackoff> cls = AtomicBackoff.class;
        }

        private State(long j) {
            this.savedValue = j;
        }

        public long get() {
            return this.savedValue;
        }

        public void backoff() {
            long j = this.savedValue;
            long max = Math.max(2 * j, j);
            if (AtomicBackoff.this.value.compareAndSet(this.savedValue, max)) {
                AtomicBackoff.log.log(Level.WARNING, "Increased {0} to {1}", new Object[]{AtomicBackoff.this.name, Long.valueOf(max)});
            }
        }
    }
}
