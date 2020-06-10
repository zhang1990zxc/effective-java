package com.zhang.effective.article05;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author zhang
 * @Description 避免创建不必要对象
 * @Date 2020-01-19 15:53
 * @Version 1.0
 **/
public class Person {

    private final Date birthDate;

    private static final Date BOOM_START;

    private static final Date BOOM_END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = calendar.getTime();
    }

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-current);
    }

}
