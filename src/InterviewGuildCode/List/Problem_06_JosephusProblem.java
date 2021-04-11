package InterviewGuildCode.List;


/**
 * 环形单链表的约瑟夫问题
 * 要求：输入一个环形单链表的头结点head和报数的值m;返回最后生存下来的节点，且这个节点
 * 自己组成环形单向链表，其他节点都删掉
 * 思路：
 * 一：普通解法，时间复杂度O(NxM)
 * 1：如果链表为空或者链表节点数为1，或者m值小于1，则不调整直接返回
 * 2：环形链表中遍历每个节点，不断转圈不断让每个节点报数
 * 3：当报数到达m时，就删除当前报数的节点
 * 4：删除节点后，继续吧剩下节点连成环形，继续转圈报数
 * 5：一直到环形链表只有一个节点时，过程结束\
 *
 * 二：高阶解法
 * 根据N和M的关系，判断最后剩下的是哪个节点
 * 1：从头结点开始编号为1，剩下最后一个节点的时候，编号为1，当剩下两个节点的时候，他的编号是多少
 * 一次类推，当有N个节点的时候，编号是多少
 */
public class Problem_06_JosephusProblem {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node josephusKill1(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                head = last.next;
                count = 0;
            } else {
                last = last.next;
                head = last.next;
            }
        }
        return head;
    }
    public static Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1; // tmp -> list size
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m); // tmp -> service node position
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1;
        printCircularList(head1);
        head1 = josephusKill1(head1, 3);
        printCircularList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = head2;
        printCircularList(head2);
        head2 = josephusKill2(head2, 3);
        printCircularList(head2);


    }


}
