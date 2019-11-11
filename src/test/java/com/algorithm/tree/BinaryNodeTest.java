package com.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNodeTest {

    @Test
    public void toStringOfBinaryNode() {
        TreeNode<Integer, String> node = new BinaryNode<>(1, "node1", null);
        System.out.println(node.toString());
    }

    @Test

    public void equalsOfBinaryNode() {
        TreeNode<Integer, String> node1 = new BinaryNode<>(1, "node1", null);
        TreeNode<Integer, String> node2 = new BinaryNode<>(1, "node1", null);
        TreeNode<Integer, String> node3 = new BinaryNode<>(2, "node2", null);

        assertTrue(node1.equals(node2));
        assertFalse(node1.equals(node3));
    }

    @Test
    public void hashCodeOfBinaryNode() {
        TreeNode<Integer, String> node1 = new BinaryNode<>(1, "node1", null);
        TreeNode<Integer, String> node2 = new BinaryNode<>(1, "node1", null);
        TreeNode<Integer, String> node3 = new BinaryNode<>(2, "node2", null);

        assertEquals(node1.hashCode(), node2.hashCode());
        assertFalse(node1.hashCode() == node3.hashCode());
    }
}