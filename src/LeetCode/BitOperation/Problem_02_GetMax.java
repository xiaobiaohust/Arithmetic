package LeetCode.BitOperation;

/**
 * 不用任何比较，判断两个数中较大的值
 */
public class Problem_02_GetMax {
    public static int flip(int n){
        return n^1;
    }
    public static int sign(int n){
        return flip((n>>32)&1);
    }

    //a-b可能溢出
    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    /**
     * a和b符合不同、a和b符合不相同
     * @param a
     * @param b
     * @return
     */
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));

    }
}
