package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
    @NullableDecl
    @CanIgnoreReturnValue
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @NullableDecl
    @CanIgnoreReturnValue
    V put(@NullableDecl K k, @NullableDecl V v);

    void putAll(Map<? extends K, ? extends V> map);

    Set<V> values();
}
