package com.zhang.effective.article06;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author zhang
 * @Description 消除过期对象的引用
 * @Date 2020-01-19 16:28
 * @Version 1.0
 **/
public class Stack {

    private Object[] elements;

    private int size = 0;

    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        //elements[size] == null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

}
