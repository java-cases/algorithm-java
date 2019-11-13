package com.algorithm.binarysearchtree;

import java.util.function.Consumer;

public class RecursiveBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
    private Node root;
    private int size;

    public RecursiveBinaryTree() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public E element;
        public Node left, right;

        public Node(E e) {
            this.element = e;
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

    //向BST中添加新元素e
    @Override
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根节点的BST树种插入元素e
    //返回插入新元素后该BST的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        //注意：对于e.equals(node.element)不做处理
        if (e.compareTo(node.element) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.element) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //查看BST中是否包含元素e
    @Override
    public boolean contains(E e) {
        return contains(root, e);
    }

    //查看以node为根节点的BST中是否包含元素e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.element) == 0) {
            return true;
        } else if (e.compareTo(node.element) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //BST的前序遍历
    @Override
    public void preorder(Consumer<E> action) {
        preorder(root, action);
    }

    private void preorder(Node node, Consumer<E> action) {
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

    private void inorder(Node node, Consumer<E> action) {
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

    private void postorder(Node node, Consumer<E> action) {
        if (node == null) {
            return;
        }
        postorder(node.left, action);
        postorder(node.right, action);

        action.accept(node.element);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBST(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串（利用前序遍历）
    private void generateBST(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepth(depth) + "null\n");
            return;
        }
        res.append(generateDepth(depth) + node.element + "\n");
        generateBST(node.left, depth + 1, res);
        generateBST(node.right, depth + 1, res);
    }

    private String generateDepth(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
