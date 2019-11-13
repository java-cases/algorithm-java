package com.algorithm.binarysearchtree;

import java.util.function.Consumer;

public interface BinaryTree<E extends Comparable<E>> {
    int size();

    boolean isEmpty();

    //向BST中添加新元素e
    void add(E e);

    //查看BST中是否包含元素e
    boolean contains(E e);

    //BST的前序遍历
    void preorder(Consumer<E> action);

    //BST的中序遍历
    void inorder(Consumer<E> action);

    //BST的后序遍历
    void postorder(Consumer<E> action);
}
