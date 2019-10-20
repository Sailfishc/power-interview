package com.sailfish.interview.concurrent.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-20-11:21
 */
public class SemaphoreDemo {

    static class Worker implements Runnable {

        private Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + " -- " + Thread.currentThread().getName() + " get Semaphore.");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        final int num = 20;
        final ExecutorService executorService = Executors.newFixedThreadPool(num);
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < num; i++) {
            executorService.execute(new Worker(semaphore));
        }
        executorService.shutdown();
    }

}
