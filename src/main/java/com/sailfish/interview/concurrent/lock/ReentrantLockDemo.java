package com.sailfish.interview.concurrent.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-19-11:08
 */
public class ReentrantLockDemo {


    public static void main(String[] args) throws InterruptedException {
        LockRunnable runnable = new LockRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        while (true) {
            System.out.println("Thread1 state=" + thread1.getState());
            System.out.println("Thread2 state=" + thread2.getState());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
