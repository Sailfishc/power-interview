package com.sailfish.interview.algorithm.sort;

/**
 * 快速排序实现
 *
 * @author sailfish
 * @create 2019-12-07-2:19 PM
 */
public class QuickSort {


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
        QuickSort sort = new QuickSort();

        final int[] arr = ArrayGenHelper.generateRandomArray(10, 1, 50);

        ArrayGenHelper.printArr(arr);

        sort.quickSort(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
