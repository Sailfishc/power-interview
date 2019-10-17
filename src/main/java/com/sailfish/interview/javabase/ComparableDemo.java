package com.sailfish.interview.javabase;

/**
 * @author sailfish
 * @create 2019-10-16-10:12
 */
public class ComparableDemo {

    public static void main(String[] args) {
        User user = new User("zhangsan", 20);
        User user2 = new User("lisi", 18);

        System.out.println(user.compareTo(user2));
    }
}
