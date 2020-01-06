package com.sailfish.interview.pattern.dip.ioc;

/**
 * 定义了TestCase
 *
 * @author sailfish
 * @create 2020-01-04-10:37 PM
 */
public abstract class TestCase {

    public void run() {
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    protected abstract boolean doTest();
}
