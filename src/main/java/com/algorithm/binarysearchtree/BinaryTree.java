package com.algorithm.binarysearchtree;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface BinaryTree<E> {
    int size();

    boolean isEmpty();

    //向BST中添加新元素e
    void add(E element);

    List<E> find(Predicate<E> filter);

    //查看BST中是否包含元素e
    boolean contains(E element);

    //BST的前序遍历
    List<E> preorder();

    //BST的中序遍历
    List<E> inorder();

    //BST的后序遍历
    List<E> postorder();

    //BST的层序遍历
    List<E> levelOrder();

    //寻找BST中的最小元素
    E min();

    //寻找BST中的最大元素
    E max();

    //删除BST中的最小值
    E removeMin();

    //删除BST中的最大值
    E removeMax();

    int remove(Predicate<E> filter);

    //删除BST中任意元素
    void remove(E element);
}
