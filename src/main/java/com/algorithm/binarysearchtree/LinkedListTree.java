package com.algorithm.binarysearchtree;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListTree {

    private String items;

    public LinkedListTree(String items) {
        this.items = items;
    }

    private static BinaryNode<String> buildTree(Collection<String> c) {
        LinkedList<BinaryNode<String>> list = new LinkedList<>();

        for (String e : c) {
            list.add(new BinaryNode<>(e));
        }

        for (int i = 0; i < c.size(); i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }

        return list.getFirst();
    }
}
