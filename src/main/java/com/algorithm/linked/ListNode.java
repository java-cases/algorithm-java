package com.algorithm.linked;

import java.util.Objects;

public class ListNode<E> {

    public E item;
    public ListNode<E> next;


    public ListNode(E element) {
        this.item = element;
    }

    public ListNode<E> link(final E element) {
        return this.link(new ListNode<>(element));
    }

    public ListNode<E> link(final ListNode<E> next) {
        ListNode<E> last = this.getLast();
        last.next = next;
        return next;
    }

    public int length() {
        return length(this);
    }

    public static int length(final ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public ListNode<E> getLast() {
        return getLast(this);
    }

    public static <E> ListNode<E> getLast(final ListNode head) {
        ListNode current = head;
        ListNode last = head;

        while (current != null) {
            last = current;
            current = current.next;
        }

        return last;
    }

    public ListNode<E> get(int index) {
        return get(index, this);
    }

    public static <E> ListNode<E> get(int index, final ListNode head) {
        if (index <= 0) {
            return head;
        }

        ListNode current = head;
        ListNode last = head;

        while (current != null && index >= 0) {
            last = current;
            index--;
            current = current.next;
        }

        return last;
    }

    public boolean contains(ListNode target) {
        return contains(this, target);
    }

    public static boolean contains(final ListNode head, ListNode target) {
        ListNode current = head;

        while (current != null) {
            if (current.equals(target)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListNode<?> listNode = (ListNode<?>) o;

        return Objects.equals(item, listNode.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "item=" + item +
                '}';
    }
}
