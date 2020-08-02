package com.zhang.effective.article11;

/**
 * @Author zhang
 * @Description 谨慎的覆盖clone
 * @Date 2020-07-08 11:41
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        person1.setId("1");
        person1.setName("zhang");
        Person person2 = (Person) person1.clone();
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));
    }

}
