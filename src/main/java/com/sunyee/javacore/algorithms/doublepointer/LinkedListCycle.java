package com.sunyee.javacore.algorithms.doublepointer;

/**
 * 题目描述： 判断链表是否存在环
 *
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 * Created by lishunyi on 2019/5/21
 */
public class LinkedListCycle {
    public Boolean hasCycle(ListNode head){
        if (head == null){
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while(l1 != null && l2 != null && l2.next !=null){
            if (l1 == l2){
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode();
        ListNode l6 = new ListNode();
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l1;
        System.out.println(linkedListCycle.hasCycle(l1));
    }
}


class ListNode{
    public String value;
    public ListNode next;
}