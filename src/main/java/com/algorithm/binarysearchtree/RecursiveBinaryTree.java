package com.algorithm.binarysearchtree;

import java.util.List;

public class RecursiveBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E>
        implements BinaryTree<E> {

    public RecursiveBinaryTree() {
    }

    @Override
    protected void preorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        outItems.add(node.element);

        preorder(node.left, outItems);
        preorder(node.right, outItems);
    }

    @Override
    protected void inorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        inorder(node.left, outItems);

        outItems.add(node.element);

        inorder(node.right, outItems);
    }

    @Override
    protected void postorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        postorder(node.left, outItems);
        postorder(node.right, outItems);

        outItems.add(node.element);
    }

    @Override
    protected void levelOrder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            outItems.add(node.left.element);
        }

        if (node.right != null) {
            outItems.add(node.right.element);
        }

        levelOrder(node.left, outItems);
        levelOrder(node.right, outItems);
    }
}
