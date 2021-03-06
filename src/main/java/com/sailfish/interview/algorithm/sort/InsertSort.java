package com.sailfish.interview.algorithm.sort;

/**
 * 插入排序
 *
 * @author sailfish
 * @create 2019-11-05-5:55 下午
 */
public class InsertSort {

    public static int[] insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            final int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    // 移动数据
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }



    public static int[] insertSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    // 移动数据
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        final int[] array = ArrayGenHelper.generateRandomArray(10, 1, 50);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
//        final int[] arr = insertSort(array, array.length);
        final int[] arr = insertSort2(array, array.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
