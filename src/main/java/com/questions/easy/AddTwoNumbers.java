package com.questions.easy;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Created by wangke on 2018/3/6.
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode result = p;
        int carry = 0;
        while (l1!=null || l2!=null){

            int value1 = 0, value2 = 0;
            if (l1!=null) {value1 = l1.val; l1 = l1.next;}
            if (l2!=null) {value2 = l2.val; l2 = l2.next;}

            int sum = value1 + value2 + carry;
            carry = sum / 10;
            p.val = sum % 10;

            if (l1!=null || l2!=null){
                ListNode sub = new ListNode(0);
                p.next = sub;
                p = p.next;
            }
        }

        if (carry!=0) {
            ListNode sub = new ListNode(carry);
            p.next = sub;
        }
        return result;
    }

    public static void main(String[] args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);

        while (listNode!=null){
            System.out.println(listNode.val);

            listNode = listNode.next;
        }
    }
}
