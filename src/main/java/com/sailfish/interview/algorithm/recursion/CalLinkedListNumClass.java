package com.sailfish.interview.algorithm.recursion;


import com.sailfish.interview.algorithm.linkedlist.ListNode;
import com.sailfish.interview.algorithm.linkedlist.ListNodeHelper;

public class CalLinkedListNumClass {

    /**
     * 利用循环计算链表个数
     *
     * @param head
     * @return
     */
    public static int calWithLoop(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public static int calWithRecursive(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + calWithRecursive(head.next);
    }


    public static void main(String[] args) {
        final ListNode listNode = ListNodeHelper.genListNode(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(calWithLoop(listNode));

        System.out.println(calWithRecursive(listNode));
    }
}
