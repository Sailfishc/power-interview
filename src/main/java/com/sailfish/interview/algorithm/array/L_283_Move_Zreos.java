package com.sailfish.interview.algorithm.array;

/**
 * @author sailfish
 * @create 2019-11-24-11:32 下午
 */
public class L_283_Move_Zreos {

    static class Solution {

        /**
         * 思路：
         *  1. 定义一个非0的数组
         *  2. 遍历原数组，如果不等于0，就将数据放置到非0数组中
         *  3. 遍历非0数组，将非0数组的元素放入原数组
         *  4. 原数组其他元素设置为0
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }

            // ？noZero长度设置多少合适
            int[] noZeroArray = new int[nums.length];
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    noZeroArray[k++] = nums[i];
                }
            }

            for (int i = 0; i < noZeroArray.length; i++) {
                nums[i] = noZeroArray[i];
            }

            for (int i = noZeroArray.length; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 12};

        (new Solution()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
