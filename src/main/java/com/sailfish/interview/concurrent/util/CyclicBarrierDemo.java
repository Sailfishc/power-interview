package com.sailfish.interview.concurrent.util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Barrier
 * 比较好的博客：https://www.cnblogs.com/dolphin0520/p/3920397.html
 * @author sailfish
 * @create 2019-10-20-10:56
 */
public class CyclicBarrierDemo {

    static class Worker implements Runnable {

        private CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(Thread.currentThread().getName() + " is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    static class BarrierRunnable implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("handle barrier done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final int num = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(num);
        BarrierRunnable barrierRunnable = new BarrierRunnable();
        CyclicBarrier barrier = new CyclicBarrier(num, barrierRunnable);
        for (int i = 0; i < num - 1; i++) {
            executorService.execute(new Worker(barrier));
        }
        barrier.await();
        System.out.println("main down step1.");

        for (int i = 0; i < num - 1; i++) {
            executorService.execute(new Worker(barrier));
        }
        barrier.await();
        System.out.println("main down step2.");
        executorService.shutdown();
    }
}
