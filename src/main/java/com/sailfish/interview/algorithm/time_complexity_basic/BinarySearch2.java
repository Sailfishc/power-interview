package com.sailfish.interview.algorithm.time_complexity_basic;

import com.sailfish.interview.algorithm.sort.ArrayGenHelper;

/**
 * @author sailfish
 * @create 2019-11-24-11:09 下午
 */
public class BinarySearch2<T extends Comparable<T>> {


    /**
     * 二分搜索
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public int binarySearch(T[] arr, int n, T target) {

        // 在[l...r）的范围里寻找target:注意，这里改变了范围，左闭右开
        int l = 0, r = n;
        // 边界条件：l可不可以等于r. // 当 l == r 时, 区间[l...r)是一个无效区间
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0){
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                // target在[mid+1...r)中; [l...mid]一定没有target
                l = mid + 1;
            } else {
                // target在[l...mid)中; [mid...r)一定没有target
                r = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        final Integer[] ints = ArrayGenHelper.generateOrderedArray(100);
        BinarySearch2<Integer> arr = new BinarySearch2<>();
        final int index = arr.binarySearch(ints, ints.length, ints[2]);
        System.out.println("arr index = " + index);
    }
}
