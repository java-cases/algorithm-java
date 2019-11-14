package com.algorithm.set;

import java.util.LinkedList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public boolean add(E element) {
        if (!contains(element)) {
            linkedList.addFirst(element);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(E element) {
        return element.equals(linkedList.remove(element));
    }

    @Override
    public boolean contains(E element) {
        return linkedList.contains(element);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}