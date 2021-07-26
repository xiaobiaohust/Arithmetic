package JianZhiOffer.Chapter3;

import JianZhiOffer.ListNode;

public class P134_KthNodeFromEnd {
    public static ListNode<Integer>findKthToTail(ListNode<Integer>head,int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode<Integer>cur = head;
        while (cur!=null){
            cur = cur.next;
            k--;
        }
        if(k>0){
            return null;
        }
        cur=head;
        while (k!=0){
            cur = cur.next;
            k++;
        }
        return cur;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4));
    }
}
