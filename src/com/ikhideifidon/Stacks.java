package com.ikhideifidon;

/**
 * This is an interface that provides abstract methods for the Stacks, Queues and Deques
 * Abstract Data Types.
 */
public interface Stacks<E extends Comparable<E>> extends Iterable<E>, Cloneable {
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

    /**
     * Returns the number of elements in the collection.
     */
    int size();

    Stacks<E> copy() throws CloneNotSupportedException;

    boolean equals(Object o);

    Stacks<E> clone() throws CloneNotSupportedException;

    String toString();

    int hashCode();

    default boolean isEmpty() { return size() == 0;}

    default boolean contains(E element) {
        if (element == null) {
            for (E e : this) {
                if (e == null)
                    return true;
            }
        } else {
            for (E e : this) {
                if (e.compareTo(element) == 0)
                    return true;
            }
        }
        return false;
    }

    default boolean containsAll(Stacks<E> queueCollection) {
        if (queueCollection.size() > size())
            return false;
        for (E e : queueCollection) {
            if (!contains(e))
                return false;
        }
        return true;
    }

}
