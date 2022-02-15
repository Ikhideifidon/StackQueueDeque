package com.ikhideifidon;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Stack Abstract Data Type using Array as the underlying Data Structure.
 * A Stack is a collection of objects that are inserted and removed according to the Last-In,
 * First-Out (LIFO) principle.
 */
public class ArrayStack<E extends Object & Comparable<E>> implements Stacks<E> {

    public static final int CAPACITY = 1000;            // Default array capacity.
    private E[] data;                                   // Generic array used for storage.
    private int t = 0;                                  // Index of the top element in stack.

    public ArrayStack() { this(CAPACITY); }             // Constructs stack with default capacity

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {                   // Constructs stack with given capacity
        data = (E[]) new Object[capacity];
    }

    public ArrayStack(ArrayStack<E> that) {
        this.t = that.t;
        this.data = Arrays.copyOf(that.data, that.data.length);
    }

    @Override
    public int size() { return t; }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() >= data.length)
            throw new IllegalStateException("Stack is full");
        data[t] = element;
        t++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        t--;
        E answer = data[t];
        data[t] = null;
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
                return index >= 0;
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
    public boolean equals(Object o) {
        if (o == this)              // If they point to the same object return true.
            return true;
        if (!(o instanceof ArrayStack<?> otherArrayStack))
            return false;
        if (this.size() != otherArrayStack.size())
            return false;
        for (int i = size() - 1; i >= 0; i--) {
            if (!this.data[i].equals(otherArrayStack.data[i]))
                return false;
        }
        return true;
    }

    // hashCode method with lazily initialized cached hash code
    private int hashCode;                   // Automatically initialized to 0
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            for (int i = 0; i < size(); i++)
                result = 31 * result + (data[i] == null ? 0 : data[i].hashCode());
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
    public Stacks<E> clone() throws CloneNotSupportedException {
        ArrayStack<E> result = (ArrayStack<E>) super.clone();
        result.data = data.clone();
        return result;
    }

    public Stacks<E> copy() {
        return new ArrayStack<>(this);
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

}
