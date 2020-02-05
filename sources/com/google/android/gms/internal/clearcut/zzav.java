package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzav<E> extends AbstractList<E> implements zzcn<E> {
    private boolean zzfa = true;

    zzav() {
    }

    public void add(int i, E e) {
        zzw();
        super.add(i, e);
    }

    public boolean add(E e) {
        zzw();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzw();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzw();
        return super.addAll(collection);
    }

    public void clear() {
        zzw();
        super.clear();
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

    public E remove(int i) {
        zzw();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzw();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzw();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzw();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzw();
        return super.set(i, e);
    }

    public boolean zzu() {
        return this.zzfa;
    }

    public final void zzv() {
        this.zzfa = false;
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        if (!this.zzfa) {
            throw new UnsupportedOperationException();
        }
    }
}
