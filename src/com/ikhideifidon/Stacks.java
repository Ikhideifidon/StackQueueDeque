package com.ikhideifidon;

/**
 * This is an interface that provides abstract methods for the Stacks, Queues and Deques
 * Abstract Data Types.
 */
public interface Stacks<E> extends Iterable<E>, Cloneable {
    /**
     * Adds element e to the top of the collection.
     */
    void push(E element);

    /**
     * Removes and returns the top element from the collection
     * or null if the collection is empty.
     */
    E pop();

    /** Returns the top element of the collection, without removing it
     * or null if the stack is empty.
     */
    E top();

    boolean isEmpty();

    /**
     * Returns the number of elements in the collection.
     */
    int size();

    Stacks<E> copy();

    boolean equals(Object o);

    Stacks<E> clone() throws CloneNotSupportedException;

    String toString();

    int hashCode();
}
