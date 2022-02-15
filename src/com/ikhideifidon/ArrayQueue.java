package com.ikhideifidon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Queue is a collection of objects that are inserted and removed according to the
 * First-In, First-Out (FIFO) principle.
 * @param <E>
 */
public class ArrayQueue<E extends Object & Comparable<E>> implements Queue<E> {
    private static final int CAPACITY = 100;
    private E[] data;                       // A mutable Generic array used for storage
    private int f = 0;                      // index of the front element
    private int t = 0;                      // number of elements in the queue.

    public ArrayQueue() { this(CAPACITY); }         // The 'this' keyword calls the constructor below it and set the capacity to the default value
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayQueue(ArrayQueue<E> that) {
        this.f = that.f;
        this.t = that.t;
        this.data = Arrays.copyOf(that.data, that.data.length);
    }

    @Override
    public int size() {
        return t;
    }

    @Override
    public void enqueue(E element) {
        if (size() >= data.length)
            throw new IllegalStateException("Queue is full");
        int available = (f + t) % data.length;
        data[available] = element;
        t++;
    }

    @Override
    public E first() throws EmptyArrayQueueException {
        if (isEmpty())
            throw new EmptyArrayQueueException();
        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new NullPointerException();
        E answer = data[f];
        data[f] = null;                         // Java garbage collection.
        f = (f + 1) % data.length;
        t--;
        return answer;
    }

    /**
     * The copy method converts the circular array queue to linearised array queue.
     * The return value of this method initializes the private f variable to zero.
     * @return : Queue
     */
    @Override
    public Queue<E> copy() {
        return new ArrayQueue<>(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayQueue<E> clone() throws CloneNotSupportedException {
        ArrayQueue<E> clonedQueue = (ArrayQueue<E>) super.clone();
        clonedQueue.data = data.clone();
        return clonedQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArrayQueue<?> otherArrayQueue))
            return false;
        if (otherArrayQueue.size() != size())
            return false;
        Iterator<?> walkB = otherArrayQueue.iterator();
        for (E e : this) {
            if (!e.equals(walkB.next()))
                return false;
        }
        return true;
    }

    /**
     * HashCode method with lazily initialized cached hash code
     */
    private int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            for (E e : this)
                result = 31 * result + (e == null ? 0 : e.hashCode());
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> iter = this.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append("<----");
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = f;
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter != size();
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                counter++;
                E answer = data[index];
                index = (index + 1) % data.length;
                return answer;
            }
        };
    }
}
