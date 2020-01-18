package com.sailfish.interview.algorithm.recursion;


/**
 * https://www.educative.io/courses/recursion-for-coding-interviews-in-java/YQPY7KyBAm0
 * print out all the permutations of the array.
 */
public class PermutationsClass {


    public static void permutations(char[] array, int length) {
        // Write your code here
        if (length == 1) {
            System.out.println(array);
            return;
        }

        for (int i = 0; i < length; i++) {
            swap(array, i, length - 1);
            permutations(array,  length-1);
            swap(array, i, length - 1);

        }
    }

    private static void swap(char[] array, int i, int j) {
        final char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static void main(String args[]) {
        char[] input = {'a', 'b'};
//        char[] input = {'a', 'b', 'c'};
        System.out.println("Permutations of a string");
        permutations(input, input.length);
    }

}
