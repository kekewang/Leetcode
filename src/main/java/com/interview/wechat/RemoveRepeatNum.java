package com.interview.wechat;

/*
 * 3, 从有序链表中去除重复的元素
 *  {1, 1, 3, 3, 3, 5, 5, 9, 9, 9, 9}  ->{1, 3, 5, 9}
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  void remove(LinkNode head);
 */
public class RemoveRepeatNum {

    void remove(LinkNode head){
        LinkNode current = head;
        LinkNode temp = head;
        while (temp.next != null){
            if (temp.next.value == current.value){
                temp.next = temp.next.next;
            }
            else {
                current.next = temp.next;
                temp = temp.next;
                current = current.next;
            }
        }
    }

    public static void main(String[] args){
        RemoveRepeatNum r = new RemoveRepeatNum();
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(1);node1.next = node2;
        LinkNode node3 = new LinkNode(1);node2.next = node3;
        LinkNode node4 = new LinkNode(3);node3.next = node4;
        LinkNode node5 = new LinkNode(3);node4.next = node5;
        LinkNode node6 = new LinkNode(3);node5.next = node6;
        LinkNode node7 = new LinkNode(5);node6.next = node7;
        LinkNode node8 = new LinkNode(5);node7.next = node8;
        LinkNode node9 = new LinkNode(9);node8.next = node9;
        LinkNode node10 = new LinkNode(9);node9.next = node10;
        LinkNode node11= new LinkNode(9);node10.next = node11;

        r.remove(node1);
        LinkNode temp = node1;
        while(temp != null){
            System.out.println(temp.value);

            temp = temp.next;
        }
    }
}
