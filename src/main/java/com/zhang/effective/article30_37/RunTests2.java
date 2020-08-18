package com.zhang.effective.article30_37;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-18 14:50
 * @Version 1.0
 **/
public class RunTests2 {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("com.zhang.effective.article30_37.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
                    if(excType.isInstance(throwable)){
                        passed++;
                    }else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), throwable);
                    }
                } catch (Exception e) {
                    System.out.println("INVALID @Test:" + m);
                }
            }
        }
        System.out.printf("passed: %d, Failed: %d%n", passed, tests - passed);
    }

}
