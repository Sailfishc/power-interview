package com.sailfish.interview.algorithm.sort;

/**
 * 快速排序实现:双路快排
 *
 * @author sailfish
 * @create 2019-12-07-2:19 PM
 */
public class Quick2Way {


    public void quickSort(int[] arr, int n) {

        sorts(arr, 0, n - 1);
    }

    // l 和 r的定义：对[l,r]的元素进行排序
    private void sorts(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        final int p = partition(arr, l, r);

        sorts(arr, l, p - 1);
        sorts(arr, p + 1, r);

    }

    private int partition(int[] arr, int l, int r) {

        // 找到分区点:p是标定点的索引
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        ArrayGenHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        final int value = arr[l];
        // arr[l+1, i-1] <= value
        // arr(j, r] >= value
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= r && arr[i] < value) {
                i++;
            }

            while (j >= l+1 && arr[j] > value) {
                j--;
            }

            // 这里是>还是>=
            if (i > j) {
                break;
            }

            ArrayGenHelper.swap(arr, i, j);
            i++;
            j--;
        }

        ArrayGenHelper.swap(arr, l, j);

        return j;
    }

    public static void main(String[] args) {
        Quick2Way sort = new Quick2Way();

        final int[] arr = ArrayGenHelper.generateRandomArray(5, 1, 50);

        ArrayGenHelper.printArr(arr);

        sort.quickSort(arr, arr.length);

        ArrayGenHelper.printArr(arr);
    }
}
