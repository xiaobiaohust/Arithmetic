package LeetCode.List;

/**
 * 两个单链表相交的一系列问题
 * 1：判断链表是否有环，如果有，求第一个进入环的节点、环的长度、链表长度
 * 2：判断链表是否相交，分为有环和无环
 */
public class Problem_11_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 判断链表是否有环，有返回相交的第一个节点
     * 思想：第一次相遇时，快指针的步数是慢指针两倍，此时让快指针回原点，速度和慢指针
     * 一样，再回到相遇的=点时，慢指针也走了两倍的距离，并且相遇，由于此时快慢指针速度一样
     * 所以向前回退几步，再次相遇的时候，肯定在相交的第一个节点
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static int getCircleLen(Node head) {
        if (head == null || head.next == null | head.next.next == null) {
            return 0;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return 0;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n1 = n1.next;
        n2 = n2.next.next;
        int len = 1;
        while (n1 != n2) {
            len++;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return len;
    }

    /**
     * 返回列表的长度
     *
     * @param head
     * @return
     */
    public static int getListLen(Node head) {
        if (head == null || head.next == null | head.next.next == null) {
            return 0;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return 0;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        Node n3 = n1;
        n2 = head;
        int lineLen = 0;
        while (n1 != n2) {
            lineLen++;
            n1 = n1.next;
            n2 = n2.next;
        }


        n1 = n3.next;
        n2 = n3.next.next;
        int circleLen = 1;
        while (n1 != n2) {
            circleLen++;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return lineLen + circleLen;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 判断两个无环链表是否相交
     * 方法一：
     *      1：遍历两个链表，看尾节点是否相同，相同说明相交；
     *      2：遍历的时候入栈，从最后节点开始比较是否相同
     * 方法二：
     *      1：遍历两个链表，记录链表长度，看尾节点是否相同，相同说明相交；
     *      2：长的链表先走一段，之后在一起走，什么时候相同，则是相交点
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1,Node head2){
        if(head1 ==null||head2==null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }

    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;
        Node node = getLoopNode(head1);
        System.out.println("链表圆环的切入点：" + node.value);
        int circleLen = getCircleLen(head1);
        System.out.println("链表环的长度：" + circleLen);
        int listLen = getListLen(head1);
        System.out.println("链表的长度：" + listLen);


    }


}
