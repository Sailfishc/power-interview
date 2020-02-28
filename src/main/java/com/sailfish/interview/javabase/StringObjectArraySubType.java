package com.sailfish.interview.javabase;

/**
 * @author sailfish
 * @create 2020-02-14-3:14 PM
 */
public class StringObjectArraySubType {

    // String[] 是 Object[] 的 subtype。
    public static void f() {
        String[] a = new String[10];
        Object[] b = a;
        b[1] = "2";
        b[2] = 3;

        for (String x : a) {
            System.out.println(x.toLowerCase());
        }

    }

    public static void main(String[] args) {
        f();
    }

}
