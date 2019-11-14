package com.algorithm.binarysearchtree;

import java.util.function.Consumer;

public interface BinaryTree<E extends Comparable<E>> {
    int size();

    boolean isEmpty();

    //向BST中添加新元素e
    void add(E element);

    //查看BST中是否包含元素e
    boolean contains(E element);

    //BST的前序遍历
    void preorder(Consumer<E> action);

    //BST的中序遍历
    void inorder(Consumer<E> action);

    //BST的后序遍历
    void postorder(Consumer<E> action);

    //BST的层序遍历
    void levelOrder(Consumer<E> action);

    //寻找BST中的最小元素
    E min();

    //寻找BST中的最大元素
    E max();

    //删除BST中的最小值
    E removeMin();

    //删除BST中的最大值
    E removeMax();

    //删除BST中任意元素
    void remove(E element);
}
