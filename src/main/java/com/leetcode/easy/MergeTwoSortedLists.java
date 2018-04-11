package com.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;

        if (l1.val<l2.val) {
            ListNode result = mergeTwoLists(l1.next, l2);
            l1.next = result;

            return l1;
        }
        else {
            ListNode result = mergeTwoLists(l1, l2.next);
            l2.next = result;

            return l2;
        }
    }
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println(mergeTwoSortedLists.mergeTwoLists(l1, l2));
    }
}
