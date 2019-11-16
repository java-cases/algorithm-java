package com.algorithm.binarysearchtree;

import java.util.*;

public class LoopBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E>
        implements BinaryTree<E> {

    public LoopBinaryTree() {
        super();
    }

    //枚举命令，GO表示访问元素，SELECT表示处理元素
    private enum Command {
        GO, SELECT
    }

    private class StackNode {
        Command command;
        BinaryNode<E> node;

        StackNode(BinaryNode<E> node, Command command) {
            this.command = command;
            this.node = node;
        }
    }

    @Override
    protected void preorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();

            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.SELECT) {
                outItems.add(popNode.element);
                continue;
            }

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }

            stack.push(new StackNode(popNode, Command.SELECT));
        }
    }

    @Override
    protected void inorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();
            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.SELECT) {
                outItems.add(popNode.element);
                continue;
            }

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            stack.push(new StackNode(popNode, Command.SELECT));

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }
        }
    }

    @Override
    protected void postorder(final BinaryNode<E> node, final List<E> outItems) {
        if (node == null) {
            return;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(node, Command.GO));

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();
            BinaryNode<E> popNode = stackNode.node;
            Command command = stackNode.command;

            if (command == Command.SELECT) {
                outItems.add(popNode.element);
                continue;
            }

            stack.push(new StackNode(popNode, Command.SELECT));

            if (popNode.right != null) {
                stack.push(new StackNode(popNode.right, Command.GO));
            }

            if (popNode.left != null) {
                stack.push(new StackNode(popNode.left, Command.GO));
            }
        }
    }

    @Override
    protected void levelOrder(final BinaryNode<E> node, final List<E> outItems) {
        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryNode<E> popNode = queue.remove();

            outItems.add(popNode.element);

            if (popNode.left != null) {
                queue.add(popNode.left);
            }

            if (popNode.right != null) {
                queue.add(popNode.right);
            }
        }
    }

}
