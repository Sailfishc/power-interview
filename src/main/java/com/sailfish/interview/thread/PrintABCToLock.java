package com.sailfish.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sailfish
 * @create 2020-01-03-10:18 AM
 */
public class PrintABCToLock {

    static class Worker implements  Runnable {

        private static final int MAX_NUM = 10;
        private Lock lock;
        private Condition thisCondition;
        private Condition nextCondition;
        private char printChar;


        public Worker(Lock lock, Condition thisCondition, Condition nextCondition, char printChar) {
            this.lock = lock;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
            this.printChar = printChar;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < MAX_NUM; i++) {
                    System.out.print(printChar);

                    nextCondition.signal();

                    if (i < MAX_NUM - 1) {
                        try {
                            // 本线程让出锁并等待唤醒
                            thisCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        final Condition conditionA = lock.newCondition();
        final Condition conditionB = lock.newCondition();
        final Condition conditionC = lock.newCondition();

        // 实例化A线程
        Thread printerA = new Thread(new Worker(lock, conditionA, conditionB, 'A'));
        // 实例化B线程
        Thread printerB = new Thread(new Worker(lock, conditionB, conditionC, 'B'));
        // 实例化C线程
        Thread printerC = new Thread(new Worker(lock, conditionC, conditionA, 'C'));
        // 依次开始A B C线程
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
    }
}
