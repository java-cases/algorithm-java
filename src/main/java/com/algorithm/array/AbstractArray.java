package com.algorithm.array;

import java.util.Arrays;
import java.util.Iterator;

public abstract class AbstractArray<E> implements Array<E> {
    protected E[] items;
    protected int size;

    public AbstractArray(int capacity) {
        items = (E[]) new Object[capacity];
        size = 0;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator<>(Arrays.copyOf(items, size));
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    //在index位置插入元素
    public abstract void add(int index, E e);

    public void addFirst(E e) {
        add(0, e);
    }

    //获取index位置的元素
    public E get(int index) {
        checkIndexRange(index, "Get failed, index is illegal.");

        return (E) items[index];
    }

    protected void checkIndexRange(int index, String msg) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(msg);
        }
    }

    //设置index位置元素值为e
    public void set(int index, E e) {
        checkIndexRange(index, "Set failed, index is illegal.");

        items[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (items[i] == e) {
                return true;
            }

            if (items[i] != null && items[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    //查找数组中是否有元素e,有就返回下标，没有就返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (items[i] == e) {
                return i;
            }

            if (items[i] != null && items[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    //删除指定位置元素
    public abstract E remove(int index);

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);

        if (index != -1) {
            remove(index);
        }
    }
}
