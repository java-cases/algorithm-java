package com.algorithm.binarysearchtree;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveBinaryTreeTest {

    @Test
    public void size() {
        BinaryTree<Integer> tree = buildTree();

        assertThat(tree.size(), Matchers.equalTo(15));
    }

    private BinaryTree<Integer> buildTree() {
        BinaryTree<Integer> tree = new RecursiveBinaryTree<>();
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
    public void isEmpty() {
        BinaryTree<Integer> tree = buildTree();
        assertThat(tree.isEmpty(), Matchers.equalTo(false));

        assertThat(new RecursiveBinaryTree<>().isEmpty(), Matchers.equalTo(true));
    }

    @Test
    public void add() {
        BinaryTree<Integer> tree = buildTree();

        assertThat(tree.size(), Matchers.equalTo(15));
    }

    @Test
    public void contains() {
        BinaryTree<Integer> tree = buildTree();

        for (int i = 1; i <= 15; i++) {
            assertThat(tree.contains(i), Matchers.equalTo(true));
        }

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
    public void printTree() {
        BinaryTree<Integer> tree = buildTree();
        System.out.println(tree.toString());
    }
}