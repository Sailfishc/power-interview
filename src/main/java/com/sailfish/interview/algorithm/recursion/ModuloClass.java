package com.sailfish.interview.algorithm.recursion;

/**
 * @author sailfish
 * @create 2020-01-16-6:01 PM
 */
public class ModuloClass {

    public static int mod(int dividend, int divisor) {

        if (divisor == 0) {
            System.out.println("Divisor cannot be 0");
            return -1;
        }

        // Base Case
        if (dividend < divisor) {
            return divisor;
        }

        // Recursion Case
        return mod(dividend - divisor, divisor);
    }


    public static void main(String[] args) {
        int dividend = 27;
        int divisor = 0;
        int remainder = mod(dividend, divisor);
        System.out.println(dividend + " mod " + divisor + " = " + remainder);
    }
}
