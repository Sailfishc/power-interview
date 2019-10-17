package com.sailfish.interview.thread;

/**
 * @author sailfish
 * @create 2019-10-15-15:59
 */
public class MyRunnable implements Runnable{

    public static int count = 0;

    private static final int MAX = 10000;

    @Override
    public void run() {
        while (count < MAX) {
            count++;
        }
    }
}
