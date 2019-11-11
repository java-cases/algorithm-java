package com.algorithm.tree;

public interface TreeNode<K extends Comparable<? super K>, D> {

    K getKey();

    void setKey(K key);

    int getDepth();

    void setDepth(int depth);

    D getData();

    D setData(D data);

    TreeNode<K, D> getLeft();

    void setLeft(TreeNode<K, D> left);

    TreeNode<K, D> getRight();

    void setRight(TreeNode<K, D> right);

    TreeNode<K, D> getParent();


}
