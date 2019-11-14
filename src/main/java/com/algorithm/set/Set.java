package com.algorithm.set;

public interface Set<E extends Comparable<E>> {
    boolean add(E element);

    boolean remove(E element);

    boolean contains(E element);

    int size();

    boolean isEmpty();
}
