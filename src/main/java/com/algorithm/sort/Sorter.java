package com.algorithm.sort;

import java.util.Objects;

public interface Sorter<T extends Comparable<T>> {

    void sort(T[] items);

    default void swap(T[] items, int foreIndex, int backIndex) {
        checkIndex(items, foreIndex, "Invalid foreIndex: ");
        checkIndex(items, backIndex, "Invalid backIndex: ");

        T temp = items[foreIndex];
        items[foreIndex] = items[backIndex];
        items[backIndex] = temp;
    }

    default Boolean less(T thisItem, T otherItem) {
        Objects.requireNonNull(thisItem);
        return thisItem.compareTo(otherItem) < 0;
    }

    default Boolean greater(T thisItem, T otherItem) {
        Objects.requireNonNull(thisItem);
        return thisItem.compareTo(otherItem) > 0;
    }

    default void checkIndex(T[] items, int index, String msg) {
        Objects.requireNonNull(items);
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException(msg + index);
        }
    }

}
