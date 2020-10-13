package InterviewGuildCode.StackAndQueue;

import java.util.Stack;

/**
 * 设计一个栈，能够实现基本的栈功能，同时返回栈的最小元素
 * 要求实现push、pop、getMin的时间复杂度为O(1),可以使用现成的栈结构
 * 思路：
 * 1：使用两个，一个栈用来保存当前栈中的元素stackData，另一个栈用来保存每一步的最小值stackMin
 */


public class Problem_01_GetMinStack {
    /**
     * 方案一：
     * 压入规则：当前数据为newNum，先压入stackData，判断stackMin是否为空
     * （1）stackMin为空，newNum压入stackMin
     * （2）stackMin不为空，newNum小于等于stackMin栈顶元素，newNum压入stackMin
     * （3）stackMin不为空，newNum大于stackMin栈顶元素，newNum不压入stackMin
     * 弹出规则：先从stackData中弹出元素value，判断value和stackMin栈顶元素大小，由于入栈规则，
     * value总是会小于等于栈顶元素，当value等于栈顶元素时，stackMin出栈；value大于栈顶的时候，stackMin不出栈
     * get当前栈最小值，stackMin的栈顶元素始终是栈中元素的最小值
     */
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int value = stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    /**
     * 方案二：
     * 压入规则：当前数据为newNum，先压入stackData，判断stackMin是否为空
     * （1）stackMin为空，newNum压入stackMin
     * （2）stackMin不为空，newNum小于等于stackMin栈顶元素，newNum压入stackMin
     * （3）stackMin不为空，newNum大于stackMin栈顶元素，将栈顶元素重复压入stackMin
     * 弹出规则：先从stackData中弹出元素value，stackMin弹出栈顶元素，返回value
     * get当前栈最小值：stackMin的栈顶元素始终是栈中元素的最小值
     */

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            } else {
                this.stackMin.push(this.getMin());
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int value = this.stackData.pop();
            this.stackMin.pop();
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return this.stackMin.peek();
        }

    }


    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        System.out.println(myStack1.getMin());
        myStack1.push(4);
        System.out.println(myStack1.getMin());
        myStack1.push(1);
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.getMin());

        System.out.println("==========================");

        MyStack2 myStack2 = new MyStack2();
        myStack2.push(3);
        System.out.println(myStack2.getMin());
        myStack2.push(4);
        System.out.println(myStack2.getMin());
        myStack2.push(1);
        System.out.println(myStack2.getMin());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.getMin());
    }
}
