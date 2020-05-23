package com.sunyee.javacore.algorithms.linkedlist;

/**
 * 删除单链表中倒数第K个节点
 *
 * 【要求】如果链表长度为N，时间复杂度达到O（N），额外空间复杂度达到O（1）。
 *
 * 让链表从头开始始走到尾，每移动一步，就让 K 值减 1，当链表走到结尾时，如果K值大于0，说明不用调整链表，因为链表根本没有倒数第K个节点，此时将原链表直接返回即可；如果 K 值等于 0，说明链表倒数第 K 个节点就是头节点，此时直接返回head.next，也就是原链表的第二个节点，让第二个节点作为链表的头返回即可，相当于删除头节点；接下来，说明一下如果K值小于0，该如何处理。先明确一点，如果要删除链表的头节点之后的某个节点，实际上需要找到要删除节点的前一个节点，比如：1-＞2-＞3，如果想删除节点 2，则需要找到节点 1，然后把节点 1 连到节点 3上（1-＞3），以此来达到删除节点2的目的。如果K值小于0，如何找到要删除节点的前一个节点呢？方法如下：1.重新从头节点开始走，每移动一步，就让K的值加1。2.当K等于0时，移动停止，移动到的节点就是要删除节点的前一个节点。这样做是非常好理解的，因为如果链表长度为N，要删除倒数第K个节点，很明显，倒数第K个节点的前一个节点就是第N-K个节点。在第一次遍历后，K的值变为K-N。第二次遍历时，K的值不断加1，加到0就停止遍历，第二次遍历当然会停到第N-K个节点的位置。
 * Created by lishunyi on 2020/5/19
 */
public class RemoveLastKthNode {


    public static Node removeLastKthNode(Node head, int k){
        if (head == null || head.next == null || k < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if (k == 0){
            head = head.next;
        } else if (k < 0){
            cur = head;
            while (++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;   //调整节点的下个节点指针
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
        Node linkedList = removeLastKthNode(head, 3);
        while (linkedList != null){
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }
}
