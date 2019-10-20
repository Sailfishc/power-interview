package com.sailfish.interview.concurrent.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sailfish
 * @create 2019-10-20-11:54
 */
public class ExchangerDemo {

    static class Worker implements Runnable {
        private Exchanger<String> exchanger;
        private boolean flag;

        public Worker(Exchanger<String> exchanger, boolean flag) {
            this.exchanger = exchanger;
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                try {
                    String s = exchanger.exchange("男：我等你很久了");
                    System.out.println("男收到女生说的话：" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    String s = exchanger.exchange("女：写个for循环");
                    System.out.println("女收到男生说的话：" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final int num = 2;
        final ExecutorService executorService = Executors.newFixedThreadPool(num);
        Exchanger<String> exchanger = new Exchanger<>();
        executorService.execute(new Worker(exchanger, true));
        executorService.execute(new Worker(exchanger, false));

        executorService.shutdown();
    }
}
