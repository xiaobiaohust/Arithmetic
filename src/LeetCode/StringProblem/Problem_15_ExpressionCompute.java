package LeetCode.StringProblem;

import java.util.LinkedList;

/**
 * 公式字符串求值
 * 给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和
 * 左右括号，返回公式的计算结果
 */
public class Problem_15_ExpressionCompute {
    /**
     * 思路：
     * 1：采取递归的思路，从左到右遍历str，开始遍历或者遇到'('就进入递归过程，
     * 遍历完str或者遇到字符')'时，递归结束。
     * 2：递归过程遇到'('，就交给下一层的递归过程处理，所以对所以的递归过程
     * 来说，可以看作计算公式不含有'(',')'字符
     */
    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * 将公式字符串使用列表存储每个数以及符号，
     * 括号包含的内容使用子递归返回一个结果数
     * 乘除法需要优先处理，最后列表中只剩下数字以及+-
     *
     * @param str
     * @param i
     * @return
     */
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {
                int[] bra = value(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                int cur = Integer.valueOf(que.pollLast());
                num = top.endsWith("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                int num = Integer.valueOf(cur);
                res += add ? num : -num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "((10-5)*3)";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));

    }

}
