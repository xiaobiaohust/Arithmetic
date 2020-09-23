package InterviewGuildCode.BitOperation;

/**
 * 整数的二进制表达中有多少个1
 */
public class Problem_04_NumberOf1 {
    public static int count1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(count1(num));
        //System.out.println(count2(num));
        //System.out.println(count3(num));
        //System.out.println(count4(num));


    }
}
