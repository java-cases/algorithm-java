package com.algorithm.linked;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeTest {

    @Test
    public void next() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3).link(4).link(5);

        assertThat(node.item, Matchers.equalTo(1));

        assertThat(node.next, Matchers.notNullValue());

        assertThat(node.next.item, Matchers.equalTo(2));
        assertThat(node.next.next.item, Matchers.equalTo(3));
        assertThat(node.next.next.next.item, Matchers.equalTo(4));
        assertThat(node.next.next.next.next.item, Matchers.equalTo(5));

        assertThat(node.next.next.next.next.next, Matchers.nullValue());
    }

    @Test
    public void nextMultiLists() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3);

        ListNode<Integer> other = new ListNode<>(4);
        other.link(5);

        node.link(other);

        assertThat(node.item, Matchers.equalTo(1));

        assertThat(node.next, Matchers.notNullValue());
        assertThat(node.next.item, Matchers.equalTo(2));
        assertThat(node.next.next.item, Matchers.equalTo(3));

        assertThat(node.next.next.next.item, Matchers.equalTo(4));
        assertThat(node.next.next.next.next.item, Matchers.equalTo(5));

        assertThat(node.next.next.next.next.next, Matchers.nullValue());
    }

    @Test
    public void length() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3).link(4).link(5);

        assertThat(node.length(), Matchers.equalTo(5));
    }

    @Test
    public void lengthMultiLists() {
        ListNode<Integer> node1 = new ListNode<>(1);
        node1.link(2).link(3);

        ListNode<Integer> node2 = new ListNode<>(1);
        node2.link(2).link(3).link(4).link(5);

        ListNode<Integer> other = new ListNode<>(6);
        other.link(7).link(8);

        node1.link(other);
        assertThat(node1.length(), Matchers.equalTo(6));

        node2.link(other);
        assertThat(node2.length(), Matchers.equalTo(8));
    }

    @Test
    public void last() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3).link(4).link(5);

        assertThat(node.getLast().item, Matchers.equalTo(5));
    }

    @Test
    public void get() {
        ListNode<Integer> node = new ListNode<>(1);
        node.link(2).link(3).link(4).link(5);

        assertThat(node.get(0).item, Matchers.equalTo(1));
        assertThat(node.get(1).item, Matchers.equalTo(2));
        assertThat(node.get(2).item, Matchers.equalTo(3));
        assertThat(node.get(3).item, Matchers.equalTo(4));
        assertThat(node.get(4).item, Matchers.equalTo(5));
    }
}