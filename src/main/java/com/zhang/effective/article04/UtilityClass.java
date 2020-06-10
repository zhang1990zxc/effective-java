package com.zhang.effective.article04;

/**
 * @Author zhang
 * @Description 通过私有构造器强化不可实例化的能力
 * @Date 2020-01-19 15:48
 * @Version 1.0
 **/
public class UtilityClass {

    private UtilityClass() {
        throw new AssertionError();
    }

}
