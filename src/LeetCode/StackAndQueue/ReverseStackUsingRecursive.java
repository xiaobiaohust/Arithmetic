package LeetCode.StackAndQueue;


import java.util.Stack;

/**
 * 仅用递归对一个栈的数据进行反转
 * 思路：
 *      栈的特点是先进后出，队列的特点是先进先出，两个栈正好能把顺序反过来实现类似队列的操作
 */

public class ReverseStackUsingRecursive {
    public static int getAndRemoveLastElement(Stack<Integer>stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }else{
            int result = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(result);
        }
    }

    public static void main(String[]args){
        System.out.println("============测试开始============");

        Stack<Integer>stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println("============测试结束============");
    }


}
