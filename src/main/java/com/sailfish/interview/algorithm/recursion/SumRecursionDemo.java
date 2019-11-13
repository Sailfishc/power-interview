package com.sailfish.interview.algorithm.recursion;

import com.sailfish.interview.algorithm.sort.SortTestHelper;

public class SumRecursionDemo {


    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        final int[] arr = SortTestHelper.generateRandomArray(3, 1, 100);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();

        System.out.println("sum=" + sum(arr));
    }
}
