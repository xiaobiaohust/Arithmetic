package InterviewGuildCode.List;


/**
 * 打印两个有序列表的公共部分
 *要求：
 * 思路：从链表头开始，谁小谁往下移动，相等则打印，并且同时打印
 * 1
 */
public class Problem_01_PrintCommonPart {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static void printCommonpart(Node head1,Node head2){
        System.out.println("Common Part:");
        while(head1!=null&&head2!=null){
            if(head1.value<head2.value){
                head1 = head1.next;
            }else if(head1.value>head2.value){
                head2 = head2.next;
            }else{
                System.out.print(head1.value+" ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printLinkedList(Node node){
        System.out.println("linked List: ");
        while (node!=null){
            System.out.print(node.value+" ");
            node = node.next;
        }
    }

    public static void main(String[]args){
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonpart(node1,node2);

    }

}
