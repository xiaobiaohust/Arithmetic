package InterviewGuildCode.StackAndQueue;

import java.util.Stack;

/**
 *用一个栈实现另一个栈的排序
 * 思路：对时间、空间复杂度没有要求，可以使用一个辅助栈help，
 * 1：将数据栈data中的数据pop，记为cur如果cur小于等于help栈顶元素，则一直
 * push进入help，否则，help元素出栈，进入data栈，可以保证help一直是有序的
 */
public class Problem_05_StackSortStack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer>help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty()&&cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
