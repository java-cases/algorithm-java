package com.algorithm.heap;

import java.util.Arrays;

public class MaxHeap<E extends Comparable<E>> {
    private E[] items;
    private int size; //记录堆中元素个数

    public MaxHeap(int capacity) {
        items = (E[]) new Comparable[capacity];
    }

    public MaxHeap() {
        this(10);
    }

    //heapify：将任意数组整理成堆的形状
    public MaxHeap<E> of(final E[] arr) {
        items = Arrays.copyOf(arr, arr.length);

        size = arr.length;
        for (int i = parentArrayIndex(arr.length - 1); i >= 0; i--) {
            sink(i);
        }

        return this;
    }

    //返回堆中元素个数
    public int size() {
        return size;
    }

    //判断堆是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向堆中添加元素
    //时间复杂度 O(log n)
    public void add(E element) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[size] = element;
        size++;

        swim(size - 1);
    }

    //调整数组大小
    private void resize(int newCapacity) {
        E[] newData = Arrays.copyOf(items, newCapacity);
        items = newData;
    }

    //对索引为index的元素，进行上浮操作，得到一个新的最大堆
    private void swim(final int index) {
        int i = index;

        while (i > 0 && greaterThanParent(i)) {
            swap(i, parentArrayIndex(i));

            i = parentArrayIndex(i);
        }
    }

    private boolean greaterThanParent(int index) {
        int parentIndex = parentArrayIndex(index);
        return items[index].compareTo(items[parentIndex]) > 0;
    }

    //返回一个索引的父节点的索引
    private int parentArrayIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 does not have parment");
        }

        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //查看堆中最大元素
    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("Can not find max when maxheap is empty!");
        }
        return items[0];
    }

    //从堆中取出元素
    //时间复杂度O(log n)
    public E removeMax() {
        if (size == 0) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }

        E ret = max();
        swap(0, size - 1);
        size--;
        sink(0);
        return ret;
    }

    private void sink(final int index) {
        int k = index;

        //leftChildArrayIndex(k)<size 下标为k的元素存在左子树
        while (leftChildArrayIndex(k) < size) {
            int j = leftChildArrayIndex(k);
            if (j + 1 < size && items[j].compareTo(items[j + 1]) < 0) {
                j = j + 1;
            }

            //j是data[leftChildArrayIndex(k)]和data[rightChildArrayIndex(k)]的较大值的下标
            if (items[k].compareTo(items[j]) >= 0) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    //返回一个索引的左孩子节点的索引
    private int leftChildArrayIndex(int index) {
        return 2 * index + 1;
    }

    //返回一个索引的左孩子节点的索引
    private int rightChildArrayIndex(int index) {
        return 2 * index + 2;
    }

    //replaceMax：取出最大元素后，放入新元素
    public E replaceMax(E element) {
        E ret = items[0];
        items[0] = element;

        sink(0);
        return ret;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }
}
