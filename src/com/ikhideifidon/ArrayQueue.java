package com.ikhideifidon;

/**
 * A Queue is a collection of objects that are inserted and removed according to the
 * First-In, First-Out (FIFO) principle.
 * @param <E>
 */
public class ArrayQueue<E extends Object & Comparable<E>> implements Queue<E>, Cloneable {
    private static final int CAPACITY = 10;
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

    @Override
    public Queue<E> copy() {
        ArrayQueue<E> queue = new ArrayQueue<>(data.length);
        int index = f;
        if (!isEmpty()) {
            for (int i = 0; i < size(); i++) {
                queue.enqueue(data[index]);
                index = (index + 1) % data.length;
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
        if (!(o instanceof ArrayQueue otherArrayQueue))
            return false;
        if (otherArrayQueue.size() != size())
            return false;
        ArrayQueue walkA = this.clone();
        ArrayQueue walkB = otherArrayQueue.clone();
        while(!walkA.isEmpty()) {
            if (!walkA.first().equals(walkB.first()))
                return false;
            walkA.dequeue();
            walkB.dequeue();
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        int index = f;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(data[index]);
            index = (index + 1) % data.length;
            if (i < size() - 1)
                sb.append("<----");
        }
        sb.append("]");
        return sb.toString();
    }
}
