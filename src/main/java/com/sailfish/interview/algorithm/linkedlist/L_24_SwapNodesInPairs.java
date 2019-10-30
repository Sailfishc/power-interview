package com.sailfish.interview.algorithm.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * @author sailfish
 * @create 2019-10-23-18:57
 */
public class L_24_SwapNodesInPairs {

//    Given a linked list, swap every two adjacent nodes and return its head.
//
//    You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//             
//
//    Example:
//
//    Given 1->2->3->4, you should return the list as 2->1->4->3.


    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode tmp = pre;
            while (tmp.next != null && tmp.next.next != null) {
                ListNode start = tmp.next;
                ListNode end = tmp.next.next;
                tmp.next = end;
                start.next = end.next;
                end.next = start;
                tmp = start;
            }
            return pre.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
