package com.sailfish.interview.algorithm.linkedlist;

/**
 * L206:反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * @author sailfish
 * @create 2019-10-22-09:37
 */
public class L_206_ReverseLinkedList {

   /* Reverse a singly linked list.

            Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?*/


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
//        1->2->3->4->5->NULL
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        Solution solution = new Solution();
        final ListNode listNode = solution.reverseList(node1);
        System.out.println(listNode.val);
    }
}
