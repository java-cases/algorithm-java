package com.algorithm.binarysearchtree;

import java.util.function.Consumer;

public class RecursiveBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E>
        implements BinaryTree<E> {

    public RecursiveBinaryTree() {
    }

    //BST的前序遍历
    @Override
    public void preorder(Consumer<E> action) {
        preorder(root, action);
    }

    private void preorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        action.accept(node.element);

        preorder(node.left, action);
        preorder(node.right, action);
    }

    //BST的中序遍历
    @Override
    public void inorder(Consumer<E> action) {
        inorder(root, action);
    }

    private void inorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        inorder(node.left, action);

        action.accept(node.element);

        inorder(node.right, action);
    }

    //BST的后序遍历
    @Override
    public void postorder(Consumer<E> action) {
        postorder(root, action);
    }

    private void postorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        postorder(node.left, action);
        postorder(node.right, action);

        action.accept(node.element);
    }

    @Override
    public void levelOrder(Consumer<E> action) {
        action.accept(root.element);
        levelOrder(root, action);
    }

    private void levelOrder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            action.accept(node.left.element);
        }

        if (node.right != null) {
            action.accept(node.right.element);
        }

        levelOrder(node.left, action);
        levelOrder(node.right, action);
    }
}
