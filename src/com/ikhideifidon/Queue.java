package com.ikhideifidon;

import java.util.Iterator;

public class Queue<E extends Object & Comparable<E>> implements AbstractCollections<E> {
    @Override
    public void push(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pop() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E top() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractCollections<E> copy() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractCollections<E> clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
