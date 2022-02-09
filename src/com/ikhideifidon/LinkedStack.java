package com.ikhideifidon;


import java.util.Iterator;


public class LinkedStack<E extends Object & Comparable<E>> implements Stacks<E> {
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
    public int size() {
        return singlyLinkedList.size();
    }

    @Override
    public Stacks<E> copy() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LinkedStack otherLinkedStack))
            return false;
        if (otherLinkedStack.size() != this.size())
            return false;
        Stacks walkA = this.clone();
        Stacks walkB = otherLinkedStack.clone();
        while (!walkA.isEmpty()) {
            if (!walkA.pop().equals(walkB.pop()))
                return false;
        }
        return true;
    }

    /**
     * Stacks cloning using two stacks
     * @return Stacks
     */
    @Override
    public Stacks<E> clone() {
        Stacks<E> clonedLinkedStack = new LinkedStack<>();
        Stacks<E> temporaryLinkedStack = new LinkedStack<>();
        try {
            SinglyLinkedList<E> clonedSinglyLinkedList = singlyLinkedList.clone();
            while (!clonedSinglyLinkedList.isEmpty())
                temporaryLinkedStack.push(clonedSinglyLinkedList.removeFirst());

            while (!temporaryLinkedStack.isEmpty())
                clonedLinkedStack.push(temporaryLinkedStack.pop());
            return clonedLinkedStack;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Object not Cloneable");
        }
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Stacks<E> temporaryStack = this.clone();
        while (!temporaryStack.isEmpty()) {
            sb.append(temporaryStack.pop());
            if (temporaryStack.top() != null)
                sb.append("--->");
        }
        sb.append("]");
        return sb.toString();
    }

    // hashCode method with lazily initialized cached hash code
    private int hashCode;
    @Override
    public int hashCode() {
        Stacks<E> clonedStack = this.clone();
        int result = hashCode;
        if (result == 0) {
            while (!clonedStack.isEmpty()) {
                result = 31 * result + (clonedStack.top() == null ? 0 : clonedStack.top().hashCode());
                clonedStack.pop();
            }
            hashCode = result;
        }
        return result;
    }

}
