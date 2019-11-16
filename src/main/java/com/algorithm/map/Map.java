package com.algorithm.map;

import java.util.List;
import java.util.Set;

public interface Map<K extends Comparable<K>, V> {

    void put(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int size();

    boolean isEmpty();

    Set<K> keySet();

    Set<Entry<K, V>> entrySet();

    List<V> values();
}
