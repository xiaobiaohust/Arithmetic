package InterviewGuildCode.List;

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
     * 1：遍历两个链表，看尾节点是否相同，相同说明相交；
     * 2：遍历的时候入栈，从最后节点开始比较是否相同
     * 方法二：
     * 1：遍历两个链表，记录链表长度，看尾节点是否相同，相同说明相交；
     * 2：长的链表先走一段，之后在一起走，什么时候相同，则是相交点
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 判断两个有环链表是否相交，以及相交节点
     * 两个链表不相交
     * 相交又分两种情况，入环节点相同，找到一个；入环节点不相同，则分别返回一个入环节点
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            //有相同的入环节点
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1==null ||head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1,head2);
        }
        if(loop1 !=null&& loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
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

        // 0->9->8->2...
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);


    }


}
