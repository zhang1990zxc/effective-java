package com.zhang.effective.article66_73;

import java.util.HashSet;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-24 11:19
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element==23)
                    set.removeObserver(this);
            }
        }) ;
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
