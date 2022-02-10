package com.ikhideifidon;

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

    @Override
    public int size() {
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void enqueue(E element) {
        if (size() == data.length)
            throw new IllegalStateException("Queue is full");
        int available = (f + t) % data.length;
        data[available] = element;
        t++;
    }

    @Override
    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
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
        ArrayQueue<E> queue = new ArrayQueue<>(data.length);
        if (!isEmpty()) {
            for (E e : this) {
                queue.enqueue(e);
            }
        }
        return queue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue<E> clonedQueue = (ArrayQueue<E>) super.clone();
            clonedQueue.data = data.clone();
            return clonedQueue;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArrayQueue<?> otherArrayQueue))
            return false;
        if (otherArrayQueue.size() != size())
            return false;
        Iterator<?> walkA = this.iterator();
        Iterator<?> walkB = otherArrayQueue.iterator();
        while(walkA.hasNext()) {
            if (!walkA.next().equals(walkB.next()))
                return false;
        }
        return true;
    }

    // hashCode method with lazily initialized cached hash code
    private int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            Iterator<E> iter = this.iterator();
            while (iter.hasNext()) {
                result = 31 * result + (iter.next() == null ? 0 : iter.next().hashCode());
            }
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
                return (counter != size());
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
