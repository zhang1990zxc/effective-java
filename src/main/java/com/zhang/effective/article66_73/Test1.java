package com.zhang.effective.article66_73;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-24 11:43
 * @Version 1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(final ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element==23) {
                    ExecutorService executorService = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> setObserver = this;
                    try {
                        executorService.submit(() -> set.removeObserver(setObserver)).get();
                    } catch (ExecutionException e) {
                        throw new AssertionError(e.getCause());
                    } catch (InterruptedException e) {
                        throw new AssertionError(e.getCause());
                    } finally {
                        executorService.shutdown();
                    }
                }

            }
        }) ;
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
