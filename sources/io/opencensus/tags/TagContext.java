package io.opencensus.tags;

import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class TagContext {
    /* access modifiers changed from: protected */
    public abstract Iterator<Tag> getIterator();

    public String toString() {
        return "TagContext";
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TagContext)) {
            return false;
        }
        Iterator<Tag> iterator = getIterator();
        Iterator<Tag> iterator2 = ((TagContext) obj).getIterator();
        HashMap hashMap = new HashMap();
        while (iterator != null && iterator.hasNext()) {
            Tag next = iterator.next();
            if (hashMap.containsKey(next)) {
                hashMap.put(next, Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1));
            } else {
                hashMap.put(next, 1);
            }
        }
        while (iterator2 != null && iterator2.hasNext()) {
            Tag next2 = iterator2.next();
            if (!hashMap.containsKey(next2)) {
                return false;
            }
            int intValue = ((Integer) hashMap.get(next2)).intValue();
            if (intValue > 1) {
                hashMap.put(next2, Integer.valueOf(intValue - 1));
            } else {
                hashMap.remove(next2);
            }
        }
        return hashMap.isEmpty();
    }

    public final int hashCode() {
        Iterator<Tag> iterator = getIterator();
        int i = 0;
        if (iterator == null) {
            return 0;
        }
        while (iterator.hasNext()) {
            Tag next = iterator.next();
            if (next != null) {
                i += next.hashCode();
            }
        }
        return i;
    }
}
