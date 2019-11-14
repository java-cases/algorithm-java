package com.algorithm.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class LoopBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E>
        implements BinaryTree<E> {

    public LoopBinaryTree() {
        super();
    }

    //枚举命令，GO表示访问元素，ACTION表示处理元素
    private enum Command {
        GO, ACTION
    }

    private class StackNode {
        Command command;
        BinaryNode<E> node;

        StackNode(BinaryNode<E> node, Command command) {
            this.command = command;
            this.node = node;
        }
    }

    //BST的前序遍历
    @Override
    public void preorder(Consumer<E> action) {
        preorder(root, action);
    }

    private void preorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();

            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.ACTION) {
                action.accept(popNode.element);
                continue;
            }

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }

            stack.push(new StackNode(popNode, Command.ACTION));
        }
    }

    //BST的中序遍历
    @Override
    public void inorder(Consumer<E> action) {
        inorder(root, action);
    }

    private void inorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();
            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.ACTION) {
                action.accept(popNode.element);
                continue;
            }

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            stack.push(new StackNode(popNode, Command.ACTION));

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }
        }
    }

    //BST的后序遍历
    @Override
    public void postorder(Consumer<E> action) {
        postorder(root, action);
    }

    private void postorder(final BinaryNode<E> node, Consumer<E> action) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();
            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.ACTION) {
                action.accept(popNode.element);
                continue;
            }

            stack.push(new StackNode(popNode, Command.ACTION));

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }
        }
    }

    //BST的层序遍历
    @Override
    public void levelOrder(Consumer<E> action) {
        levelOrder(root, action);
    }

    private void levelOrder(final BinaryNode<E> node, Consumer<E> action) {
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryNode<E> popNode = queue.remove();

            action.accept(popNode.element);

            if (popNode.left != null) {
                queue.add(popNode.left);
            }

            if (popNode.right != null) {
                queue.add(popNode.right);
            }
        }
    }

}
