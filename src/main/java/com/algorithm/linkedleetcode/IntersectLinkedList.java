package com.leetcode.linked;

import java.util.Set;

/**
 * leetcode-160
 */
public class IntersectLinkedList {

    public static <E> LinkNode<E> intersect(final LinkNode<E> headA, final LinkNode<E> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = headA.length();
        int lengthB = headB.length();
        int intersectLength = Math.abs(lengthA - lengthB) + 1;

        lengthA = lengthA - intersectLength;
        lengthB = lengthB - intersectLength;

        if (lengthA > lengthB) {
            LinkNode<E> lastB = headB.get(lengthB);
            if (headA.contains(lastB)) {
                return lastB;
            }
        }

        if (lengthA < lengthB) {
            LinkNode<E> lastA = headA.get(lengthA);
            if (headB.contains(lastA)) {
                return lastA;
            }
        }

        return null;
    }

    public static <E> LinkNode<E> findIntersected(final LinkNode<E> headA, final LinkNode<E> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        LinkNode<E> current = headA; //当前节点

        while (current != null && current.next != null) {
            if (headB.contains(current)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

}
