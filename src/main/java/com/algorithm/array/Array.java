package com.algorithm.array;

import java.util.Iterator;

public interface Array<E> extends Iterable<E>{
    Iterator<E> iterator();

    int size();

    int getCapacity();

    boolean isEmpty();

    //在index位置插入元素
    void add(int index, E e);

    void addFirst(E e);

    void addLast(E e);

    //获取index位置的元素
    E get(int index);

    //设置index位置元素值为e
    E set(int index, E e);

    boolean contains(E e);

    //查找数组中是否有元素e,有就返回下标，没有就返回-1
    int indexOf(E e);

    //删除指定位置元素
    E remove(int index);

    void remove(E e);

    E removeFirst();

    E removeLast();


    static <E> Array<E> fixed(int capacity) {
        return new FixedSizeArray<>(capacity);
    }

    static <E> Array<E> fixed() {
        return new FixedSizeArray<>();
    }

    static <E> Array<E> resizable(int capacity) {
        return new ResizableArray<>(capacity);
    }

    static <E> Array<E> resizable() {
        return new ResizableArray<>();
    }
}
