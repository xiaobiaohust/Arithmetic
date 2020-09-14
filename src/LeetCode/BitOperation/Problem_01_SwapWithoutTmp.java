package LeetCode.BitOperation;

/**
 * 不用额外变量交换两个整数的值
 */
public class Problem_01_SwapWithoutTmp {
    public static void main(String[] args) {
        int a = 12;
        int b = 21;
        System.out.println(a);
        System.out.println(b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
