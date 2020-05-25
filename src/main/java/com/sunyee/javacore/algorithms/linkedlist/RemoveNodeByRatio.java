package com.sunyee.javacore.algorithms.linkedlist;

import static com.sunyee.javacore.algorithms.linkedlist.RemoveMidNode.printlnNode;

/**
 * 链表：1-＞2-＞3-＞4-＞5，
 * 假设a/b的值为r。
 * 如果r等于0，不删除任何节点；
 * 如果r在区间（0，1/5]上，删除节点1；
 * 如果r在区间（1/5，2/5]上，删除节点2；
 * 如果r在区间（2/5，3/5]上，删除节点3；
 * 如果r在区间（3/5，4/5]上，删除节点4；
 * 如果r在区间（4/5，1]上，删除节点5；
 * 如果r大于1，不删除任何节点。
 */
public class RemoveNodeByRatio {
    public static Node removeNodeByRatio(Node head, int a, int b){
        if (a < 1 || a > b){
            return head;
        }
        int total = 0;  //计算链表整个长度
        Node cur = head;
        while(cur != null){
            total++;
            cur = cur.next;
        }
        int removeNodeIndex = (int) Math.ceil((double)total * a / (double) b);
        if (removeNodeIndex == 1){
            head = head.next;
        }
        if (removeNodeIndex > 1){
            cur = head;
            while (--removeNodeIndex != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        printlnNode(removeNodeByRatio(head, 1, 5));
//        printlnNode(removeNodeByRatio(head, 2, 5));
//        printlnNode(removeNodeByRatio(head, 3, 5));
//        printlnNode(removeNodeByRatio(head, 4, 5));
        printlnNode(removeNodeByRatio(head, 5, 5));
    }
}
