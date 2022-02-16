package com.ikhideifidon;

public interface Queue<E extends Comparable<E>> extends Iterable<E>, Cloneable {
    /** Returns the number of elements in the queue. */
    int size();

    /** Inserts an element at the rear of the queue. */
    void enqueue(E element);

    /** Returns, but does not remove the first element of the queue (null if empty). */
    E first() throws EmptyArrayQueueException, EmptyLinkedListException;

    /** Removes and return the first element of the queue (null if empty). */
    E dequeue() throws EmptyArrayQueueException, EmptyLinkedListException;

    /** Returns a copy of the queue (null if empty). */
    Queue<E> copy();

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

    /** Tests whether the queue is empty. */
    default boolean isEmpty() {
        return size() == 0;
    }

    default boolean containsAll(Queue<E> queueCollection) {
        if (queueCollection.size() > size())
            return false;
        for (E e : queueCollection) {
            if (!contains(e))
                return false;
        }
        return true;
    }

    // Objects methods
    /** Returns a cloned copy of the queue (null if empty). */
    Queue<E> clone() throws CloneNotSupportedException;

    /** Tests for equality of two queues. */
    boolean equals(Object o);

    /** HashCode implementation */
    int hashCode();

    /** String representation of queue. */
    String toString();

}
