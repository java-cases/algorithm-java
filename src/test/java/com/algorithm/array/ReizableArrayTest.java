package com.algorithm.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ReizableArrayTest {

    @Test
    public void add() {
        Array<String> array = Array.resizable();

        for (int i = 0; i < 10; i++) {
            array.add(i, String.valueOf(i));
        }

        System.out.println(array);
        assertThat(array.size(), Matchers.equalTo(10));
    }

    @Test
    public void addOutOfCapacity() {
        Array<String> array = Array.resizable();

        for (int i = 0; i < 10; i++) {
            array.add(i, String.valueOf(i));
        }

        array.add(10, String.valueOf(10));
        assertThat(array.get(10), Matchers.is("10"));

        array.addFirst(String.valueOf(-1));
        assertThat(array.get(0), Matchers.is("-1"));

        array.addLast(String.valueOf(12));
        assertThat(array.get(12), Matchers.is("12"));
    }

    @Test
    public void remove() {
        Array<String> array = Array.resizable();
        array.addLast("0");

        assertThat(array.remove(0), Matchers.is("0"));

        assertThat(array.indexOf("0"), Matchers.is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOutOfRange() {
        Array<String> array = Array.resizable();
        array.addLast("0");

        array.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEmpty() {
        Array<String> array = Array.resizable();
        array.remove(0);
    }
}