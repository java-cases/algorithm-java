package com.algorithm.queue;

import com.algorithm.linked.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        linkedList.addLast(element);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public E element() {
        return linkedList.getFirst();
    }
}
