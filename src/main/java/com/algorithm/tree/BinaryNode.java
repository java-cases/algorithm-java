package com.algorithm.tree;

import java.util.Objects;

public class BinaryNode<K extends Comparable<? super K>, D> implements TreeNode<K, D> {

    private K key;
    private D data;
    private int depth;

    private TreeNode<K, D> left;
    private TreeNode<K, D> right;
    private TreeNode<K, D> parent;

    public BinaryNode(K key, D data, TreeNode<K, D> parent) {
        this.key = key;
        this.data = data;
        this.parent = parent;
        if (parent == null) {
            this.setDepth(1);
        } else {
            this.setDepth(parent.getDepth() + 1);
        }
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public int getDepth() {
        return this.depth;
    }

    @Override
    public void setDepth(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("Argument depth must greater than 0.");
        }
        this.depth = depth;
    }

    @Override
    public D getData() {
        return data;
    }

    @Override
    public D setData(D data) {
        D oldValue = this.data;
        this.data = data;
        return oldValue;
    }

    public TreeNode<K, D> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, D> left) {
        this.left = left;
    }

    public TreeNode<K, D> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, D> right) {
        this.right = right;
    }

    @Override
    public TreeNode<K, D> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "key=" + key +
                ", items=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeNode<?, ?> that = (TreeNode<?, ?>) o;
        return Objects.equals(key, that.getKey()) &&
                Objects.equals(data, that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, data);
    }
}
