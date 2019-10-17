package com.sailfish.interview.javabase;

import java.util.Comparator;

/**
 * 外比较器
 * @author sailfish
 * @create 2019-10-16-10:18
 */
public class ComparatorDemo implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        }
        return 0;
    }
}
