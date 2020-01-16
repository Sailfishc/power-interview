package com.sailfish.interview.algorithm.recursion;

public class RecursiveClass {


    public static int countDigits(int num) {
        if (num <= 1) {
            return 1;
        }

        return 1 + countDigits(num / 10);
    }


    public static void main(String[] args) {
        int input = 14333220;
        int numDigits = countDigits(input);
        System.out.println("Number of digits in " + input + " = " + numDigits);
    }
}
