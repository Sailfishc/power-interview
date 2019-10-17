package com.sailfish.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 测试不可变对象的线程安全性
 * @author sailfish
 * @create 2019-10-16-10:21
 */
public class FinalClassToThreadSafe {

    static final class IntegerAccumulator {

        private final int init;

        public IntegerAccumulator(int init) {
            this.init = init;
        }

        public IntegerAccumulator(IntegerAccumulator accumulator, int init) {
            this.init = accumulator.getValue() + init;
        }

        public IntegerAccumulator add(int value) {
            return new IntegerAccumulator(this, value);
        }

        public int getValue() {
            return this.init;
        }
    }


    static class NotSafeInterAccumulator {
        private  int init;

        public NotSafeInterAccumulator(int init) {
            this.init = init;
        }

        public NotSafeInterAccumulator add(int value) {
            this.init += value;
            return this;
        }

        public int getValue() {
            return this.init;
        }
    }

    public static void main(String[] args) {
//        IntegerAccumulator accumulator = new IntegerAccumulator(4);
//        System.out.println(accumulator.getValue());
//        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
//            int inc = 0;
//            while (true) {
//                final int oldValue = accumulator.getValue();
//                final int value = accumulator.add(inc).getValue();
//                System.out.println(oldValue + "+" + inc + "=" + value);
//                if (oldValue + inc != value) {
//                    System.out.println("ERROR---" + oldValue + "+" + inc + "=" + value);
//                }
//                inc++;
//                slowly();
//            }
//        }).start());

        // not safe Test
        NotSafeInterAccumulator notSafe = new NotSafeInterAccumulator(0);

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            int inc = 0;
            while (true) {
                final int oldValue = notSafe.getValue();
                final int value = notSafe.add(inc).getValue();
                System.out.println(oldValue + "+" + inc + "=" + value);
                if (oldValue + inc != value) {
                    System.out.println("ERROR---" + oldValue + "+" + inc + "=" + value);
                }
                inc++;
                slowly();
            }
        }).start());

    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
