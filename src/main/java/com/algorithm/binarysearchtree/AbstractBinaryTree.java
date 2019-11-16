package com.algorithm.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {

    protected BinaryNode<E> root;
    protected int size;

    public AbstractBinaryTree() {
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

    //向BST中添加新元素e
    @Override
    public void add(E element) {
        BinaryNode<E> node = add(root, element);
        root = node;
    }

    //向以node为根节点的BST树种插入元素e
    //返回插入新元素后该BST的根
    private BinaryNode<E> add(BinaryNode<E> node, E element) {
        if (node == null) {
            size++;
            return new BinaryNode<>(element);
        }

        //注意：对于e.equals(node.element)不做处理
        if (element.compareTo(node.element) < 0) {
            node.left = add(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = add(node.right, element);
        }

        return node;
    }

    //查看BST中是否包含元素e
    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    //查看以node为根节点的BST中是否包含元素e
    private boolean contains(BinaryNode<E> node, E e) {
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

    @Override
    public List<E> find(Predicate<E> filter) {
        List<E> outItems = new ArrayList<>();
        find(root, filter, outItems);

        return outItems;
    }

    private void find(final BinaryNode<E> node,
                      final Predicate<E> filter, final List<E> outItems) {
        if (node == null) {
            return;
        }

        if (filter.test(node.element)) {
            outItems.add(node.element);
        }

        find(node.left, filter, outItems);
        find(node.right, filter, outItems);
    }

    //BST的前序遍历
    @Override
    public List<E> preorder() {
        List<E> outItems = new ArrayList<>();
        preorder(root, outItems);

        return outItems;
    }

    protected abstract void preorder(final BinaryNode<E> node, final List<E> outItems);

    //BST的中序遍历
    @Override
    public List<E> inorder() {
        List<E> outItems = new ArrayList<>();
        inorder(root, outItems);

        return outItems;
    }

    protected abstract void inorder(final BinaryNode<E> node, final List<E> outItems);

    //BST的后序遍历
    @Override
    public List<E> postorder() {
        List<E> outItems = new ArrayList<>();
        postorder(root, outItems);

        return outItems;
    }

    protected abstract void postorder(final BinaryNode<E> node, final List<E> outItems);

    //BST的层序遍历
    @Override
    public List<E> levelOrder() {
        List<E> outItems = new ArrayList<>();
        levelOrder(root, outItems);

        return outItems;
    }

    protected abstract void levelOrder(final BinaryNode<E> node, final List<E> outItems);

    //寻找BST中的最小元素
    @Override
    public E min() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is emmpty");
        }
        return min(root).element;
    }

    private BinaryNode<E> min(BinaryNode<E> node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    //寻找BST中的最大元素
    @Override
    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is emmpty");
        }
        return max(root).element;
    }

    private BinaryNode<E> max(BinaryNode<E> node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    //删除BST中的最小值
    @Override
    public E removeMin() {
        E res = min();
        removeMin(root);
        return res;
    }

    //删除以node为根结点的BST中的最小值元素
    //这里考虑最小值只有右子树的情况，因为叶子节点是其特例
    private BinaryNode<E> removeMin(BinaryNode<E> node) {
        if (node.left == null) {
            BinaryNode<E> nodeRight = node.right;
            node.right = null;
            size--;
            return nodeRight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除BST中的最大值
    @Override
    public E removeMax() {
        E res = max();
        removeMax(root);
        return res;
    }

    //删除以node为根结点的BST中的最大值元素
    private BinaryNode<E> removeMax(BinaryNode<E> node) {
        if (node.right == null) {
            BinaryNode<E> nodeLeft = node.left;
            node.left = null;
            size--;
            return nodeLeft;
        }

        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public int remove(Predicate<E> filter) {
        List<E> list = this.find(filter);

        for (int i = 0; i < list.size(); i++) {
            this.remove(list.get(i));
        }

        return list.size();
    }

    //删除BST中任意元素
    @Override
    public void remove(E element) {
        root = remove(root, element);
    }


    private BinaryNode<E> remove(BinaryNode<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.element) < 0) {
            node.left = remove(node.left, element);
            return node;
        } else if (element.compareTo(node.element) > 0) {
            node.right = remove(node.right, element);
            return node;
        }

        //节点node就是要删除的节点
        //该节点只右有子树
        if (node.left == null) {
            BinaryNode<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        //该节点只有左子树
        if (node.right == null) {
            BinaryNode<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        //删除既有左子树又有右子树的节点
        BinaryNode<E> s = min(node.right);
        s.right = removeMin(node.right);
        s.left = node.left;

        //删除node
        node.left = node.right = null;
        return s;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBST(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串（利用前序遍历）
    private void generateBST(BinaryNode<E> node, int depth, StringBuilder res) {
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
