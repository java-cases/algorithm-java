package com.algorithm.linked;

public class LinkedNode<E> {

    E item;
    LinkedNode<E> next;
    LinkedNode<E> prev;

    LinkedNode(E element) {
        this(null, element, null);
    }

    LinkedNode(LinkedNode<E> prev, E element, LinkedNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
