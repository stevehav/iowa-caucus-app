package io.sentry.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, Serializable {
    private static final long serialVersionUID = -8423413834657610406L;
    /* access modifiers changed from: private */
    public transient E[] elements;
    /* access modifiers changed from: private */
    public transient int end;
    /* access modifiers changed from: private */
    public transient boolean full;
    /* access modifiers changed from: private */
    public final int maxElements;
    /* access modifiers changed from: private */
    public transient int start;

    public boolean isFull() {
        return false;
    }

    public CircularFifoQueue() {
        this(32);
    }

    public CircularFifoQueue(int i) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i > 0) {
            this.elements = (Object[]) new Object[i];
            this.maxElements = this.elements.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    public CircularFifoQueue(Collection<? extends E> collection) {
        this(collection.size());
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.elements = (Object[]) new Object[this.maxElements];
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            this.elements[i] = objectInputStream.readObject();
        }
        this.start = 0;
        this.full = readInt == this.maxElements;
        if (this.full) {
            this.end = 0;
        } else {
            this.end = readInt;
        }
    }

    public int size() {
        int i = this.end;
        int i2 = this.start;
        if (i < i2) {
            return (this.maxElements - i2) + i;
        }
        if (i != i2) {
            return i - i2;
        }
        if (this.full) {
            return this.maxElements;
        }
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isAtFullCapacity() {
        return size() == this.maxElements;
    }

    public int maxSize() {
        return this.maxElements;
    }

    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    public boolean add(E e) {
        if (e != null) {
            if (isAtFullCapacity()) {
                remove();
            }
            E[] eArr = this.elements;
            int i = this.end;
            this.end = i + 1;
            eArr[i] = e;
            if (this.end >= this.maxElements) {
                this.end = 0;
            }
            if (this.end == this.start) {
                this.full = true;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to queue");
    }

    public E get(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", new Object[]{Integer.valueOf(i), Integer.valueOf(size)}));
        }
        return this.elements[(this.start + i) % this.maxElements];
    }

    public boolean offer(E e) {
        return add(e);
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[this.start];
    }

    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.elements;
            int i = this.start;
            E e = eArr[i];
            if (e != null) {
                this.start = i + 1;
                eArr[i] = null;
                if (this.start >= this.maxElements) {
                    this.start = 0;
                }
                this.full = false;
            }
            return e;
        }
        throw new NoSuchElementException("queue is empty");
    }

    /* access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.maxElements) {
            return 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.maxElements - 1 : i2;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = CircularFifoQueue.this.start;
            private boolean isFirst = CircularFifoQueue.this.full;
            private int lastReturnedIndex = -1;

            public boolean hasNext() {
                return this.isFirst || this.index != CircularFifoQueue.this.end;
            }

            public E next() {
                if (hasNext()) {
                    this.isFirst = false;
                    int i = this.index;
                    this.lastReturnedIndex = i;
                    this.index = CircularFifoQueue.this.increment(i);
                    return CircularFifoQueue.this.elements[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i = this.lastReturnedIndex;
                if (i == -1) {
                    throw new IllegalStateException();
                } else if (i == CircularFifoQueue.this.start) {
                    CircularFifoQueue.this.remove();
                    this.lastReturnedIndex = -1;
                } else {
                    int i2 = this.lastReturnedIndex + 1;
                    if (CircularFifoQueue.this.start >= this.lastReturnedIndex || i2 >= CircularFifoQueue.this.end) {
                        while (i2 != CircularFifoQueue.this.end) {
                            if (i2 >= CircularFifoQueue.this.maxElements) {
                                CircularFifoQueue.this.elements[i2 - 1] = CircularFifoQueue.this.elements[0];
                                i2 = 0;
                            } else {
                                CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(i2)] = CircularFifoQueue.this.elements[i2];
                                i2 = CircularFifoQueue.this.increment(i2);
                            }
                        }
                    } else {
                        System.arraycopy(CircularFifoQueue.this.elements, i2, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - i2);
                    }
                    this.lastReturnedIndex = -1;
                    CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                    int unused = circularFifoQueue.end = circularFifoQueue.decrement(circularFifoQueue.end);
                    CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
                    boolean unused2 = CircularFifoQueue.this.full = false;
                    this.index = CircularFifoQueue.this.decrement(this.index);
                }
            }
        };
    }
}
