package com.zhang.effective.article30_37;

import org.junit.Test;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-18 15:08
 * @Version 1.0
 **/
public class Sample {

    @Test
    public static void m1() {}

    public static void m2() {}

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {}

    @Test
    public void m5() {}

    public static void m6() {}

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {}


}
