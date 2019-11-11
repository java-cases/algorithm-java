package com.algorithm.stack;

public interface Stack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

    static <E> Stack<E> array() {
        return new ArrayStack<>();
    }

    static <E> Stack<E> array(int capacity) {
        return new ArrayStack<>(capacity);
    }
}