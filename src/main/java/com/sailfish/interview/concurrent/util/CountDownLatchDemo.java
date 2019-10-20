package com.sailfish.interview.concurrent.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-20-10:52
 */
public class CountDownLatchDemo {

    static class Worker implements Runnable {

        private CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(Thread.currentThread().getName() + " is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final int num = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(num);
        CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            executorService.execute(new Worker(latch));
        }
        // 等待线程执行完
        latch.await();
        System.out.println("down ");
        executorService.shutdown();
    }
}
