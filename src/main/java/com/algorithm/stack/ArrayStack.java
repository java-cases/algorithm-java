package com.algorithm.stack;

import com.algorithm.array.Array;

public class ArrayStack<E> implements Stack<E>{
    private Array<E> array;

    public ArrayStack(int capacity){
        array=Array.resizable(capacity);
    }

    public ArrayStack(){
        array=Array.resizable();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        E ele=array.get(array.size()-1);
        return ele;
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder ret=new StringBuilder();
        ret.append("Stack: ");
        ret.append("[");
        for(int i = 0; i<array.size(); i++){
            ret.append(array.get(i));
            if(i!=array.size()-1){
                ret.append(", ");
            }
        }
        ret.append("] top");
        return ret.toString();
    }
}
