package com.sailfish.interview.algorithm.linkedlist;

/**
 * @author sailfish
 * @create 2019-11-07-5:05 下午
 */
public class ListNodeHelper {

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
