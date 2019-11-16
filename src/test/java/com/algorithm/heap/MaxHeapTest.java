package com.algorithm.heap;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void add() {
        MaxHeap<Integer> heap = buildHeap();

        assertThat(heap.size(), Matchers.equalTo(10));
        assertThat(heap.isEmpty(), Matchers.equalTo(false));
        assertThat(heap.max(), Matchers.equalTo(62));

        System.out.println(heap);
    }

    private MaxHeap<Integer> buildHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.add(13);
        heap.add(15);
        heap.add(16);
        heap.add(17);
        heap.add(19);
        heap.add(22);
        heap.add(28);
        heap.add(30);
        heap.add(41);
        heap.add(62);
        return heap;
    }

    @Test
    public void of() {
        Integer[] arr = {13, 15, 16, 17, 19, 22, 28, 30, 41, 62};
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.of(arr);

        assertThat(heap.size(), Matchers.equalTo(10));
        assertThat(heap.isEmpty(), Matchers.equalTo(false));
        assertThat(heap.max(), Matchers.equalTo(62));

        System.out.println(heap);
    }

    @Test
    public void size() {
        MaxHeap<Integer> heap = buildHeap();
        assertThat(heap.size(), Matchers.equalTo(10));

        assertThat(new MaxHeap().size(), Matchers.equalTo(0));
    }

    @Test
    public void isEmpty() {
        MaxHeap<Integer> heap = buildHeap();
        assertThat(heap.isEmpty(), Matchers.equalTo(false));

        assertThat(new MaxHeap().isEmpty(), Matchers.equalTo(true));
    }

    @Test
    public void max() {
        MaxHeap<Integer> heap = buildHeap();
        assertThat(heap.max(), Matchers.equalTo(62));

        heap.add(63);
        assertThat(heap.max(), Matchers.equalTo(63));
    }

    @Test
    public void removeMax() {
        MaxHeap<Integer> heap = buildHeap();
        System.out.println(heap);

        assertThat(heap.removeMax(), Matchers.equalTo(62));
        assertThat(heap.max(), Matchers.equalTo(41));
        assertThat(heap.size(), Matchers.equalTo(9));

        System.out.println(heap);
    }

    @Test
    public void replaceMax() {
        MaxHeap<Integer> heap = buildHeap();

        assertThat(heap.replaceMax(63), Matchers.equalTo(62));
        assertThat(heap.max(), Matchers.equalTo(63));
        assertThat(heap.size(), Matchers.equalTo(10));

        System.out.println(heap);

        assertThat(heap.replaceMax(40), Matchers.equalTo(63));
        assertThat(heap.max(), Matchers.equalTo(41));
        assertThat(heap.size(), Matchers.equalTo(10));

        System.out.println(heap);
    }
}