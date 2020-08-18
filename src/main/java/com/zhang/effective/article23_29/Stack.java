package com.zhang.effective.article23_29;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author zhang
 * @Description 简单的堆栈实现
 * @Date 2020-08-10 14:29
 * @Version 1.0
 **/
public class Stack<E> {

    private E[] elements;

    private int size = 0;

    public static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        System.out.println(1 << 4);
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

}
