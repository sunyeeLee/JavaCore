package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 如何实现一个高效的单向链表逆序输出？
 * Created by lishunyi on 2019/7/22
 */
public class ReverseLinkedList {

    public static void reverse(Node head) {
        if (null == head || head.next == null) {
            return;
        }
        Node prev = null;
        Node pcur = head.next;
        Node next;

        while (pcur != null) {
            if (pcur.next == null) {
                pcur.next = prev;
                break;
            }
            next = pcur.next;
            pcur.next = prev;
            prev = pcur;
            pcur = next;
        }
        head.next = pcur;
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reverse(head);
    }
}
