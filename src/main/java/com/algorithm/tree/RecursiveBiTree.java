package com.algorithm.tree;

import java.util.function.UnaryOperator;

public class RecursiveBiTree<K extends Comparable<? super K>, D> implements BinaryTree<K, D> {

    private transient TreeNode<K, D> root;
    private transient int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public TreeNode<K, D> search(K key) {
        TreeNode<K, D> parent = root;
        return getNode(parent, key);
    }

    private TreeNode<K, D> getNode(TreeNode<K, D> node, K key) {

        if (key == null) {
            throw new NullPointerException();
        }

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node = node.getLeft();
            return getNode(node, key);
        } else if (cmp > 0) {
            node = node.getRight();
            return getNode(node, key);
        } else {
            return node;
        }
    }

    @Override
    public D put(K key, D data) {

        TreeNode<K, D> target = root;
        if (target == null) {
            root = new BinaryNode<>(key, data, null);
            size = 1;
            return null;
        }

        return insertNode(target, key, data);
    }

    private D insertNode(TreeNode<K, D> parent, K key, D value) {

        if (parent == null) {
            return null;
        }

        int cmp = key.compareTo(parent.getKey());
        if (cmp == 0) {
            return parent.setData(value);
        }


        TreeNode<K, D> target;
        if (cmp < 0) {
            target = parent.getLeft();
            if (target != null) {
                return insertNode(target, key, value);
            }

            TreeNode<K, D> e = new BinaryNode<>(key, value, parent);
            parent.setLeft(e);

        } else if (cmp > 0) {
            target = parent.getRight();
            if (target != null) {
                return insertNode(target, key, value);
            }

            TreeNode<K, D> e = new BinaryNode<>(key, value, parent);
            parent.setRight(e);
        }

        size++;
        return null;
    }

    @Override
    public int height() {
        return this.height(root);
    }

    @Override
    public int height(TreeNode<K, D> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft()) + 1;
        int rightHeight = height(node.getRight()) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    @Override
    public TreeNode<K, D> toLeaf(UnaryOperator<TreeNode<K, D>> next) {
        return this.toLeaf(root, next);
    }

    @Override
    public TreeNode<K, D> toLeaf(TreeNode<K, D> node, UnaryOperator<TreeNode<K, D>> next) {
        if (node == null) {
            return null;
        }

        if (next == null) {
            return node;
        }

        TreeNode<K, D> nextNode = next.apply(node);
        if (nextNode == null) {
            return node;
        }

        return toLeaf(nextNode, next);
    }

    @Override
    public TreeNode<K, D> max() {
        return this.max(root);
    }

    @Override
    public TreeNode<K, D> min() {
        return this.min(root);
    }


}
