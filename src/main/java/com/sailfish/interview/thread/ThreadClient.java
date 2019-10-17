package com.sailfish.interview.thread;

/**
 * @author sailfish
 * @create 2019-10-15-14:31
 */
public class ThreadClient {


    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.start();


        MyThread thread2 = new MyThread();
        thread2.start();

        MyThread thread3 = new MyThread();
        thread3.start();

        MyThread thread4 = new MyThread();
        thread4.start();

        MyThread thread5 = new MyThread();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println(MyThread.count);


    }
}
