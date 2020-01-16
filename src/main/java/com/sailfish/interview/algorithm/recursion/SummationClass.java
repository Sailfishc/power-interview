package com.sailfish.interview.algorithm.recursion;

public class SummationClass {

    public static int sumAll(int num) {
        if (num == 1) {
            return 1;
        }

        return num + sumAll(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumAll(5));
        System.out.println(sumAll(3));
    }
}
