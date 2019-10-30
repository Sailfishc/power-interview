package com.sailfish.interview.algorithm.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author sailfish
 * @create 2019-10-22-09:57
 */
public class L_92_ReverseLinkedListII {

    /*Reverse a linked list from position m to n. Do it in one-pass.

            Note: 1 ≤ m ≤ n ≤ length of list.

            Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL*/


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {


        /**
         * 解题思路：
         *      1. 新建一个虚拟链表，将前m个链表元素加入虚拟链表中
         *      2. 新建两个指针，pre和cur，pre指向第m元素的前一个元素，cur指向第m个元素
         *      3. 遍历链表
         *      4. 将pre指针指向cur指向的链表节点
         *      5. 移动下一个cur指针
         * @param head
         * @param m
         * @param n
         * @return
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || head.next == null) {
                return head;
            }
            if (m < 0 || n < 0 || m > n) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            // 移动m-1次
            for (int i = 1; i < m; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            // 移动n-m次
            for (int i = 0; i < n - m; i++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            // 去除dummy第一个节点
            return dummy.next;
        }

        public ListNode reverseBetween2(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            for (int i = 1; i < m; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            for (int i = 0; i < n - m; i++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            return dummy.next;
        }
    }


}
