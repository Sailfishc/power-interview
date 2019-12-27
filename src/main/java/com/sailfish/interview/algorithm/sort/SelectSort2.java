package com.sailfish.interview.algorithm.sort;

/**
 * @author sailfish
 * @create 2019-12-08-5:51 PM
 */
public class SelectSort2 {

    public static void insertSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            // 在 [i, n) 的最小值
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            ArrayGenHelper.swap(arr, i, min);
        }
    }


    public static void main(String[] args) {
        final int[] arr = ArrayGenHelper.generateRandomArray(7, 1, 100);
        ArrayGenHelper.printArr(arr);

        insertSort(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
