package com.ikhideifidon;

import java.util.Iterator;

public class Queue<E extends Object & Comparable<E>> implements AbstractCollections<E> {
    @Override
    public void push(E element) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public AbstractCollections<E> cloned() {
        return null;
    }

    @Override
    public AbstractCollections<E> clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
