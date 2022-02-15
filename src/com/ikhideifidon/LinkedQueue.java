package com.ikhideifidon;

import java.util.Iterator;

/**
 * LinkedQueue Adapter Design Pattern.
 * A class that implements Queue using SinglyLinked List as the underlying data structure.
 * This class implements the Queue interface.
 * @param <E>
 */
public class LinkedQueue<E extends Object & Comparable<E>> implements Queue<E> {

    // A non-static final class variable.
    private final SinglyLinkedList<E> singlyLinkedList;

    public LinkedQueue() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    public LinkedQueue(LinkedQueue<E> that) {
        this.singlyLinkedList = new SinglyLinkedList<>(that.singlyLinkedList);

    }

    @Override
    public int size() {
        return singlyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        singlyLinkedList.addLast(element);
    }

    @Override
    public E first() {
        return singlyLinkedList.first();
    }

    @Override
    public E dequeue() {
        return singlyLinkedList.removeFirst();
    }

    @Override
    public LinkedQueue<E> copy() {
        return new LinkedQueue<>(this);
    }

    @Override
    public Queue<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> clonedSinglyLinkedList = singlyLinkedList.clone();
        Queue<E> clonedQueue = new LinkedQueue<>();
        for (E e : clonedSinglyLinkedList)
            clonedQueue.enqueue(e);
        return clonedQueue;
    }

    @Override
    public Iterator<E> iterator() {
        return singlyLinkedList.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> iter = this.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append("<---");
        }
        sb.append("]");
        return sb.toString();
    }
}
