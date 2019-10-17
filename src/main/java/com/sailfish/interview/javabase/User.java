package com.sailfish.interview.javabase;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 一个对象实现了Comparable和Comparator接口，那么会优先使用Comparator接口的比较实现
 * @author sailfish
 * @create 2019-10-16-10:08
 */
@Data
@AllArgsConstructor
public class User implements Comparable<User> {

    private String name;
    private Integer age;

    @Override
    public int compareTo(User o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }
}
