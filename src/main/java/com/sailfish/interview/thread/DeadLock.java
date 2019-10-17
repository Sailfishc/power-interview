package com.sailfish.interview.thread;

/**
 * 可以使用jstack或者jconsole去检测死锁
 * @author sailfish
 * @create 2019-10-15-17:19
 */
public class DeadLock {

    private final Object readMonitor = new Object();
    private final Object writeMonitor = new Object();

    public  void read() {
        synchronized (readMonitor) {
            synchronized (writeMonitor) {

            }
        }
    }

    public  void write() {
        synchronized (writeMonitor) {
            synchronized (readMonitor) {

            }
        }
    }


    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }).start();

    }
}
