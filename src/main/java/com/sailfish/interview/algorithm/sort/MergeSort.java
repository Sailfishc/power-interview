package com.sailfish.interview.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author sailfish
 * @create 2019-11-05-5:55 下午
 */
public class MergeSort {



    public static void mergeSort(int[] arr, int n) {

        sort(arr, 0, n - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // sort
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int i = l, j = mid + 1;
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        for (int k = l; k <= r; k++) {

            // 判断边界条件
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (arr[i - l] < arr[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else  {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        final int[] arr = ArrayGenHelper.generateRandomArray(10, 1, 50);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
       mergeSort(arr, arr.length);

        for (int m = 0; m < arr.length; m++) {
            System.out.println(arr[m]);
        }
    }
}
