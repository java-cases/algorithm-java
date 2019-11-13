package com.algorithm.linked;

public class LinkNode<E> {

    E item;
    LinkNode<E> next;
    LinkNode<E> prev;

    LinkNode(E element) {
        this(null, element, null);
    }

    LinkNode(LinkNode<E> prev, E element, LinkNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
