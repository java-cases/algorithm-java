package com.algorithm.linked;

import java.util.NoSuchElementException;

public class LinkedList<E> {

    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && getLast == null) ||
     * (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to getLast node.
     * Invariant: (first == null && getLast == null) ||
     * (getLast.link == null && getLast.item != null)
     */
    transient Node<E> last;

    public LinkedList() {
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(E element) {
        linkLast(element);
        return true;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    /**
     * Inserts the specified element at the beginning of this linkedleetcode.
     *
     * @param element the element to add
     */
    public void addFirst(E element) {
        linkFirst(element);
    }

    /**
     * Appends the specified element to the end of this linkedleetcode.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param element the element to add
     */
    public void addLast(E element) {
        linkLast(element);
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();

        return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();

        return l.item;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        int index = 0;

        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }

        return -1;
    }

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;

            for (int i = 0; i < index; i++) {
                x = x.next;
            }

            return x;
        } else {
            Node<E> x = last;

            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }

            return x;
        }
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);

        E oldVal = x.item;
        x.item = element;

        return oldVal;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }

        first = last = null;
        size = 0;
    }

    public E remove() {
        return removeFirst();
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();

        return unlinkFirst(f);
    }

    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();

        return unlinkLast(l);
    }

    /**
     * Links element as first element.
     */
    private void linkFirst(E element) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, element, f);
        first = newNode;

        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }

        size++;
    }

    /**
     * Links element as getLast element.
     */
    void linkLast(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    /**
     * Inserts element element before non-null Node succ.
     */
    void linkBefore(E element, Node<E> succ) {
        // assert succ != null;

        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, element, succ);
        succ.prev = newNode;

        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }

        size++;
    }

    /**
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;

        final E element = f.item;
        final Node<E> next = f.next;

        f.item = null;
        f.next = null; // help GC
        first = next;

        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;
        return element;
    }

    /**
     * Unlinks non-null getLast node l.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == getLast && l != null;

        final E element = l.item;
        final Node<E> prev = l.prev;

        l.item = null;
        l.prev = null; // help GC
        last = prev;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;
        return element;
    }

    /**
     * Unlinks non-null node x.
     */
    E unlink(Node<E> x) {
        // assert x != null;

        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }


    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
}
