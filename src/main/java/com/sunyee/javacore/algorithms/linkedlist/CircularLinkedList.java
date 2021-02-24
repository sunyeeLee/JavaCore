package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 环形链表II
 * 题意：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 「说明」：不允许修改给定的链表。
 *
 *
 * 思路
 * 这道题目，不仅考察对链表的操作，而且还需要一些数学运算。
 *
 * 主要考察两知识点：
 *
 * 1。判断链表是否环
 * 2。如果有环，如何找到这个环的入口
 *
 *
 * 环的入口： https://mp.weixin.qq.com/s/_QVP3IkRZWx9zIpQRgajzA
 *
 * Created by lishunyi on 2021/2/24
 */
public class CircularLinkedList {

    public static Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇，此时从head和快指针，同时查找直至相遇
            if (fast == slow){
                Node index1 = fast;
                Node index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;  //返回
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        Node node = detectCycle(head);
        if (node != null){
            System.out.println(node.value);
        }
    }
}
