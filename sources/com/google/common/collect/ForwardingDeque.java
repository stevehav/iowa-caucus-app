package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;

@GwtIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    /* access modifiers changed from: protected */
    public abstract Deque<E> delegate();

    protected ForwardingDeque() {
    }

    public void addFirst(E e) {
        delegate().addFirst(e);
    }

    public void addLast(E e) {
        delegate().addLast(e);
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public E getFirst() {
        return delegate().getFirst();
    }

    public E getLast() {
        return delegate().getLast();
    }

    @CanIgnoreReturnValue
    public boolean offerFirst(E e) {
        return delegate().offerFirst(e);
    }

    @CanIgnoreReturnValue
    public boolean offerLast(E e) {
        return delegate().offerLast(e);
    }

    public E peekFirst() {
        return delegate().peekFirst();
    }

    public E peekLast() {
        return delegate().peekLast();
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    public void push(E e) {
        delegate().push(e);
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
