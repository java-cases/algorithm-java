package com.algorithm.set;

import com.algorithm.binarysearchtree.BinaryTree;
import com.algorithm.binarysearchtree.RecursiveBinaryTree;

public class BinaryTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinaryTree<E> tree;

    public BinaryTreeSet() {
        tree = new RecursiveBinaryTree<>();
    }

    @Override
    public boolean add(E element) {
        if (tree.contains(element)) {
            return false;
        }

        tree.add(element);
        return false;
    }

    @Override
    public boolean remove(E element) {
        tree.remove(element);
        return !tree.contains(element);
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }
}
