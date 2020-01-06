package com.sailfish.interview.pattern.dip.noIoc;

/**
 * @author sailfish
 * @create 2020-01-04-10:36 PM
 */
public class UserServiceTest {
    public static boolean doTest() {

        return false;
    }

    // ...
    public static void main(String[] args) {
        // 这部分逻辑可以放到框架中
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}