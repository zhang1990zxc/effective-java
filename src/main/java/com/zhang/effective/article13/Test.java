package com.zhang.effective.article13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhang
 * @Description 使类和成员的可访问性最小化
 * @Date 2020-07-13 11:33
 * @Version 1.0
 **/
public class Test {

//    public static final Integer[] PRIVATE_VALUES = new Integer[]{1,2,3};

    // 长度非零的数组总是可变的。
    // 类具有共有的静态final数组域或者返回这种域的方法总是错误的
    private static final Integer[] PRIVATE_VALUES = new Integer[]{1,2,3};

    public static final List<Integer> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static final Integer[] values() {
        return PRIVATE_VALUES.clone();
    }


}
