package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;
import javax.annotation.Nullable;

@ThreadSafe
public class BucketMap<T> {
    @VisibleForTesting
    @Nullable
    LinkedEntry<T> mHead;
    protected final SparseArray<LinkedEntry<T>> mMap = new SparseArray<>();
    @VisibleForTesting
    @Nullable
    LinkedEntry<T> mTail;

    @VisibleForTesting
    static class LinkedEntry<I> {
        int key;
        @Nullable
        LinkedEntry<I> next;
        @Nullable
        LinkedEntry<I> prev;
        LinkedList<I> value;

        private LinkedEntry(@Nullable LinkedEntry<I> linkedEntry, int i, LinkedList<I> linkedList, @Nullable LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }
    }

    @Nullable
    public synchronized T acquire(int i) {
        LinkedEntry linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            return null;
        }
        T pollFirst = linkedEntry.value.pollFirst();
        moveToFront(linkedEntry);
        return pollFirst;
    }

    public synchronized void release(int i, T t) {
        LinkedEntry linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry((LinkedEntry) null, i, new LinkedList(), (LinkedEntry) null);
            this.mMap.put(i, linkedEntry);
        }
        linkedEntry.value.addLast(t);
        moveToFront(linkedEntry);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized int valueCount() {
        int i;
        i = 0;
        for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
            if (linkedEntry.value != null) {
                i += linkedEntry.value.size();
            }
        }
        return i;
    }

    private synchronized void prune(LinkedEntry<T> linkedEntry) {
        LinkedEntry<I> linkedEntry2 = linkedEntry.prev;
        LinkedEntry<I> linkedEntry3 = linkedEntry.next;
        if (linkedEntry2 != null) {
            linkedEntry2.next = linkedEntry3;
        }
        if (linkedEntry3 != null) {
            linkedEntry3.prev = linkedEntry2;
        }
        linkedEntry.prev = null;
        linkedEntry.next = null;
        if (linkedEntry == this.mHead) {
            this.mHead = linkedEntry3;
        }
        if (linkedEntry == this.mTail) {
            this.mTail = linkedEntry2;
        }
    }

    private void moveToFront(LinkedEntry<T> linkedEntry) {
        if (this.mHead != linkedEntry) {
            prune(linkedEntry);
            LinkedEntry<T> linkedEntry2 = this.mHead;
            if (linkedEntry2 == null) {
                this.mHead = linkedEntry;
                this.mTail = linkedEntry;
                return;
            }
            linkedEntry.next = linkedEntry2;
            linkedEntry2.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    @Nullable
    public synchronized T removeFromEnd() {
        LinkedEntry<T> linkedEntry = this.mTail;
        if (linkedEntry == null) {
            return null;
        }
        T pollLast = linkedEntry.value.pollLast();
        maybePrune(linkedEntry);
        return pollLast;
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        if (linkedEntry != null && linkedEntry.value.isEmpty()) {
            prune(linkedEntry);
            this.mMap.remove(linkedEntry.key);
        }
    }
}
