package com.algorithm.linked;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void addFirst() {
        LinkedList<Integer> list = buildList();

        assertThat(list.size(), Matchers.equalTo(5));

        assertThat(list.getFirst(), Matchers.equalTo(4));
        assertThat(list.getLast(), Matchers.equalTo(0));
    }

    private LinkedList buildList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        return list;
    }

    @Test
    public void addLast() {
        LinkedList<Integer> list = buildLastList();

        assertThat(list.size(), Matchers.equalTo(5));

        assertThat(list.getFirst(), Matchers.equalTo(0));
        assertThat(list.getLast(), Matchers.equalTo(4));
    }

    private LinkedList buildLastList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }

        return list;
    }

    @Test
    public void getFirst() {
        LinkedList<Integer> list = buildLastList();

        assertThat(list.getFirst(), Matchers.equalTo(0));
    }

    @Test
    public void getLast() {
        LinkedList<Integer> list = buildLastList();

        assertThat(list.getLast(), Matchers.equalTo(4));
    }

    @Test
    public void removeFirst() {
        LinkedList<Integer> list = buildLastList();

        Integer element=list.removeFirst();
        assertThat(element, Matchers.equalTo(0));

        assertThat(list.size(), Matchers.equalTo(4));
        assertThat(list.isEmpty(), Matchers.is(false));
    }

    @Test
    public void removeLast() {
        LinkedList<Integer> list = buildLastList();

        Integer element=list.removeLast();
        assertThat(element, Matchers.equalTo(4));

        assertThat(list.size(), Matchers.equalTo(4));
        assertThat(list.isEmpty(), Matchers.is(false));
    }

    @Test
    public void isEmpty() {
        LinkedList<Integer> list = buildList();
        assertThat(list.isEmpty(), Matchers.equalTo(false));

        assertThat(new LinkedList().isEmpty(), Matchers.equalTo(true));
    }

    @Test
    public void size() {
        LinkedList<Integer> list = buildList();
        assertThat(list.size(), Matchers.equalTo(5));

        assertThat(new LinkedList().size(), Matchers.equalTo(0));
    }
}