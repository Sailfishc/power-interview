package com.sailfish.interview.guava.basic;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author sailfish
 * @create 2020-03-10-5:09 PM
 */
public class PreconditionCase {


    public static void main(String[] args) {
        add(-2);
    }

    private static void add(int number) {
        checkArgument(number > 0, "Argument was %s but expected nonnegative", number);
    }
}
