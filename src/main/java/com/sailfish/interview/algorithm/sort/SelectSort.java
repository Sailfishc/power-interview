package com.sailfish.interview.algorithm.sort;

/**
 * @author sailfish
 * @create 2019-11-05-5:55 下午
 */
public class SelectSort {

    public static int[] selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 如果要消除min，那么需要在这里添加临时变量
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }


    public static void main(String[] args) {
        final int[] array = ArrayGenHelper.generateRandomArray(10, 1, 50);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        final int[] arr = selectSort(array, array.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
