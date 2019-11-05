package com.sailfish.interview.algorithm.sort;

/**
 * 冒泡排序
 * @author sailfish
 * @create 2019-11-05-3:24 下午
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isSwap = true;
                }
                count++;
            }
            if (!isSwap) {
                break;
            }
        }
        System.out.println("spend num:" + count);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 2, 1, 6, 5};
//        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        final int[] ints = bubbleSort(arr, arr.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
