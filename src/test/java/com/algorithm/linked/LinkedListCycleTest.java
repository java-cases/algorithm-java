package com.algorithm.linked;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class LinkedListCycleTest {

    @Test
    public void hasCycle() {
        CycleLinkedList<Integer> list = new CycleLinkedList<>();

        CycleLinkedList.Node<Integer> cycle = list.add(1).next(2);
        assertThat(list.hasCycle(), Matchers.equalTo(false));

        cycle.next(3).next(4).next(5).next(cycle);
        assertThat(list.hasCycle(), Matchers.equalTo(true));
    }

    @Test
    public void findCycle() {
        CycleLinkedList<Integer> list = new CycleLinkedList<>();

        CycleLinkedList.Node<Integer> cycle = list.add(1).next(2);
        assertThat(list.findCycle(), Matchers.nullValue());

        cycle.next(3).next(4).next(5).next(cycle);
        assertThat(list.findCycle(), Matchers.notNullValue());
        assertThat(list.findCycle().item, Matchers.equalTo(2));
    }
}