package com.algorithm.queue;

public interface Queue<E> {
    void enqueue(E element);

    E dequeue();

    E element();

    int size();

    boolean isEmpty();
}
