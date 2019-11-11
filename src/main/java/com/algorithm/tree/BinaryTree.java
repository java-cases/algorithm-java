package com.algorithm.tree;

import java.util.Objects;
import java.util.function.UnaryOperator;

public interface BinaryTree<K extends Comparable<? super K>, D> {

    int size();

    default Boolean isEmpty() {
        return size() == 0;
    }

    TreeNode<K, D> search(K key);

    D put(K key, D data);

    int height();

    int height(TreeNode<K, D> node);

    default TreeNode<K, D> toDeepLeaf(TreeNode<K, D> node) {
        Objects.requireNonNull(node);

        TreeNode<K, D> leftNode = node.getLeft();
        TreeNode<K, D> rightNode = node.getRight();
        if (leftNode == null && rightNode == null) {
            return node;
        }

        TreeNode<K, D> leftTargetNode = node;
        if (leftNode != null) {
            leftTargetNode = toDeepLeaf(leftNode);
        }

        TreeNode<K, D> rightTargetNode = node;
        if (rightNode != null) {
            rightTargetNode = toDeepLeaf(rightNode);
        }

        return leftTargetNode.getDepth() > rightTargetNode.getDepth() ?
                leftTargetNode : rightTargetNode;
    }

    TreeNode<K, D> toLeaf(UnaryOperator<TreeNode<K, D>> next);

    TreeNode<K, D> toLeaf(TreeNode<K, D> node, UnaryOperator<TreeNode<K, D>> next);

    TreeNode<K, D> max();

    default TreeNode<K, D> max(TreeNode<K, D> node) {
        Objects.requireNonNull(node);
        return this.toLeaf(node, x -> x.getRight());
    }

    TreeNode<K, D> min();

    default TreeNode<K, D> min(TreeNode<K, D> node) {
        Objects.requireNonNull(node);
        return this.toLeaf(node, x -> x.getLeft());
    }
}
