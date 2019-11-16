package com.algorithm.map;

import com.algorithm.binarysearchtree.BinaryTree;
import com.algorithm.binarysearchtree.RecursiveBinaryTree;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BinaryTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BinaryTree<Entry<K, V>> tree;

    public BinaryTreeMap() {
        this.tree = new RecursiveBinaryTree<>();
    }

    private Entry<K, V> getNode(K key) {
        List<Entry<K, V>> list = tree.find(x -> x.key.equals(key));
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = getNode(key);
        if (entry == null) {
            tree.add(new Entry<>(key, value));
        } else {
            entry.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = this.getNode(key);
        if (entry == null) {
            return null;
        }

        tree.remove(entry);

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
        return this.tree.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        List<Entry<K, V>> items = this.tree.inorder();
        return items.stream().collect(Collectors.toSet());
    }

    @Override
    public Set<K> keySet() {
        Set<Entry<K, V>> items = this.entrySet();
        return items.stream().map(x -> x.key).collect(Collectors.toSet());
    }

    @Override
    public List<V> values() {
        Set<Entry<K, V>> items = this.entrySet();
        return items.stream().map(x -> x.value).collect(Collectors.toList());
    }
}
