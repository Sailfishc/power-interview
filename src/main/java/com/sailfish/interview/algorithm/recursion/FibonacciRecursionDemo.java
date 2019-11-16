package com.sailfish.interview.algorithm.recursion;

public class FibonacciRecursionDemo {

    public static int findFibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(findFibonacci(10));

        for (int i = 1; i < 10; i++) {
            System.out.printf(findFibonacci(i) + " ");
        }
    }
}
