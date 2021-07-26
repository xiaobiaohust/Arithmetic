package JianZhiOffer.Chapter3;

import JianZhiOffer.ListNode;
import org.omg.CORBA.INTERNAL;

/**
 * 删除排序链表中的重复节点
 */
public class P122_deleteDuplicatedNode {
    public static ListNode<Integer>deleteDuplication(ListNode<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode<Integer>cur= head;
        while (cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        head.next.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);

    }
}
