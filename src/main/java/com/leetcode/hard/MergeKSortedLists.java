package com.leetcode.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // define priorityQueue
        PriorityQueue<ListNode> q = new PriorityQueue<>(3);

        //pop queue with list head
        for (ListNode head : lists) {
            if (head != null) {
                q.add(head);
            }
        }

        //pop from queue and append node to new list, add next from poll element to queue
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!q.isEmpty()) {
            temp.next = q.poll();
            if (temp.next.next != null) {
                q.add(temp.next.next);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
