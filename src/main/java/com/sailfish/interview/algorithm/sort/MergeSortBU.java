package com.sailfish.interview.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序(自底向上）
 * 因为子底向上的归并排序没有用到数组索引（mergeSort方法中），可以扩充到链表
 *
 * @author sailfish
 * @create 2019-11-05-5:55 下午
 */
public class MergeSortBU {


    public static void mergeSort(int[] arr, int n) {

        // sz代表：Merge的元素个数
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
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
