package com.zhang.effective.article06;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-02-24 16:38
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        for1:for (int a = 0; a <= 3; a++) {
            for2:for (int i = 0; i <= 10; i++) {
                if(i==5)
                    break for1;
                System.out.println(i);
            }
        }
    }
}
