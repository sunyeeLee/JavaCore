package com.sunyee.javacore.algorithms.linkedlist;

import java.util.List;

/**
 * 题目： 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分.
 *
 *  ● 如果head1的值小于head2，则head1往下移动。
 *  ● 如果head2的值小于head1，则head2往下移动。
 *  ● 如果head1的值与head2的值相等，则打印这个值，然后head1与head2都往下移动。
 *  ● head1或head2有任何一个移动到null，则整个过程停止。
 * Created by lishunyi on 2020/5/15
 */
public class SamePartInLinkedList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void printSamePartInLinkedList(Node list1, Node list2){
        if (list1 == null || list2 == null){
            throw new RuntimeException("Linked List is empty!!!");
        }
        while(list1 != null && list2 != null){
            if (list1.value < list2.value){
                list1 = list1.next;
            } else if (list1.value > list2.value){
                list2 = list2.next;
            } else {
                System.out.println(list1.value + " ");
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        Node node11 = new Node(3);
        Node node12 = new Node(4);
        Node node13 = new Node(5);
        head1.next = node11;
        node11.next = node12;
        node12.next = node13;

        Node head2 = new Node(2);
        Node node1 = new Node(4);
        Node node2 = new Node(8);
        head2.next = node1;
        node1.next = node2;

        printSamePartInLinkedList(head1, head2);
    }
}
