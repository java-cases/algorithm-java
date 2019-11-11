package com.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BubbleSorterTest {

    @Test
    public void sort() {
        Integer[] items = new Integer[]{1, 2, 3, 4, 5};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

    @Test
    public void sortReverse() {
        Integer[] items = new Integer[]{5,4,3,2,1};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

    @Test
    public void sortRandom() {
        Integer[] items = new Integer[]{2,4,3,5,1};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

    @Test
    public void sortLong() {
        Long[] items = new Long[]{2L, 4L, 3L, 5L, 1L};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

    @Test
    public void sortFloat() {
        Float[] items = new Float[]{2f, 4f, 3f, 5f, 1f};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

    @Test
    public void sortDouble() {
        Double[] items = new Double[]{2d, 4d, 3d, 5d, 1d};
        Sorter sorter = new BubbleSorter();

        sorter.sort(items);
        System.out.println(Arrays.toString(items));

        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(items[i].compareTo(items[i + 1]) < 0);
        }
    }

}