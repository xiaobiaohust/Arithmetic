package InterviewGuildCode.Others;

/**
 * 有关阶乘的问题
 * 题1：给定一个非负整数N，返回N!结果末尾为0的数量
 * 思路1：N!的问题可以转换为序列1,2,3.。。N有多少个因子5，因为2的因子肯
 * 定比5多，遍历序列，判断每个数中含有因子5的个数
 * 思路2：一层一层压榨，先含有因子5的个数为N/5，在对N/5进行压榨，
 * <p>
 * 题2：给定一个非负整数N，用二进制表示N的阶乘，返回最低位的1在哪个位置上
 * 思路：就是求N!有多少个因子2
 */
public class Problem_03_FactorialProblem {
    public static int zeroNum1(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        int cur = 0;
        for (int i = 5; i < num + 1; i++) {
            cur = i;
            while (cur % 5 == 0) {
                res++;
                cur /= 5;
            }
        }
        return res;
    }

    public static int zeroNum2(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }

    public static int rightOne(int num) {
        if (num < 0) {
            return -1;
        }
        int res = 0;
        while (num != 0) {
            num = num >> 1;
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 1000000000;

        System.out.println(zeroNum2(num));
        System.out.println(zeroNum1(num));

        System.out.println(rightOne(num));

    }
}
