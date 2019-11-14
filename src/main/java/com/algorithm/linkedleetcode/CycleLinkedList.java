package com.algorithm.linkedleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode-141
 */
public class CycleLinkedList {

    public static boolean hasCycle(final ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static <E> ListNode<E> findCycle(final ListNode<E> head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();
        nodeSet.add(head);

        ListNode current = head; //当前节点

        while (current != null && current.next != null) {
            current = current.next;

            if (!nodeSet.add(current)) {
                return current;
            }
        }

        return null;
    }
}
