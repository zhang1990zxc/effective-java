package com.zhang.effective.article30_37;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-18 15:15
 * @Version 1.0
 **/
public class Sample2 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
       int[] a = new int[0];
       int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    }


}
