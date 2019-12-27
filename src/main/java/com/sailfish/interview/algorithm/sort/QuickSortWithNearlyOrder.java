package com.sailfish.interview.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序实现
 *
 * @author sailfish
 * @create 2019-12-07-2:19 PM
 */
public class QuickSortWithNearlyOrder {


    public void quickSort(int[] arr, int n) {

        sorts(arr, 0, n - 1);
    }

    // l 和 r的定义：对[l,r]的元素进行排序
    private void sorts(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 找到分区点:p是标定点的索引
        int p = partition(arr, l, r);
        sorts(arr, l, p-1);
        sorts(arr, p + 1, r);
    }

    // 对[l,r]进行分区操作
    // 返回p，使得arr[l, p-1] < arr[p], arr[p+1, r] > arr[p]
    private int partition(int[] arr, int l, int r) {
        // j是标定点，在j之前的值都小于arr[l],j之后的值都大于arr[l]
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        ArrayGenHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]) {
                ArrayGenHelper.swap(arr, i, j + 1);
                j++;
            }
        }

        // 将l和j交换位置
        ArrayGenHelper.swap(arr, l, j);
        return j;
    }


    public static void main(String[] args) {
        QuickSortWithNearlyOrder sort = new QuickSortWithNearlyOrder();
        final int[] arr = ArrayGenHelper.generateNearlyOrderedArrayToInt(1000, 50);
//        ArrayGenHelper.printArr(arr);
        final long start = System.currentTimeMillis();
        sort.quickSort(arr, arr.length);
        System.out.println("Quick Sort From Nearly Order, Spend Time: " + (System.currentTimeMillis() - start) + " ms");

//        ArrayGenHelper.printArr(arr);



        QuickSort quickSort = new QuickSort();
//        ArrayGenHelper.printArr(arr);
        final long start1 = System.currentTimeMillis();
        quickSort.quickSort(arr, arr.length);
        System.out.println("Quick Sort From Nearly Order To No Optimize, Spend Time: " + (System.currentTimeMillis() - start1) + " ms");

//        ArrayGenHelper.printArr(arr);
    }
}
