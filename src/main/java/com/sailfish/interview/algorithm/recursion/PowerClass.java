package com.sailfish.interview.algorithm.recursion;

public class PowerClass {

    public static long power(int num, int pow) {
        if (pow == 0) {
            return 1;
        }

        return num * power(num, pow - 1);
    }


    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(power(2, 4));
    }
}
