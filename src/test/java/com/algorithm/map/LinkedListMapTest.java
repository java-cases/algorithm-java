package com.algorithm.map;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListMapTest {

    @Test
    public void put() {
        Map<Integer, Integer> map = buildMap();

        assertThat(map.size(), Matchers.equalTo(10));

        map.put(1, 1);
        map.put(2, 2);
        assertThat(map.size(), Matchers.equalTo(10));
    }

    private Map<Integer, Integer> buildMap() {
        Map<Integer, Integer> map = new LinkedListMap<>();

        for (int i = 1; i <= 10; i++) {
            map.put(i, i);
        }
        return map;
    }

    @Test
    public void remove() {
        Map<Integer, Integer> map = buildMap();

        for (int i = 1; i <= 10; i++) {
            assertThat(map.remove(i), Matchers.equalTo(i));
        }

        for (int i = 1; i <= 10; i++) {
            assertThat(map.contains(i), Matchers.equalTo(false));
        }

        assertThat(map.size(), Matchers.equalTo(0));
        assertThat(map.isEmpty(), Matchers.equalTo(true));
    }

    @Test
    public void contains() {
        Map<Integer, Integer> map = buildMap();

        for (int i = 1; i <= 10; i++) {
            assertThat(map.contains(i), Matchers.equalTo(true));
        }

        assertThat(map.contains(0), Matchers.equalTo(false));
        assertThat(map.contains(11), Matchers.equalTo(false));
    }

    @Test
    public void get() {
        Map<Integer, Integer> map = buildMap();

        for (int i = 1; i <= 10; i++) {
            assertThat(map.get(i), Matchers.equalTo(i));
        }

        map.set(1, 100);
        assertThat(map.get(1), Matchers.equalTo(100));
    }

    @Test
    public void set() {
        Map<Integer, Integer> map = buildMap();

        map.set(1, 10);
        assertThat(map.get(1), Matchers.equalTo(10));

        map.set(10, 100);
        assertThat(map.get(10), Matchers.equalTo(100));
    }

    @Test
    public void size() {
        Map<Integer, Integer> map = buildMap();
        assertThat(map.size(), Matchers.equalTo(10));

        assertThat(new LinkedListMap<>().size(), Matchers.equalTo(0));
    }

    @Test
    public void isEmpty() {
        Map<Integer, Integer> map = buildMap();
        assertThat(map.isEmpty(), Matchers.equalTo(false));

        assertThat(new LinkedListMap<>().isEmpty(), Matchers.equalTo(true));
    }

    @Test
    public void entrySet() {
        Map<Integer, Integer> map = buildMap();

        assertThat(map.entrySet().size(), Matchers.equalTo(10));

        for (int i = 1; i <= 10; i++) {
            int key = i;
            assertThat(map.entrySet().stream().anyMatch(x -> x.key == key), Matchers.equalTo(true));
        }
    }

    @Test
    public void keySet() {
        Map<Integer, Integer> map = buildMap();

        assertThat(map.keySet().size(), Matchers.equalTo(10));

        for (int i = 1; i <= 10; i++) {
            assertThat(map.keySet().contains(i), Matchers.equalTo(true));
        }

        System.out.println(map.keySet());
    }

    @Test
    public void values() {
        Map<Integer, Integer> map = buildMap();

        assertThat(map.values().size(), Matchers.equalTo(10));

        for (int i = 1; i <= 10; i++) {
            assertThat(map.values().contains(i), Matchers.equalTo(true));
        }

        map.set(1, 10);
        assertThat(map.values().size(), Matchers.equalTo(10));

        System.out.println(map.values());
    }
}