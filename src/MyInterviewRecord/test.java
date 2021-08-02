package MyInterviewRecord;

import net.mindview.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
}
public class test {
    public static void fun(Node head){
        if(head==null){
            return;
        }
        Stack<Node>stack = new Stack<>();
        Node cur = head;
        while (!stack.empty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }
}
