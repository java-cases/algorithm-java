package com.algorithm.stack;

import com.algorithm.array.ResizableArray;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class StackTest {

    @Test
    public void getSize() {
        Stack<Integer> stack = Stack.array();
        assertThat(stack.size(), Matchers.equalTo(0));

        stack.push(1);
        assertThat(stack.size(), Matchers.equalTo(1));

        stack.push(2);
        assertThat(stack.size(), Matchers.equalTo(2));
    }

    @Test
    public void isEmpty() {
        Stack<Integer> stack = Stack.array();
        assertThat(stack.isEmpty(), Matchers.equalTo(true));

        stack.push(1);
        assertThat(stack.isEmpty(), Matchers.equalTo(false));
    }

    @Test
    public void push() {
        Stack<Integer> stack = Stack.array();
        for (int i = 1; i <= 10000; i++) {
            stack.push(i);
        }

        assertThat(stack.size(), Matchers.equalTo(10000));
    }

    @Test
    public void pop() {
        Stack<Integer> stack = Stack.array();
        for (int i = 1; i <= 10000; i++) {
            stack.push(i);
        }

        Integer item = stack.pop();

        assertThat(item, Matchers.equalTo(10000));
        assertThat(stack.size(), Matchers.equalTo(9999));
    }

    @Test
    public void peek() {
        Stack<Integer> stack = Stack.array();
        for (int i = 1; i <= 10000; i++) {
            stack.push(i);
        }

        Integer item = stack.peek();

        assertThat(item, Matchers.equalTo(10000));
        assertThat(stack.size(), Matchers.equalTo(10000));
    }

    @Test
    public void getCapacity() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertThat(stack.getCapacity(), Matchers.equalTo(ResizableArray.DEFAULT_CAPACITY));

        for (int i = 1; i <= 10000; i++) {
            stack.push(i);
        }

        assertThat(stack.getCapacity(), Matchers.equalTo(10240));
    }
}