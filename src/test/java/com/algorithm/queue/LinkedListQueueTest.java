package com.algorithm.queue;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {



    @Test
    public void enqueue() {
        Queue<Integer> queue = buildQueue();

        assertThat(queue.size(), Matchers.equalTo(5));
    }

    private Queue<Integer> buildQueue() {
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        return queue;
    }

    @Test
    public void dequeue() {
        Queue<Integer> queue = buildQueue();

        for (int i = 0; i < 4; i++) {
            queue.dequeue();
        }

        assertThat(queue.size(), Matchers.equalTo(1));
        assertThat(queue.isEmpty(), Matchers.is(false));

        Integer element = queue.dequeue();
        assertThat(element, Matchers.equalTo(4));

        assertThat(queue.size(), Matchers.equalTo(0));
        assertThat(queue.isEmpty(), Matchers.is(true));
    }

    @Test
    public void element() {
        Queue<Integer> queue = buildQueue();

        for (int i = 0; i < 4; i++) {
            queue.element();
        }
        assertThat(queue.size(), Matchers.equalTo(5));
        assertThat(queue.isEmpty(), Matchers.is(false));

        Integer element = queue.element();
        assertThat(element, Matchers.equalTo(0));

        assertThat(queue.size(), Matchers.equalTo(5));
        assertThat(queue.isEmpty(), Matchers.is(false));
    }

    @Test
    public void size() {
        Queue<Integer> queue = buildQueue();
        assertThat(queue.size(), Matchers.equalTo(5));

        assertThat(new LinkedListQueue<>().size(), Matchers.equalTo(0));
    }

    @Test
    public void isEmpty() {
        Queue<Integer> queue = buildQueue();
        assertThat(queue.isEmpty(), Matchers.is(false));

        assertThat(new LinkedListQueue<>().isEmpty(), Matchers.is(true));
    }
}