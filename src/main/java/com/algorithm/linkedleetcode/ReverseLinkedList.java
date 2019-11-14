package com.algorithm.linkedleetcode;

/**
 * leetcode-206
 */
public class ReverseLinkedList {

    public static ListNode reverse(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head; //当前节点
        ListNode previous = null; //上一个节点
        ListNode nextCursor = null; //下一个节点

        while (current != null) {
            nextCursor = current.next;
            current.next=previous; //当前节点的下一个节点，变成前一个节点

            previous=current;//当前节点变成前一个节点
            current = nextCursor;//当前节点迭代到下一个节点
        }

        return previous;
    }
}
