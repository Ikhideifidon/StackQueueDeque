package com.ikhideifidon;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E extends Comparable<E>> implements Iterable<E>, Cloneable {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E value = current.data;
                current = current.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) { this.data = data; }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public SinglyLinkedList() {                    // constructs an initially empty linkedList.
        head = null;
        tail = null;
        currentSize = 0;
    }

    public SinglyLinkedList(SinglyLinkedList<E> singlyLinkedList) {
        this.head = singlyLinkedList.head;
        this.tail = singlyLinkedList.tail;
        this.currentSize = singlyLinkedList.currentSize;
        this.hashCode = singlyLinkedList.hashCode;
    }


    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public E first() throws EmptyLinkedListException{
        if (isEmpty())
            throw new EmptyLinkedListException();
        return head.data;
    }

    public E last() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException();
        return tail.data;
    }

    // update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (currentSize == 0)
            tail = head;
        currentSize++;
    }


    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.next = newest;
        tail = newest;
        currentSize++;
    }

    public E removeFirst() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException();
        E answer = head.data;
        head = head.next;
        currentSize--;
        if (currentSize == 0)
            tail = null;
        return answer;
    }

    public E removeLast() throws EmptyLinkedListException {
        if (isEmpty())
            throw new EmptyLinkedListException();
        if (head == tail)
            return removeFirst();
        Node<E> current = head;
        Node<E> previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    /**
     * This method attempts to remove and return a given data if present in the SinglyLinkedList.
     * A null value is returned if the given data is not found in the SinglyLinkedList.
     * @param obj : The data to be removed
     * @return : The removed data.
     * @throws : EmptyLinkedListException
     */
    public E tryRemove(E obj) throws EmptyLinkedListException {                                        // Natural Ordering
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            if (obj.compareTo(current.data) == 0) {
                // (obj.equals(current.data)) will not always yield the same result.
                if (current == head)
                    return removeFirst();
                if (current == tail)
                    return removeLast();
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    /**
     * The remove method removes and return the given data if present, otherwise a
     * NoSuchElementException is thrown
     * @param obj : The data to be removed
     * @param cmp : The Comparator to be applied.
     * @return : The removed data.
     * @throws : EmptyLinkedListException
     */

    public E remove(E obj, Comparator<? super E> cmp) throws EmptyLinkedListException {            // Unnatural Ordering
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            if (cmp.compare(current.data, obj) == 0) {
                if (current == head)
                    return removeFirst();
                if (current == tail)
                    return removeLast();
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        throw new NoSuchElementException();
    }

    public E remove(E obj) throws EmptyLinkedListException {                                        // Natural Ordering
        E result = tryRemove(obj);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    public void reverse() {
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            Node<E> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public SinglyLinkedList<E> copy() {
        return new SinglyLinkedList<>(this);
    }

    /**
     * This gives a reversed sample of the LinkedList
     */
    public SinglyLinkedList<E> reversed() throws CloneNotSupportedException {
        SinglyLinkedList<E> copied = this.clone();
        copied.reverse();
        return copied;

    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.data);
            // This prevents the trailing delimiter.
            if (current.next != null)
                sb.append("-->");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (currentSize > 0) {
            other.head = new Node<>(head.data, null);
            Node<E> walk = head.next;
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.data, null);
                otherTail.next = newest;
                otherTail = newest;
                walk = walk.next;
            }

        }
        return other;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof SinglyLinkedList<?> other) {
            if (this.currentSize != other.currentSize)
                return false;
            Node<?> walkA = head;
            Node<?> walkB = other.head;
            while (walkA != null) {
                if (!walkA.data.equals(walkB.next))           //mismatch
                    return false;
                walkA = walkA.next;
                walkB = walkB.next;
            }
            return true;
        }
        return false;
    }

    private int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            Node<E> current = head;
            while (current != null) {
                result = 31 * result + (current.next == null ? 0 : current.next.hashCode());
                current = current.next;
            }
            hashCode = result;
        }
        return result;
    }

    public boolean addAll(SinglyLinkedList<E> listCollection) {
        if (listCollection.isEmpty())
            return false;
        Node<E> current = listCollection.head;
        while (current != null) {
            Node<E> newest = new Node<>(current.data);
            tail.next = newest;
            tail = newest;
            currentSize++;
            current = current.next;
        }
        return true;
    }
}