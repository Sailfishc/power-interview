package com.sailfish.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sailfish
 * @create 2020-01-03-10:18 AM
 */
public class PrintABCToSynchronized {

    static class Worker implements  Runnable {

        private static final int MAX_NUM = 10;
        private Object frontLock;
        private Object thisLock;
        private char printChar;


        public Worker(Object frontLock, Object thisLock, char printChar) {
            this.frontLock = frontLock;
            this.thisLock = thisLock;
            this.printChar = printChar;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_NUM; i++) {
                synchronized (frontLock) {
                    synchronized (thisLock) {
                        System.out.print(printChar);
                        thisLock.notify();
                    }

                    if (i < MAX_NUM - 1) {
                        try {
                            frontLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        // 实例化A线程
        Thread printerA = new Thread(new Worker(lockC, lockA, 'A'));
        Thread printerB = new Thread(new Worker(lockA, lockB, 'B'));
        Thread printerC = new Thread(new Worker(lockB, lockC, 'C'));
        // 依次开始A B C线程
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
    }
}
