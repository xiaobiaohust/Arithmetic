package InterviewGuildCode.StackAndQueue;

import java.util.Stack;


/**
 * 用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 * 思路：
 *      栈的特点是先进后出，队列的特点是先进先出，两个栈正好能把顺序反过来实现类似队列的操作
 */

public class TwoStackImplementQueue {

    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush= new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(int newNum){
            this.stackPush.push(newNum);
        }

        public int poll(){
            if(this.stackPush.isEmpty()&&this.stackPop.isEmpty()){
                throw new RuntimeException("Stack is empty");
            } else if(this.stackPop.isEmpty()){
                while(!this.stackPush.isEmpty()){
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.pop();
        }

        public int peek(){
            if(this.stackPush.isEmpty()&&this.stackPop.isEmpty()){
                throw new RuntimeException("Stack is empty");
            } else if(this.stackPop.isEmpty()){
                while(!this.stackPush.isEmpty()){
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.peek();
        }
    }


    public static void main(String[]args){
        System.out.println("============测试开始============");

        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(2);
        twoStacksQueue.add(3);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());

        System.out.println("============测试结束============");
    }


}
