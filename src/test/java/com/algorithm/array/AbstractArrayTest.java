package com.algorithm.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class AbstractArrayTest {

    @Test
    public void getSize() {
        Array<String> array = Array.fixed();
        assertThat(array.size(), Matchers.equalTo(0));

        array.addFirst("1");
        assertThat(array.size(), Matchers.equalTo(1));

        array.addFirst("2");
        assertThat(array.size(), Matchers.equalTo(2));
    }

    @Test
    public void getCapacity() {
        Array<String> array = Array.fixed();
        assertThat(array.getCapacity(), Matchers.equalTo(10));

        array = Array.fixed(11);
        assertThat(array.getCapacity(), Matchers.equalTo(11));
    }

    @Test
    public void isEmpty() {
        Array<String> array = Array.fixed();
        assertThat(array.isEmpty(), Matchers.is(true));

        array.addFirst("1");
        assertThat(array.isEmpty(), Matchers.is(false));

        array.removeElement("1");
        assertThat(array.isEmpty(), Matchers.is(true));
    }

    @Test
    public void addFirst() {
        Array<String> array = Array.fixed();

        array.addFirst("0");
        assertThat(array.size(), Matchers.equalTo(1));

        array.addFirst("1");
        assertThat(array.size(), Matchers.equalTo(2));

        System.out.println(array);

        assertThat(array.get(0), Matchers.equalTo("1"));
        assertThat(array.get(1), Matchers.equalTo("0"));
    }

    @Test
    public void addLast() {
        Array<String> array = Array.fixed();

        array.addLast("0");
        assertThat(array.size(), Matchers.equalTo(1));

        array.addLast("1");
        assertThat(array.size(), Matchers.equalTo(2));

        System.out.println(array);

        assertThat(array.get(0), Matchers.equalTo("0"));
        assertThat(array.get(1), Matchers.equalTo("1"));
    }

    @Test
    public void get() {
        Array<String> array = Array.fixed();
        array.addLast("0");
        array.addLast("1");

        assertThat(array.get(0), Matchers.equalTo("0"));
        assertThat(array.get(1), Matchers.equalTo("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFromEmpty() {
        Array<String> array = Array.fixed();
        array.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLessThan0() {
        Array<String> array = Array.fixed();
        array.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOutOfSize() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        array.get(array.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIndexRange() {
        Array<String> array = Array.fixed();
        array.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIndexRangeOutOfSize() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        array.get(array.size());
    }

    @Test
    public void set() {
        Array<String> array = Array.fixed();
        array.addLast("0");
        array.addLast(null);

        array.set(0, null);
        array.set(1, "0");

        assertThat(array.get(0), Matchers.nullValue());
        assertThat(array.get(1), Matchers.is("0"));
    }

    @Test
    public void contains() {
        Array<String> array = Array.fixed();
        array.addLast("0");
        array.addLast(null);

        assertThat(array.contains("0"), Matchers.is(true));
        assertThat(array.contains(null), Matchers.is(true));

        assertThat(array.contains("1"), Matchers.is(false));
    }

    @Test
    public void find() {
        Array<String> array = Array.fixed();
        array.addLast("0");
        array.addLast(null);

        assertThat(array.find("0"), Matchers.is(0));
        assertThat(array.find(null), Matchers.is(1));

        assertThat(array.find("1"), Matchers.is(-1));
    }

    @Test
    public void remove() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        assertThat(array.remove(0), Matchers.is("0"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEmpty() {
        Array<String> array = Array.fixed();
        array.remove(0);
    }

    @Test
    public void removeFirst() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        assertThat(array.removeFirst(), Matchers.is("0"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFirstFromEmpty() {
        Array<String> array = Array.fixed();
        array.removeFirst();
    }

    @Test
    public void removeLast() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        assertThat(array.removeLast(), Matchers.is("0"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeLastFromEmpty() {
        Array<String> array = Array.fixed();
        array.removeLast();
    }

    @Test
    public void removeElement() {
        Array<String> array = Array.fixed();
        array.addLast("0");

        array.removeElement("0");
        assertThat(array.size(), Matchers.is(0));
    }

    @Test
    public void removeElementFromEmpty() {
        Array<String> array = Array.fixed();
        array.removeElement("0");
    }

    @Test
    public void foreach() {
        Array<String> array = Array.fixed();
        array.addLast("1");
        array.addLast("2");
        array.addLast("3");

        array.forEach(x -> System.out.println(x));
    }

    @Test
    public void foreachItem() {
        Array<String> array = Array.fixed();
        array.addLast("1");
        array.addLast("2");
        array.addLast("3");

        for (String e : array) {
            System.out.println(e);
        }
    }

    @Test
    public void iterator() {
        Array<String> array = Array.fixed();
        array.addLast("1");
        array.addLast("2");
        array.addLast("3");

        Iterator<String> iterator = array.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}