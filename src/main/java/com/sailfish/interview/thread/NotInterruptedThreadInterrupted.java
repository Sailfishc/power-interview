package com.sailfish.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2019-10-15-16:56
 */
public class NotInterruptedThreadInterrupted {



    static class Worker implements Runnable{

        @Override
        public void run() {
            while (true) {

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Worker());
        thread.start();

        System.out.println("Thread status is = " + thread.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
        // 对于不可中断的方法，只是将flag置为true，并不会中断线程的执行，可以在while中判断当前中断状态是不是true来结束业务逻辑
        thread.interrupt();

        System.out.println("Thread status is = " + thread.isInterrupted());

        thread.join();
    }
}
