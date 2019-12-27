package com.sailfish.interview.thread;

/**
 * @author sailfish
 * @create 2019-12-27-11:02 AM
 */
public class TwoThreadPrintOddAndEven {

    private static volatile int value = 0;

    private static class Work implements Runnable {

        @Override
        public void run() {
            while (value <= 100) {
                synchronized (Work.class) {
                    System.out.println("ThreadName="+Thread.currentThread().getName() + ", value = " + value++);
                    Work.class.notify();

                    try {
                        Work.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Work()).start();
        new Thread(new Work()).start();

    }

}
