package com.interview.wechat;

/**
 *  1, 倒转单链表
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  2, 有一个二叉树，每个节点的值是一个整数，写一个函数，判断这棵树中是否存在从根到叶子
 *  结点的一个路径，这个路径上所有节点之和为某一个值，存在返回1，否则返回0
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  int haspath(LinkNode root, int value);
 *
 *  3, 从有序链表中去除重复的元素
 *  {1, 1, 3, 3, 3, 5, 5, 9, 9, 9, 9}  ->{1, 3, 5, 9}
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  void remove(LinkNode head);
 *
 *  4, 在二叉排序树上面找到第3大的结点。注意：不能把二叉树全量存储到另外的存储空间
 *  比如存储在数组中，然后取出数组的第三个元素
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  LinkNode find(LinkNode root);
 *
 *  5, 两个有序（从小到大）单链表，构造一条新链表，包含同时出现在两个链表的节点
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  LinkNode interset(LinkNode firstLink, LinkNode secondLink);
 */

class LinkNode{
    LinkNode(int value){
        this.value = value;
    }
    int value;
    LinkNode next;
}

public class ReverseList {

    //1, 倒转单链表
    LinkNode reverseList(LinkNode head){

        LinkNode next = null;
        if (head != null && head.next!=null) {
            next = head.next;
            head.next = null;
        }

        while(next != null){
            LinkNode temp = next.next;

            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }

    public static void main(String[] args){
        ReverseList r = new ReverseList();
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);node1.next = node2;
        LinkNode node3 = new LinkNode(3);node2.next = node3;
        LinkNode node4 = new LinkNode(4);node3.next = node4;
        LinkNode node5 = new LinkNode(5);node4.next = node5;

        LinkNode result = r.reverseList(node1);
        while(result != null){
            System.out.println(result.value);

            result = result.next;
        }
    }
}
