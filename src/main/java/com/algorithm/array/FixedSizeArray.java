package com.algorithm.array;

public class FixedSizeArray<E> extends AbstractArray<E> implements Array<E> {

    public static final int DEFAULT_CAPACITY=10;

    public FixedSizeArray(int capacity) {
        super(capacity);
    }

    //默认数组的容量是10
    public FixedSizeArray() {
        this(DEFAULT_CAPACITY);
    }

    //在index位置插入元素
    @Override
    public void add(int index, E e) {
        if (size == items.length) {
            throw new IllegalArgumentException("Add failed, array is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed,0 <= index <= size is required.");
        }

        //index位置后的元素向右移动
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = e;
        size++;
    }

    //删除指定位置元素
    @Override
    public E remove(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("Remove failed, array is empty.");
        }

        checkIndexRange(index, "Remove failed, index is illegal.");

        E ret = (E) items[index];

        for (int i = index + 1; i < size; i++) {
            items[i - 1] = items[i];
        }

        size--;
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("FixedSizeArray size=%d,capacity=%d\n", size, items.length));
        builder.append("[");

        for (int i = 0; i < size; i++) {
            builder.append(items[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
