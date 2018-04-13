package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (getNthNode(head, n) == n) {
            ListNode nextNode = head.next;
            head = null;
            return nextNode;
        }
        return head;
    }

    int getNthNode(ListNode head, int n) {
        if (head == null) return 0;
        int next = getNthNode(head.next, n);
        if (next == n) {
            ListNode nextNode = head.next;
            head.next = head.next.next;
            nextNode = null;
        }
        return next + 1;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList l = new RemoveNthNodeFromEndofList();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode result = l.removeNthFromEnd(listNode, 5);
    }
}
