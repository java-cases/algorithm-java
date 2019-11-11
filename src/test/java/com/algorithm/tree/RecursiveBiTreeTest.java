package com.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecursiveBiTreeTest {

    private BinaryTree<Integer, String> buildTree() {
        BinaryTree<Integer, String> tree = new RecursiveBiTree<>();
        tree.put(10, "node10");
        tree.put(11, "node11");
        tree.put(3, "node3");

        tree.put(13, "node13");
        tree.put(6, "node6");
        tree.put(4, "node4");
        tree.put(7, "node7");
        tree.put(5, "node5");
        tree.put(14, "node14");
        tree.put(12, "node12");
        tree.put(2, "node2");
        tree.put(1, "node1");
        tree.put(1, "node1");

        return tree;
    }

    @Test
    public void size() {
        BinaryTree<Integer, String> tree = buildTree();

        assertEquals(12, tree.size());
    }

    @Test
    public void isEmpty() {
        BinaryTree<Integer, String> tree = buildTree();

        assertEquals(false, tree.isEmpty());
    }

    @Test
    public void search() {
        BinaryTree<Integer, String> tree = buildTree();

        assertEquals("node1", tree.search(1).getData());
        assertEquals("node5", tree.search(5).getData());

        assertEquals("node10", tree.search(10).getData());

        assertEquals("node11", tree.search(11).getData());
        assertEquals("node14", tree.search(14).getData());
    }

    @Test
    public void put() {
        BinaryTree<Integer, String> tree = buildTree();

        assertEquals("node3", tree.search(10).getLeft().getData());
        assertEquals("node11", tree.search(10).getRight().getData());

        assertEquals("node2", tree.search(3).getLeft().getData());
        assertEquals("node6", tree.search(3).getRight().getData());

        assertEquals("node1", tree.search(2).getLeft().getData());
        assertEquals(null, tree.search(2).getRight());

        assertEquals(null, tree.search(1).getLeft());
        assertEquals(null, tree.search(1).getRight());

        assertEquals("node4", tree.search(6).getLeft().getData());
        assertEquals("node7", tree.search(6).getRight().getData());

        assertEquals(null, tree.search(4).getLeft());
        assertEquals("node5", tree.search(4).getRight().getData());

        assertEquals(null, tree.search(5).getLeft());
        assertEquals(null, tree.search(5).getRight());

        assertEquals(null, tree.search(7).getLeft());
        assertEquals(null, tree.search(7).getRight());

        assertEquals(null, tree.search(11).getLeft());
        assertEquals("node13", tree.search(11).getRight().getData());

        assertEquals("node12", tree.search(13).getLeft().getData());
        assertEquals("node14", tree.search(13).getRight().getData());

        assertEquals(null, tree.search(12).getLeft());
        assertEquals(null, tree.search(12).getRight());

        assertEquals(null, tree.search(14).getLeft());
        assertEquals(null, tree.search(14).getRight());
    }

    @Test
    public void height() {
        BinaryTree<Integer, String> tree = buildTree();
        assertEquals(5, tree.height());
    }

    @Test
    public void max() {
        BinaryTree<Integer, String> tree = buildTree();
        TreeNode<Integer, String> maxNode = tree.max();

        assertNotNull(maxNode);
        assertEquals(Integer.valueOf(14), maxNode.getKey());
    }

    @Test
    public void min() {
        BinaryTree<Integer, String> tree = buildTree();
        TreeNode<Integer, String> minNode = tree.min();

        assertNotNull(minNode);
        assertEquals(Integer.valueOf(1), minNode.getKey());
    }

}