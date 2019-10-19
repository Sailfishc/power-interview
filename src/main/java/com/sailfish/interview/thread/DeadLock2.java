package com.sailfish.interview.thread;

/**
 * @author sailfish
 * @create 2019-10-19-14:32
 */
public class DeadLock2 {

    static class DeadLock implements Runnable {

        public  int flag = 1;

        private static Object obj1 = new Object();
        private static Object obj2 = new Object();

        @Override
        public void run() {
            if (flag == 1) {
                synchronized (obj1) {
                    synchronized (obj2) {

                    }
                }
            } else {
                synchronized (obj2) {
                    synchronized (obj1) {

                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 1;
        deadLock2.flag = 0;

        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock1);

        thread1.start();
        thread2.start();
    }
}
