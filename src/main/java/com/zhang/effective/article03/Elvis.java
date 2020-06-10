package com.zhang.effective.article03;

/**
 * @Author zhang
 * @Description 用私有构造器或者枚举类型强化Singleton属性
 * @Date 2020-01-19 11:54
 * @Version 1.0
 **/
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance(){
        return INSTANCE;
    }
    public void leaveTheBuilding(){
        
    }
}
