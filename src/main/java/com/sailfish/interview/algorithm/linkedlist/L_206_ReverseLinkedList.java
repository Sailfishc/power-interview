package com.sailfish.interview.algorithm.linkedlist;

import com.sailfish.interview.algorithm.sort.ArrayGenHelper;

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
        final Integer[] arr = ArrayGenHelper.generateRandomArr(10, 1, 20);
        final ListNode node = ListNode.genListNode(arr);
        ListNode.printListNode(node);
        Solution solution = new Solution();
        final ListNode listNode = solution.reverseList(node);
        ListNode.printListNode(listNode);
    }


}
