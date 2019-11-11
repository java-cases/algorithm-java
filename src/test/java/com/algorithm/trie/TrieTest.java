package com.algorithm.trie;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class TrieTest {

    @Test
    public void getSize() {
        Trie trie = new Trie();
        assertThat(trie.getSize(), Matchers.equalTo(0));

        trie = buildTrie();
        assertThat(trie.getSize(), Matchers.equalTo(4));
    }

    @Test
    public void add() {
        Trie trie = buildTrie();

        System.out.println(trie);
        assertThat(trie.getSize(), Matchers.equalTo(4));
    }

    private static Trie buildTrie() {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        trie.add("hello world");
        trie.add("hello moto");

        return trie;
    }

    @Test
    public void contains() {
        Trie trie = buildTrie();

        assertThat(trie.contains("hello"), Matchers.is(true));
        assertThat(trie.contains("world"), Matchers.is(true));

        assertThat(trie.contains("hello-absent"), Matchers.is(false));
    }

    @Test
    public void isPrefix() {
        Trie trie = buildTrie();

        assertThat(trie.isPrefix("hell"), Matchers.is(true));
        assertThat(trie.isPrefix("hello"), Matchers.is(true));

        assertThat(trie.isPrefix("hello-absent"), Matchers.is(false));
    }
}