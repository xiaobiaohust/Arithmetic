package JianZhiOffer.Chapter4;


import java.util.Stack;

/**
 * 栈的压入弹出序列
 */
public class P168_StackPushPopOrder {
    public static boolean isPopOrder(int[] pushArr, int[] popArr) {
        if (pushArr == null || popArr == null || pushArr.length != popArr.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popindex = 0;
        while (popindex<popArr.length){
            if(stack.isEmpty()||stack.peek()!=popArr[popindex]){
                if(pushIndex<pushArr.length){
                    stack.push(pushArr[pushIndex++]);
                }else {
                    return false;
                }
            }else{
                stack.pop();
                popindex++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));

    }

}
