package com.sailfish.interview.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sailfish
 * @create 2019-10-19-11:10
 */
public class LockRunnable implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
