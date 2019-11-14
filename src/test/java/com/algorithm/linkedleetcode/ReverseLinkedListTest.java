package com.algorithm.linkedleetcode;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void reverse() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3).link(4).link(5);

        ListNode<Integer> reverseNode = ReverseLinkedList.reverse(node);

        assertThat(reverseNode, Matchers.notNullValue());

        assertThat(reverseNode.item, Matchers.equalTo(5));
        assertThat(reverseNode.next.item, Matchers.equalTo(4));
        assertThat(reverseNode.next.next.item, Matchers.equalTo(3));
        assertThat(reverseNode.next.next.next.item, Matchers.equalTo(2));
        assertThat(reverseNode.next.next.next.next.item, Matchers.equalTo(1));

        assertThat(reverseNode.next.next.next.next.next, Matchers.nullValue());
    }
}