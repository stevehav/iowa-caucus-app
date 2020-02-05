package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzef<E> extends AbstractList<E> implements zzge<E> {
    private boolean zzrl = true;

    zzef() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzcj();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzcj();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzcj();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzcj();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzcj();
        super.clear();
    }

    public boolean zzch() {
        return this.zzrl;
    }

    public final void zzci() {
        this.zzrl = false;
    }

    public E remove(int i) {
        zzcj();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzcj();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzcj();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzcj();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzcj();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzcj() {
        if (!this.zzrl) {
            throw new UnsupportedOperationException();
        }
    }
}
