package com.sailfish.interview.algorithm.time_complexity_basic;

/**
 * 时间复杂度分析案例一
 */
public class ComplexityAnalysisExample1 {


    public int find(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * 时间复杂度分析案例2
     *
     * @param val
     */
    public void insert(int val) {
        // array 表示一个长度为 n 的数组
        // 代码中的 array.length 就等于 n
        int n = 10;
        int[] array = new int[n];
        int count = 0;
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }
        array[count] = val;
        ++count;
    }
}
