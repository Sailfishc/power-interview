package com.sailfish.interview.algorithm.string;

/**
 * @author sailfish
 * @create 2019-10-31-17:37
 */
public class L_28_ImplementStr {

//    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//    Example 1:
//    Input: haystack = "hello", needle = "ll"
//    Output: 2

//    Example 2:
//    Input: haystack = "aaaaa", needle = "bba"
//    Output: -1
//    Clarification:
//
//    What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || haystack == null) {
                return -1;
            }
            if (needle.length() == 0) {
                return 0;
            }
            if (haystack.equals(needle)) {
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
        String str = "hello";
        String needle = "ll";
        System.out.println(solution.strStr(str, needle));

    }
}
