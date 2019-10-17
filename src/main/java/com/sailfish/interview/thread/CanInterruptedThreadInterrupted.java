package com.sailfish.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-15-16:56
 */
public class CanInterruptedThreadInterrupted {



    static class Worker implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread status is = " + Thread.currentThread().isInterrupted());
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Worker());
        thread.start();

        System.out.println("Thread status is = " + thread.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        thread.join();
    }
}
