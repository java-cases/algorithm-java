package com.algorithm.map;

public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

    public K key;
    public V value;

    public Entry(K key) {
        this(key, null);
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Entry<K, V> o) {
        if (o == null) {
            return 1;
        }

        if (this.key.compareTo(o.key) != 0) {
            return this.key.compareTo(o.key);
        }

        return 0;
    }
}
