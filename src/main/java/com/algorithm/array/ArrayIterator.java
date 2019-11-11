package com.algorithm.array;

import java.util.Iterator;
import java.util.Objects;

public class ArrayIterator<E> implements Iterator<E> {

    private E[] items;
    private int position = 0;

    public ArrayIterator(E[] items) {
        Objects.requireNonNull(items);

        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }

    @Override
    public E next() {
        return items[position++];
    }
}
