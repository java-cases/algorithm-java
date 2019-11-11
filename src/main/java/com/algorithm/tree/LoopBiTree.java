package com.algorithm.tree;

import java.util.function.UnaryOperator;

public class LoopBiTree<K extends Comparable<? super K>, D> implements BinaryTree<K, D> {

    private transient TreeNode<K, D> root;
    private transient int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public TreeNode<K, D> search(K key) {
        return getNode(key);
    }

    private TreeNode<K, D> getNode(K key) {

        if (key == null) {
            throw new NullPointerException();
        }

        TreeNode<K, D> p = root;
        while (p != null) {
            int cmp = key.compareTo(p.getKey());
            if (cmp < 0) {
                p = p.getLeft();
            } else if (cmp > 0) {
                p = p.getRight();
            } else {
                return p;
            }
        }

        return null;
    }

    @Override
    public D put(K key, D data) {

        TreeNode<K, D> target = root;
        if (target == null) {
            root = new BinaryNode<>(key, data, null);
            size = 1;
            return null;
        }

        int cmp;
        TreeNode<K, D> parent;

        if (key == null) {
            throw new NullPointerException();
        }

        do {
            parent = target;
            cmp = key.compareTo(target.getKey());

            if (cmp < 0) {
                target = target.getLeft();
            } else if (cmp > 0) {
                target = target.getRight();
            } else {
                return target.setData(data);
            }
        } while (target != null);

        TreeNode<K, D> e = new BinaryNode<>(key, data, parent);
        if (cmp < 0) {
            parent.setLeft(e);
        } else {
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
        return this.toDeepLeaf(node).getDepth();
    }

    @Override
    public TreeNode<K, D> toLeaf(UnaryOperator<TreeNode<K, D>> next) {
        return toLeaf(root, next);
    }

    @Override
    public TreeNode<K, D> toLeaf(TreeNode<K, D> node, UnaryOperator<TreeNode<K, D>> next) {
        if (node == null) {
            return null;
        }

        if (next == null) {
            return node;
        }

        TreeNode<K, D> tartget = node;
        TreeNode<K, D> nextNode = node;

        while (nextNode != null) {
            tartget = nextNode;
            nextNode = next.apply(nextNode);
        }

        return tartget;
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
