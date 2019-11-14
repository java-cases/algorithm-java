package com.algorithm.linkedleetcode;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CycleLinkedListTest {

    @Test
    public void hasCycle() {
        ListNode<Integer> cycle = new ListNode<Integer>(1).link(2);
        assertThat(CycleLinkedList.hasCycle(cycle), Matchers.equalTo(false));

        cycle.link(3).link(4).link(5).link(cycle);
        assertThat(CycleLinkedList.hasCycle(cycle), Matchers.equalTo(true));
    }

    @Test
    public void findCycle() {
        ListNode<Integer> cycle = new ListNode<Integer>(1).link(2);
        assertThat(CycleLinkedList.findCycle(cycle), Matchers.nullValue());

        cycle.link(3).link(4).link(5).link(cycle);
        assertThat(CycleLinkedList.findCycle(cycle), Matchers.notNullValue());
        assertThat(CycleLinkedList.findCycle(cycle).item, Matchers.equalTo(2));
    }
}