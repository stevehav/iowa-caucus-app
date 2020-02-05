package io.opencensus.internal;

import java.util.List;
import javax.annotation.Nullable;

public final class Utils {
    private Utils() {
    }

    public static void checkArgument(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static void checkState(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkIndex(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative size: " + i2);
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("Index out of bounds: size=" + i2 + ", index=" + i);
        }
    }

    public static <T> T checkNotNull(T t, @Nullable Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> void checkListElementNotNull(List<T> list, @Nullable Object obj) {
        for (T t : list) {
            if (t == null) {
                throw new NullPointerException(String.valueOf(obj));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> void checkMapElementNotNull(java.util.Map<K, V> r2, @javax.annotation.Nullable java.lang.Object r3) {
        /*
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0008:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r0 = r0.getValue()
            if (r0 == 0) goto L_0x0021
            goto L_0x0008
        L_0x0021:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.<init>(r3)
            throw r2
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.internal.Utils.checkMapElementNotNull(java.util.Map, java.lang.Object):void");
    }

    public static boolean equalsObjects(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static String format(String str, @Nullable Object... objArr) {
        int indexOf;
        if (objArr == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i2)) != -1) {
            sb.append(str, i2, indexOf);
            sb.append(objArr[i]);
            int i3 = i + 1;
            i2 = indexOf + 2;
            i = i3;
        }
        sb.append(str, i2, str.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
