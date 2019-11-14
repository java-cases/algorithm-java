package com.leetcode.linked;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectLinkedListTest {

    @Test
    public void intersect() {
        LinkNode<Integer> nodeA = buildNodeA();
        LinkNode<Integer> nodeB = buildNodeB();
        LinkNode<Integer> nodeC = buildNodeC();

        nodeA.link(nodeC);
        nodeB.link(nodeC);

        LinkNode<Integer> intersectNode = IntersectLinkedList.intersect(nodeA, nodeB);

        assertThat(intersectNode, Matchers.notNullValue());
        assertThat(intersectNode.item, Matchers.equalTo(6));
    }

    private LinkNode<Integer> buildNodeA() {
        LinkNode<Integer> nodeA = new LinkNode<>(1);
        nodeA.link(2).link(3);
        return nodeA;
    }

    private LinkNode<Integer> buildNodeB() {
        LinkNode<Integer> nodeB = new LinkNode<>(1);
        nodeB.link(2).link(3).link(4).link(5);
        return nodeB;
    }

    private LinkNode<Integer> buildNodeC() {
        LinkNode<Integer> nodeC = new LinkNode<>(6);
        nodeC.link(7).link(8);
        return nodeC;
    }

    @Test
    public void findIntersected() {
        LinkNode<Integer> nodeA = buildNodeA();
        LinkNode<Integer> nodeB = buildNodeB();
        LinkNode<Integer> nodeC = buildNodeC();

        nodeA.link(nodeC);
        nodeB.link(nodeC);

        LinkNode<Integer> intersectNode = IntersectLinkedList.findIntersected(nodeA, nodeB);

        assertThat(intersectNode, Matchers.notNullValue());
        assertThat(intersectNode.item, Matchers.equalTo(6));

    }
}