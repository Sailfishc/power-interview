package com.sailfish.interview.algorithm.sort;

/**
 * @author sailfish
 * @create 2019-12-08-5:51 PM
 */
public class InsertSort2 {

    public static void insertSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayGenHelper.swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }


    public static void insertSort2(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j;
            // 有段逻辑误差
            //             for (j = i; j > 0 && val < arr[j - 1]; j--) 和
            //             for (j = i; j > 0; j--) {  if (val < arr[j - 1]) { ...}
            //             对于j的变化
            for (j = i; j > 0 && val < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
        }
    }


    public static void main(String[] args) {
        final int[] arr = ArrayGenHelper.generateRandomArray(7, 1, 100);
        ArrayGenHelper.printArr(arr);

//        insertSort(arr, arr.length);

//        ArrayGenHelper.printArr(arr);

        insertSort2(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
