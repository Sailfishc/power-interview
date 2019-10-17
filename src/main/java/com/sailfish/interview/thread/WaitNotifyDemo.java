package com.sailfish.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 *
 * @author sailfish
 * @create 2019-10-16-15:54
 */
public class WaitNotifyDemo {


    private static final int MAX = 100;

    static class Worker {

        private final Object lock = new Object();

        // 奇数为true，偶数为false
        private volatile boolean flag = true;


        /**
         * 打印偶数
         */
        public void printEven(int index) {
            synchronized (lock) {
                // 为false则打印奇数
                if (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-print:" + index);
                flag = !flag;
                lock.notify();
            }
        }


        /**
         * 打印奇数
         */
        public void printODD(int index) {
            synchronized (lock) {
                // 为false则打印奇数
                if (flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-print:" + index);
                flag = !flag;
                lock.notify();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        new Thread(() -> {
            for (int i = 1; i <= MAX; i += 2) {
                worker.printEven(i);
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            for (int i = 2; i <= MAX; i += 2) {
                worker.printODD(i);
            }
        }).start();

    }
}
