package com.sunyee.javacore.algorithms.linkedlist;
import static com.sunyee.javacore.algorithms.linkedlist.RemoveMidNode.printlnNode;
/**
 * 逆序输出链表
 */
public class ReverseLinkedList2 {
    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        printlnNode(reverse(head));
    }
}
