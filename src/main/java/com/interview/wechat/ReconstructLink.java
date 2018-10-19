package com.interview.wechat;

/**
 * 5, 两个有序（从小到大）单链表，构造一条新链表，包含同时出现在两个链表的节点
 * class LinkNode{
 *  int value;
 *  LinkNode next;
 *  }
 *
 *  LinkNode interset(LinkNode firstLink, LinkNode secondLink);
 */
public class ReconstructLink {

    LinkNode interset(LinkNode firstLink, LinkNode secondLink){
        if (firstLink == null) return secondLink;
        if (secondLink == null) return firstLink;

        LinkNode temp = null;
        if (firstLink.value < secondLink.value) {
            temp = interset(firstLink.next, secondLink);
            firstLink.next = temp;

            return firstLink;
        }
        else {
            temp = interset(firstLink, secondLink.next);
            secondLink.next = temp;

            return secondLink;
        }
    }

    public static void main(String[] args){
        ReconstructLink r = new ReconstructLink();
        LinkNode node1 = new LinkNode(1);
        LinkNode node3 = new LinkNode(3);node1.next = node3;
        LinkNode node5 = new LinkNode(5);node3.next = node5;

        LinkNode node2 = new LinkNode(2);
        LinkNode node4 = new LinkNode(4);node2.next = node4;

        LinkNode result = r.interset(node1, node2);
        while(result != null){
            System.out.println(result.value);

            result = result.next;
        }
    }
}
