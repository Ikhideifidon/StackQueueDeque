package com.ikhideifidon;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E extends Object & Comparable<E>> implements AbstractCollections<E> {
    /**
     * The Stack Abstract Data Type using Array as the underlying Data Structure.
     * A Stack is a collection of objects that are inserted and removed according to the Last-In,
     * First-Out (LIFO) principle.
     */
    public static final int CAPACITY = 1000;            // Default array capacity.
    private E[] data;                                   // Generic array used for storage.
    private int t = 0;                                  // Index of the top element in stack.

    public ArrayStack() { this(CAPACITY); }             // Constructs stack with default capacity

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {                   // Constructs stack with given capacity
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() { return t; }

    @Override
    public boolean isEmpty() { return t == 0;}

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[t] = element;
        t++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E answer = data[t-1];
        data[t-1] = null;
        t--;
        return answer;
    }

    @Override
    public E top() {
        if (isEmpty())
            throw new EmptyStackException();
        return data[t-1];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = size() - 1;                 // index is equal to the element on top of the stack.
            @Override
            public boolean hasNext() {
                return (index >= 0);
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E value = data[index];
                index--;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int index = t - 1;
        while (index >= 0) {
            sb.append(data[index]);
            if (index > 0)
                sb.append("---");
            index--;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)              // If they point to the same object return true.
            return true;
        if (!(o instanceof ArrayStack otherArrayStack))
            return false;
        if (this.size() != otherArrayStack.size())
            return false;
        int i = size() - 1;
        while (i >= 0) {
            if (!this.data[i].equals(otherArrayStack.data[i]))
                return false;
            i--;
        }
        return true;
    }

    /**
    public int hashCode() {
        int result = 1;

        for (Object element : data)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
    }
    */

    // hashCode method with lazily initialized cached hash code
    private int hashCode;                   // Automatically initialized to 0
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            for (Object element : data)
                result = 31 * result + (element == null ? 0 : element.hashCode());
            hashCode = result;
        }
        return result;
    }

    /**
     * Clone method for class with references to mutable state.
     * Its mutability comes from the nonfinal class and its nonfinal fields.
     */
    @Override
    @SuppressWarnings("unchecked")
    public AbstractCollections<E> clone() {
        try {
            ArrayStack<E> result = (ArrayStack<E>) super.clone();
            result.data = data.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public AbstractCollections<E> copy() {
        AbstractCollections<E> other = new ArrayStack<>();
        if (!isEmpty()) {
            int index = 0;
            while (index < size()) {
                other.push(data[index]);
                index++;
            }
        }
        return other;
    }


}
