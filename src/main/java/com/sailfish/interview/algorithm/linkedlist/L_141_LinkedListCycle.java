package com.sailfish.interview.algorithm.linkedlist;

/**
 * 链表是否有环：https://leetcode-cn.com/problems/linked-list-cycle/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * @author sailfish
 * @create 2019-10-23-17:55
 */
public class L_141_LinkedListCycle {


    /**
     * 解题思路：
     *      1. 设置两个指针，一个走2步，一个走1步，相等时就是有环链表（快慢指针）
     */
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode quick = head;
            while (quick != null && quick.next != null) {
                slow = slow.next;
                quick = quick.next.next;
                if (slow.equals(quick)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(solution.hasCycle(node1));
    }
}
