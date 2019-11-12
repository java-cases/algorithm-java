package com.algorithm.queue;

import com.algorithm.array.Array;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = Array.resizable(capacity);
    }

    public ArrayQueue() {
        array = Array.resizable();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        array.addLast(element);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E element() {
        return array.get(0);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Queue: ");
        ret.append("front [");

        for (int i = 0; i < array.size(); i++) {
            ret.append(array.get(i));
            if (i != array.size() - 1) {
                ret.append(", ");
            }
        }

        ret.append("] tail");

        return ret.toString();
    }
}
