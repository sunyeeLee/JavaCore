package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 设计链表
 * 题意：
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * Created by lishunyi on 2021/2/24
 */
public class MyLinkedList {
    private int size;
    private Node dummyNode;

    public MyLinkedList(){
        dummyNode = new Node(0);    //虚拟节点
    }

    public Integer get(int index){
        if (index > (size - 1) || index < 0){
            return -1;
        }
        Node cur = dummyNode.next;
        while (index-- > 0){
            cur = cur.next;
        }
        return cur.value;
    }

    public void addAtHead(int val){
        Node newNode = new Node(val);
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
        size++;
    }

    public void addAtTail(int val){
        Node newNode = new Node(val);
        Node cur = dummyNode;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果index大于链表的长度，则返回空
    public void addAtIndex(int index, int val){
        if (index > size){
            return;
        }
        Node newNode = new Node(val);
        Node cur = dummyNode;
        while (index--> 0){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode.next;
        size++;
    }


    public void deleteAtIndex(int index){
        if (index > size){
            return;
        }
        Node cur = dummyNode;
        while (index-- > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    public void printNode(){
        Node node = dummyNode.next;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.printNode();
        System.out.println("******************");
        System.out.println(linkedList.get(0));
    }
}
