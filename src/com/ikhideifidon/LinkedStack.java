package com.ikhideifidon;


import java.util.Iterator;
import java.util.LinkedList;

import com.ikhideifidon.SinglyLinkedList;

public class LinkedStack<E extends Object & Comparable<E>> implements AbstractCollections<E> {
    /**
     * An Adapter Design Pattern for Stacks using an instance of the already
     * existing SinglyLinkedList class.
     */
    private SinglyLinkedList<E> singlyLinkedList;

    public LinkedStack() {
        singlyLinkedList = new SinglyLinkedList<>();                // An empty linked list is initialized when an instance of LinkedList is created.
    }

    @Override
    public void push(E element) {
        singlyLinkedList.addFirst(element);
    }

    @Override
    public E pop() {
        return singlyLinkedList.removeFirst();
    }

    @Override
    public E top() {
        return singlyLinkedList.first();
    }

    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    @Override
    public int size() {
        return singlyLinkedList.size();
    }

    @Override
    public AbstractCollections<E> copy() {
        return null;
    }

    @Override
    public AbstractCollections<E> clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
