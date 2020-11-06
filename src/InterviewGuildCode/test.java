package InterviewGuildCode;

import java.util.Stack;

public class test {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;

        }
    }

    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");

            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value);
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + "");
        }
    }

    public static int getHeight(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(getHeight(head.left), getHeight(head.right)) + 1;
    }




    public static void main(String[] args) {
        System.out.println(2 ^ 1);
    }
}
