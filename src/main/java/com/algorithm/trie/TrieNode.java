package com.algorithm.trie;

import java.util.TreeMap;

public class TrieNode {
    private boolean isWord;//标记该字符是否是单词结尾
    private TreeMap<Character, TrieNode> next;

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public TreeMap<Character, TrieNode> getNext() {
        return next;
    }

    public void setNext(TreeMap<Character, TrieNode> next) {
        this.next = next;
    }

    public TrieNode() {
        this(false);
    }

    public TrieNode(boolean isWord) {
        this.setWord(isWord);
        setNext(new TreeMap<>());
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "isWord=" + isWord +
                ", next.keySet=" + next.keySet() +
                '}';
    }
}
