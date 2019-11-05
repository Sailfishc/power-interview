package com.sailfish.interview.algorithm.sort;

import java.util.Random;

/**
 * @author sailfish
 * @create 2019-11-05-5:16 下午
 */
public class SortTestHelper {


    /**
     * 产出一个长度是n，在start和end区间的随机数组（闭区间）
     *
     * @param n
     * @param start
     * @param end
     * @return
     */
    public static int[] generateRandomArray(int n, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("start must < end");
        }
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(end) % (end - start + 1) + start;
        }
        return arr;
    }

    public static void main(String[] args) {
        final int[] array = generateRandomArray(5, 1, 5);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
