package com.zhang.effective.article12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author zhang
 * @Description 考虑实现Comparable接口
 * @Date 2020-07-08 13:45
 * @Version 1.0
 **/
public class Test implements Comparable<Serializable> {

    public static void main(String[] args) {
        Set<BigDecimal> set = new HashSet<>();
        set.add(new BigDecimal("1.0"));
        set.add(new BigDecimal("1.00"));
        Set<BigDecimal> set1 = new TreeSet<>();
        set1.add(new BigDecimal("1.0"));
        set1.add(new BigDecimal("1.00"));
        System.out.println(set.size());
        System.out.println(set1.size());
    }

    @Override
    public int compareTo(Serializable o) {
        return 0;
    }
}
