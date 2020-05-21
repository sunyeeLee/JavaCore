package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 约瑟夫环形链表问题。
 *
 * 据说著名犹太历史学家Josephus有过以下故事：在罗马人占领乔塔帕特后，39个犹太人与Josephus及他的朋友躲到一个洞中，
 * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一种自杀方式，41个人排成一个圆圈，由第1个人开始报数，报数到3的人就自杀，
 * 然后再由下一个人重新报 1，报数到 3 的人再自杀，这样依次下去，直到剩下最后一个人时，那个人可以自由选择自己的命运。
 * 这就是著名的约瑟夫问题。
 *
 * 现在请用单向环形链表描述该结构并呈现整个自杀过程。
 * 输入：一个环形单向链表的头节点head和报数的值m。
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
 * Created by lishunyi on 2020/5/21
 */
public class JosephusNode {

    public static Node josephusNode(Node head, int m){
        if (head == null || head.next == null || m < 1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = head;
        System.out.println(josephusNode(head, 3));
    }
}
