package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 给定链表的头节点head，实现删除链表的中间节点的函数。
 * 例如：
 * 1-＞2，删除节点1；
 * 1-＞2-＞3，删除节点2；
 * 1-＞2-＞3-＞4，删除节点2；
 * 1-＞2-＞3-＞4-＞5，删除节点3
 */
public class RemoveMidNode {
    public static Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node beforeMidNode = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            beforeMidNode = beforeMidNode.next;
            cur = cur.next.next;
        }
        //指针指向下下节点
        beforeMidNode.next = beforeMidNode.next.next;
        return head;
    }

    public static void printlnNode(Node head){
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
//        printlnNode(removeMidNode(head));
        node1.next = node2;
//        printlnNode(removeMidNode(head));
        node2.next = node3;
//        printlnNode(removeMidNode(head));
        node3.next = node4;
        printlnNode(removeMidNode(head));
    }
}
