package com.leetcode.linked;

import java.util.Objects;

/**
 * leetcode-160
 */
public class IntersectLinkedList {

    public static Node intersect(final Node headA, final Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = headA.length();
        int lengthB = headB.length();
        int intersectLength = Math.abs(lengthA - lengthB) + 1;

        lengthA = lengthA - intersectLength;
        lengthB = lengthB - intersectLength;

        if (lengthA > lengthB) {
            Node lastB = headB.get(lengthB);
            if (headA.contains(lastB)) {
                return lastB;
            }
        }

        if (lengthA < lengthB) {
            Node lastA = headA.get(lengthA);
            if (headB.contains(lastA)) {
                return lastA;
            }
        }

        return null;
    }


    public static class Node<E> {

        public E item;
        public Node<E> next;


        public Node(E element) {
            this.item = element;
        }

        public Node<E> link(final E element) {
            return this.link(new Node<>(element));
        }

        public Node<E> link(final Node<E> next) {
            Node<E> last = this.getLast();
            last.next = next;
            return next;
        }

        public int length() {
            return length(this);
        }

        public static int length(final Node head) {
            int length = 0;
            Node current = head;

            while (current != null) {
                length++;
                current = current.next;
            }

            return length;
        }

        public Node<E> getLast() {
            return getLast(this);
        }

        public static <E> Node<E> getLast(final Node head) {
            Node current = head;
            Node last = head;

            while (current != null) {
                last = current;
                current = current.next;
            }

            return last;
        }

        public Node<E> get(int index) {
            return get(index, this);
        }

        public static <E> Node<E> get(int index, final Node head) {
            if (index <= 0) {
                return head;
            }

            Node current = head;
            Node last = head;

            while (current != null && index >= 0) {
                last = current;
                index--;
                current = current.next;
            }

            return last;
        }

        public boolean contains(Node target) {
            return contains(this, target);
        }

        public static boolean contains(final Node head, Node target) {
            Node current = head;

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

            Node<?> listNode = (Node<?>) o;

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


}
