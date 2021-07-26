package JianZhiOffer.Chapter3;

import JianZhiOffer.ListNode;

/**
 * O(1)时间删除链表节点
 * 想在O(1)时间删除链表节点
 * 思路：使用下一个节点替换该节点就行
 */
public class P119_DeleteNodeInList {
    public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
        if (head == node) {
            return head.next;
        }if(node.next!=null){
            node.val = node.next.val;
            node.next = node.next.next;
        }else{
            ListNode<Integer>cur = head;
            while (cur.next!=node){
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head,node3);
        System.out.println(head);
        head = deleteNode(head,head);
        System.out.println(head);
    }
}
