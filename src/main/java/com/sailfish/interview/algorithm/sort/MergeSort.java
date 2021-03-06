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

        sorts(arr, 0, n - 1);
    }

    private static void sorts(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sorts(arr, l, mid);
        sorts(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }

    }

    private static void merge(int[] arr, int l, int mid, int r) {

        final int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i-l];
                i++;
            } else if (aux[i-l] < aux[j-l]) {
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        final int[] arr = ArrayGenHelper.generateRandomArray(4, 1, 50);

        ArrayGenHelper.printArr(arr);

        mergeSort(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
