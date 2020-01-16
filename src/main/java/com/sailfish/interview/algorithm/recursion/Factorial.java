package com.sailfish.interview.algorithm.recursion;

/**
 * 计算阶乘 https://www.educative.io/courses/recursion-for-coding-interviews-in-java/xl7GjENLLvE
 *
 * @author sailfish
 * @create 2020-01-15-11:37 AM
 */
public class Factorial {

    private static int factorial(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return (n * factorial(n - 1));
    }


    public static void main(String[] args) {
        // Calling from main
        int result = factorial(5);
        System.out.println("Factorial of 5 is: " + result);
    }
}
