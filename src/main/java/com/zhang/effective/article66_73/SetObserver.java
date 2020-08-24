package com.zhang.effective.article66_73;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-24 11:05
 * @Version 1.0
 **/
public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
