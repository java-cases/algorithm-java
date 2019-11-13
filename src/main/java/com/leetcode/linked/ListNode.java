package com.leetcode.linked;

public class ListNode<E> {

    public E item;
    public ListNode<E> next;

    public ListNode(E element) {
        this.item = element;
    }

    public ListNode<E> link(final E element) {
        ListNode<E> newNode = new ListNode<>(element);
        return this.link(newNode);
    }

    public ListNode<E> link(final ListNode<E> next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "item=" + item +
                '}';
    }
}
