package com.algorithm.binarysearchtree;

import org.junit.Test;

public class LoopBinaryTreeTest {

    private BinaryTree<Integer> buildTree() {
        BinaryTree<Integer> tree = new LoopBinaryTree<>();
        tree.add(10);
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        tree.add(15);
        tree.add(11);
        tree.add(12);
        tree.add(14);
        tree.add(13);

        tree.add(10);
        tree.add(1);
        return tree;
    }

    @Test
    public void preorder() {
        BinaryTree<Integer> tree = buildTree();
        tree.preorder(x -> System.out.println(x));
    }

    @Test
    public void inorder() {
        BinaryTree<Integer> tree = buildTree();
        tree.inorder(x -> System.out.println(x));
    }

    @Test
    public void postorder() {
        BinaryTree<Integer> tree = buildTree();
        tree.postorder(x -> System.out.println(x));
    }

    @Test
    public void levelOrder() {
        BinaryTree<Integer> tree = buildTree();
        tree.levelOrder(x -> System.out.println(x));
    }

}