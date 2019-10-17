package com.sailfish.interview.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-15-14:27
 */
public class MyThread extends Thread {

    public static int count = 0;

    private final int MAX = 1000;

    private Random random = new Random();

    @Override
    public void run() {
        increment();
    }

    private void increment() {
        while (count < MAX) {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

}
