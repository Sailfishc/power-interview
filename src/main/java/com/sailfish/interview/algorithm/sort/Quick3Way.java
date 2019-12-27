package com.sailfish.interview.algorithm.sort;

/**
 * 快速排序实现:三路快排
 *
 * @author sailfish
 * @create 2019-12-07-2:19 PM
 */
public class Quick3Way {


    public void quickSort(int[] arr, int n) {

        sorts(arr, 0, n - 1);
    }

    // l 和 r的定义：对[l,r]的元素进行排序
    private void sorts(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 将要排序的元素分为3部分
        // arr[l+1, lt] < value的
        // arr[lt+1, gt-1] = value的
        // arr[gt, r] > value的
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        ArrayGenHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        final int value = arr[l];
        int lt = l;
        int gt = r + 1;

        int i = l + 1;
        while (i < gt) {
            if (arr[i] < value) {
                ArrayGenHelper.swap(arr, lt + 1, i);
                lt++;
                i++;
            } else if (arr[i] == value) {
                i++;
            } else {
                ArrayGenHelper.swap(arr, i, gt - 1);
                gt--;
            }
        }

        ArrayGenHelper.swap(arr, l, lt);

        sorts(arr, l, lt - 1);
        sorts(arr, gt, r);

    }

    public static void main(String[] args) {
        Quick3Way sort = new Quick3Way();

        final int[] arr = ArrayGenHelper.generateRandomArray(5, 1, 50);

        ArrayGenHelper.printArr(arr);

        sort.quickSort(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
