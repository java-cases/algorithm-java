package com.algorithm.linked;

import java.util.HashSet;

public class CycleLinkedList<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public CycleLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

        public Node<E> next(E element) {
            final Node<E> newNode = new Node<>(element, null);
            this.next = newNode;
            return newNode;
        }

        public Node<E> next(Node<E> next) {
            this.next = next;
            return next;
        }
    }

    public Node<E> add(E element) {
        return linkLast(element);
    }

    private Node<E> linkLast(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(element, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
        return newNode;
    }

    public boolean hasCycle() {
        return hasCycle(this.first);
    }

    private static <E> boolean hasCycle(final Node<E> head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node<E> findCycle() {
        return findCycle(this.first);
    }

    private static <E> Node<E> findCycle(final Node<E> head) {
        if (head == null || head.next == null) {
            return null;
        }

        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(head);

        Node current = head; //当前节点

        while (current != null && current.next != null) {
            current = current.next;

            if (!nodeSet.add(current)) {
                return current;
            }
        }

        return null;
    }

}
