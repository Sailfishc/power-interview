package com.sailfish.interview.algorithm.linkedlist;

/**
 * 链表节点
 *
 * @author sailfish
 * @create 2019-10-22-09:39
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) { val = x; }



    public static ListNode genListNode(Integer[] arr) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            pre.next = node;
            pre = node;
        }
        return head.next;
    }


    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
        System.out.println();
    }

}
