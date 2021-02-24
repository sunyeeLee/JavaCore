package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 输入 1->2->3->3->6->4, val = 4
 * 输出 1->2->3->3->6
 * Created by lishunyi on 2021/2/24
 */
public class RemoveNodeByValue {

    /**
     * 情况如下：
     * 1. val为头节点
     * 2. val为中间节点
     * 3. val不存在节点中
     */
    public static Node remove(Node head, Integer val){

        // 考虑头节点的情况
        while(head != null && head.value == val){
            head = head.next;
        }

        Node cur = head;
        while (cur != null && cur.next != null){
            if (cur.next.value == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 设置一个虚拟节点，让虚拟节点的next指向head。
     * @param head
     * @param val
     * @return
     */
    public static Node removeByDummy(Node head, Integer val){
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null){
            if (cur.next.value == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    private static void printNode(Node head){
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
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
        Integer val = 1;
        printNode(removeByDummy(head, val));
    }
}
