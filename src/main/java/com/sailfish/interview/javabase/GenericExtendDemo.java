package com.sailfish.interview.javabase;


import java.util.ArrayList;
import java.util.List;

/**
 * @author sailfish
 * @create 2020-02-14-4:35 PM
 */
public class GenericExtendDemo {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = ints;
//        numbers.add(new Integer(200));

        Number a = new Double(3.14);
        Object b = new String("ab");

//        numbers.add(a);
//        numbers.add(b);

    }
}
