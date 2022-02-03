package com.ikhideifidon;

public interface AbstractCollections<E> extends Iterable<E>, Cloneable {
    /**
     * This is an interface that provides abstract methods for the Stacks, Queues and Deques
     * Abstract Data Types.
     */
    void push(E element );
    /**
     * Adds element e to the top of the collection.
     */

    E pop();
    /**
     * Removes and returns the top element from the collection
     * or null if the collection is empty.
     */

    E top();
    /** Returns the top element of the collection, without removing it
     * or null if the stack is empty.
     */

    boolean isEmpty();

    int size();
    /**
     * Returns the number of elements in the collection.
     */

    boolean equals(Object o);

    AbstractCollections<E> cloned();

    AbstractCollections<E> clone() throws CloneNotSupportedException;

}
