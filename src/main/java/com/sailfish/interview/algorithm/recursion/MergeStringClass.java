package com.sailfish.interview.algorithm.recursion;


/**
 * https://www.educative.io/courses/recursion-for-coding-interviews-in-java/7D7jMyVLLKw
 */
public class MergeStringClass {


    private static String alphabeticMerge(String one, String two) {

        if (one.isEmpty()) {
            return two;
        }

        if (two.isEmpty()) {
            return one;
        }

        if (one.charAt(0) < two.charAt(0)) {
            return one.substring(0, 1) + alphabeticMerge(one.substring(1), two);
        } else {
            return two.substring(0, 1) + alphabeticMerge(one, two.substring(1));
        }
    }


    public static void main(String[] args) {
        String one = "adz";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);
    }
}
