package com.sailfish.interview.algorithm.string;


/**
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class L_28_strStr {

//    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//    Example 1:
//
//    Input: haystack = "hello", needle = "ll"
//    Output: 2
//    Example 2:
//
//    Input: haystack = "aaaaa", needle = "bba"
//    Output: -1

    static class Solution {
        public int strStr(String haystack, String needle) {

            if (haystack == null || needle.length() == 0) {
                return 0;
            }
            for (int i = 0; i < haystack.length(); i++) {
                if (i + needle.length() > haystack.length()) {
                    break;
                }

                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }

                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(solution.strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "baa";
        System.out.println(solution.strStr(haystack, needle));
    }

}
