package com.algorithm.linkedleetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkNode<E> {

    public E item;
    public LinkNode<E> next;


    public LinkNode(E element) {
        this.item = element;
    }

    public LinkNode<E> link(final E element) {
        return this.link(new LinkNode<>(element));
    }

    public LinkNode<E> link(final LinkNode<E> next) {
        LinkNode<E> last = this.getLast();
        last.next = next;
        return next;
    }

    public int length() {
        return length(this);
    }

    public static <E> int length(final LinkNode<E> head) {
        int length = 0;
        LinkNode<E> current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public LinkNode<E> getLast() {
        return getLast(this);
    }

    public static <E> LinkNode<E> getLast(final LinkNode<E> head) {
        LinkNode<E> current = head;
        LinkNode<E> last = head;

        while (current != null) {
            last = current;
            current = current.next;
        }

        return last;
    }

    public Set<LinkNode<E>> collect() {
        return collect(this);
    }

    public static <E> Set<LinkNode<E>> collect(final LinkNode<E> head) {
        Set<LinkNode<E>> nodeSet = new HashSet<>();
        LinkNode<E> current = head;

        while (current != null) {
            nodeSet.add(current);
            current = current.next;
        }

        return nodeSet;
    }

    public LinkNode<E> get(int index) {
        return get(index, this);
    }

    public static <E> LinkNode<E> get(int index, final LinkNode<E> head) {
        if (index <= 0) {
            return head;
        }

        LinkNode<E> current = head;
        LinkNode<E> last = head;

        while (current != null && index >= 0) {
            last = current;
            index--;
            current = current.next;
        }

        return last;
    }

    public boolean contains(LinkNode<E> target) {
        return contains(this, target);
    }

    public boolean contains(E element) {
        return contains(this, element);
    }

    public static <E> boolean contains(final LinkNode<E> head, LinkNode<E> target) {
        LinkNode<E> current = head;

        while (current != null) {
            if (current == target) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static <E> boolean contains(final LinkNode<E> head, E element) {
        LinkNode<E> current = head;

        while (current != null) {
            if (current.item.equals(element)) {
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

        LinkNode<?> listNode = (LinkNode<?>) o;

        return Objects.equals(item, listNode.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "item=" + item +
                '}';
    }
}
