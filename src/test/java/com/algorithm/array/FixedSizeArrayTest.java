package com.algorithm.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixedSizeArrayTest {

    @Test
    public void add() {
        Array<String> array = Array.fixed();

        for (int i = 0; i < 10; i++) {
            array.add(i, String.valueOf(i));
        }

        System.out.println(array);
        assertThat(array.size(), Matchers.equalTo(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOutOfCapacity() {
        Array<String> array = Array.fixed();

        for (int i = 0; i < 10; i++) {
            array.add(i, String.valueOf(i));
        }

        array.add(11, String.valueOf(11));
    }

    @Test
    public void remove() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        assertThat(array.remove(0), Matchers.is("0"));

        assertThat(array.find("0"), Matchers.is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOutOfRange() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        array.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEmpty() {
        Array<String> array = Array.fixed();
        array.remove(0);
    }
}