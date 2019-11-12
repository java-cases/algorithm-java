package com.algorithm.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] items;
    private int frontIndex;
    private int tailIndex;
    private int size;

    public LoopQueue(int capacity) {
        //循环队列会浪费一个单位空间
        items = (E[]) new Object[capacity + 1];

        frontIndex = 0;
        tailIndex = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return items.length - 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == tailIndex;
    }

    @Override
    public void enqueue(E element) {
        //入队操作，先判断队列是否满了
        if ((tailIndex + 1) % items.length == frontIndex) {
            resize(getCapacity() * 2);
        }

        items[tailIndex] = element;
        tailIndex = (tailIndex + 1) % items.length;

        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("con not dequeue from empty queue");
        }

        E ret = items[frontIndex];
        items[frontIndex] = null;
        frontIndex = (frontIndex + 1) % items.length;

        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new IllegalArgumentException("con not dequeue from empty queue");
        }

        return items[frontIndex];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = items[(i + frontIndex) % items.length];
        }
        items = newData;
        frontIndex = 0;
        tailIndex = size;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("LooPQueue: size=%d,capacity=%d\n", size, getCapacity()));
        ret.append("font [");

        for (int i = frontIndex; i != tailIndex; i = (i + 1) % items.length) {
            ret.append(items[i]);

            if ((i + 1) % items.length != tailIndex) {
                ret.append(", ");
            }
        }

        ret.append("] tailIndex");

        return ret.toString();
    }
}
