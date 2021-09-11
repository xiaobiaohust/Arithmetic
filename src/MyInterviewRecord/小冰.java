package MyInterviewRecord;

/**
 * 链表旋转
 */
public class 小冰 {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node fun(Node head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        if(k==0){
            return head;
        }
        int nums = 0;
        Node tail = null;
        Node cur = head;
        while (cur != null) {
            tail = cur;
            cur = cur.next;
            nums++;
        }

        tail.next = head;
        int steps = k % nums;
        cur = head;
        for(int i=0;i<nums-steps-1;++i){
            cur = cur.next;
        }
        Node newHead = cur.next;
        cur.next = null;
        return newHead;
    }
    public static void main(String[]args){
        Node head = new Node(1);
        Node cur = head;
        for(int i=2;i<6;++i){
            Node node = new Node(i);
            cur.next = node;
            cur = cur.next;

        }
        Node newhead = fun(head,1);
        while (newhead!=null){
            System.out.println(newhead.value);
            newhead = newhead.next;
        }
    }
}
