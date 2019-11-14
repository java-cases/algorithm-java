package com.algorithm.binarysearchtree;

public class BinaryNode<E extends Comparable<E>> {

    public E element;
    public BinaryNode<E> left;
    public BinaryNode<E> right;

    public BinaryNode(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
