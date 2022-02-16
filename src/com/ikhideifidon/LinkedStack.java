package com.ikhideifidon;


import java.util.Iterator;

/**
 * An Adapter Design Pattern for Stacks using an instance of the already
 * existing SinglyLinkedList class.
 */
public class LinkedStack<E extends Object & Comparable<E>> implements Stacks<E> {

    private final SinglyLinkedList<E> singlyLinkedList;

    public LinkedStack() {
        singlyLinkedList = new SinglyLinkedList<>();                // An empty linked list is initialized when an instance of LinkedList is created.
    }

    public LinkedStack(LinkedStack<E> that) {
        this.singlyLinkedList = new SinglyLinkedList<>(that.singlyLinkedList);
    }

    @Override
    public void push(E element) {
        singlyLinkedList.addFirst(element);
    }

    @Override
    public E pop() throws EmptyLinkedListException {
        return singlyLinkedList.removeFirst();
    }

    @Override
    public E top() throws EmptyLinkedListException {
        return singlyLinkedList.first();
    }

    @Override
    public int size() {
        return singlyLinkedList.size();
    }

    /**
     * The copy method here is equivalent to the implemented clone method.
     * @return : Stacks
     */
    @Override
    public Stacks<E> copy() {
        return new LinkedStack<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LinkedStack<?> otherLinkedStack))
            return false;
        if (otherLinkedStack.size() != this.size())
            return false;
        Iterator<?> walkB = otherLinkedStack.iterator();
        for (E e : this) {
            if (!e.equals(walkB.next()))
                return false;
        }
        return true;
    }

    /**
     * Stacks cloning using a single stack and a reverse method.
     * @return Stacks
     */
    @Override
    public Stacks<E> clone() throws CloneNotSupportedException {
        Stacks<E> clonedLinkedStack = new LinkedStack<>();
        SinglyLinkedList<E> clonedSinglyLinkedList = singlyLinkedList.clone();
        clonedSinglyLinkedList.reverse();
        while (!clonedSinglyLinkedList.isEmpty()) {
            try {
                clonedLinkedStack.push(clonedSinglyLinkedList.removeFirst());
            } catch (EmptyLinkedListException e) {
                e.printStackTrace();
            }
        }
        return clonedLinkedStack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> iter = singlyLinkedList.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append("--->");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * HashCode method with lazily initialized cached hash code
     */
    private int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = singlyLinkedList.hashCode();
            hashCode = result;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return singlyLinkedList.iterator();
    }

}
