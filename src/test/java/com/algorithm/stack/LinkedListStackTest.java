package com.algorithm.list;

import com.algorithm.stack.LinkedListStack;
import com.algorithm.stack.Stack;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListStackTest {

    @Test
    public void push() {
        Stack<Integer> stack = buildStack();

        assertThat(stack.size(), Matchers.equalTo(5));
    }

    private Stack<Integer> buildStack() {
        Stack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        return stack;
    }

    @Test
    public void pop() {
        Stack<Integer> stack = buildStack();

        for (int i = 0; i < 4; i++) {
            stack.pop();
        }
        assertThat(stack.size(), Matchers.equalTo(1));
        assertThat(stack.isEmpty(), Matchers.is(false));

        Integer element = stack.pop();
        assertThat(element, Matchers.equalTo(0));

        assertThat(stack.size(), Matchers.equalTo(0));
        assertThat(stack.isEmpty(), Matchers.is(true));
    }

    @Test
    public void peek() {
        Stack<Integer> stack = buildStack();

        for (int i = 0; i < 4; i++) {
            stack.peek();
        }
        assertThat(stack.size(), Matchers.equalTo(5));
        assertThat(stack.isEmpty(), Matchers.is(false));

        Integer element = stack.peek();
        assertThat(element, Matchers.equalTo(4));

        assertThat(stack.size(), Matchers.equalTo(5));
        assertThat(stack.isEmpty(), Matchers.is(false));
    }

    @Test
    public void size() {
        Stack<Integer> stack = buildStack();
        assertThat(stack.size(), Matchers.equalTo(5));

        assertThat(new LinkedListStack<>().size(), Matchers.equalTo(0));
    }

    @Test
    public void isEmpty() {
        Stack<Integer> stack = buildStack();
        assertThat(stack.isEmpty(), Matchers.is(false));

        assertThat(new LinkedListStack<>().isEmpty(), Matchers.is(true));
    }
}