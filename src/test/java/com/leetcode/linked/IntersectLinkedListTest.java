package com.leetcode.linked;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectLinkedListTest {

    @Test
    public void intersect() {
        IntersectLinkedList.Node<Integer> nodeA = new IntersectLinkedList.Node<>(1);
        nodeA.link(2).link(3);

        IntersectLinkedList.Node<Integer> nodeB = new IntersectLinkedList.Node<>(1);
        nodeB.link(2).link(3).link(4).link(5);

        IntersectLinkedList.Node<Integer> nodeC = new IntersectLinkedList.Node<>(6);
        nodeC.link(7).link(8);

        nodeA.link(nodeC);
        nodeB.link(nodeC);

        IntersectLinkedList.Node<Integer> intersectNode = IntersectLinkedList.intersect(nodeA, nodeB);

        assertThat(intersectNode, Matchers.notNullValue());
        assertThat(intersectNode.item, Matchers.equalTo(6));
    }
}