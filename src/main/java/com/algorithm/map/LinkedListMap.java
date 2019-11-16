package com.algorithm.map;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedListMap<K extends Comparable<K>, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>> list;

    public LinkedListMap() {
        this.list = new LinkedList<>();
    }

    private Entry<K, V> getNode(K key) {
        return list.stream()
                .filter(x -> x.key.equals(key))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = getNode(key);
        if (entry == null) {
            list.add(new Entry<>(key, value));
        } else {
            entry.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = getNode(key);
        if (entry == null) {
            return null;
        }

        this.list.removeIf(x -> x.key.equals(key));
        return entry.value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = getNode(key);
        return entry == null ? null : entry.value;
    }

    @Override
    public void set(K key, V newValue) {
        Entry<K, V> entry = getNode(key);
        if (entry == null) {
            throw new IllegalArgumentException(key + "dose not exist");
        }
        entry.value = newValue;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.list.stream().collect(Collectors.toSet());
    }

    @Override
    public Set<K> keySet() {
        return this.list.stream()
                .map(x -> x.key)
                .collect(Collectors.toSet());
    }

    @Override
    public List<V> values() {
        return this.list.stream()
                .map(x -> x.value)
                .collect(Collectors.toList());
    }
}
