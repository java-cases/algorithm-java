package com.algorithm.set;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class LinkedListSetTest {

    @Test
    public void add() {
        Set<Integer> set = buildSet();

        assertThat(set.size(), Matchers.equalTo(5));
        assertThat(set.isEmpty(), Matchers.equalTo(false));
    }

    private Set<Integer> buildSet() {
        Set<Integer> set = new BinaryTreeSet<>();
        for (int i = 1; i < 6; i++) {
            set.add(i);
        }

        set.add(1);
        set.add(2);

        return set;
    }

    @Test
    public void remove() {
        Set<Integer> set = buildSet();

        for (int i = 1; i < 5; i++) {
            set.remove(i);
        }

        assertThat(set.size(), Matchers.equalTo(1));
        assertThat(set.isEmpty(), Matchers.equalTo(false));
        assertThat(set.contains(1), Matchers.equalTo(false));
        assertThat(set.contains(5), Matchers.equalTo(true));

        set.remove(5);

        assertThat(set.size(), Matchers.equalTo(0));
        assertThat(set.isEmpty(), Matchers.equalTo(true));
        assertThat(set.contains(1), Matchers.equalTo(false));
        assertThat(set.contains(5), Matchers.equalTo(false));
    }

    @Test
    public void contains() {
        Set<Integer> set = buildSet();

        for (int i = 1; i < 6; i++) {
            assertThat(set.contains(i), Matchers.equalTo(true));
        }

        assertThat(set.contains(0), Matchers.equalTo(false));
        assertThat(set.contains(6), Matchers.equalTo(false));
    }

    @Test
    public void size() {
        Set<Integer> set = buildSet();
        assertThat(set.size(), Matchers.equalTo(5));

        assertThat(new BinaryTreeSet<>().size(), Matchers.equalTo(0));
    }

    @Test
    public void isEmpty() {
        Set<Integer> set = buildSet();
        assertThat(set.isEmpty(), Matchers.equalTo(false));

        assertThat(new BinaryTreeSet<>().isEmpty(), Matchers.equalTo(true));
    }
}