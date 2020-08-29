package LeetCode.RecursionAndDp;

/**
 * 斐波那契系列问题的递归的动态规划
 * 题1：给定整数N，返回斐波那契数列的d第N项
 * 题2：给定整数N，代表台阶数，一次可以跨2或者1个台阶，返回有多少种走法
 * 题3：母牛每年只会生一头小母牛，第一年只有一只成熟母牛，从第二年开始开始生牛，小母牛三年只会1成熟
 * 又可以省母牛，给定整数N，求N年后牛的数量
 * <p>
 * 要求：时间复杂度O（log N）
 */
public class Problem_01_FibonacciProblem {
    /**
     * 题1：
     * 方法一：使用递归，F(N)= F(N-1)+F(2)，时间复杂度O（2^N）
     * 方法二：从左到右依次求出每一项的值，顺序求第N项，时间复杂度O（N）
     * 方法三：如果递归式遵循F（N）= F(N-1)+F(N-2)，则可以用矩阵乘法的形式，
     * 将求斐波那契数列第N项的问题转换为求一个矩阵的N次方，时间复杂度O（log N）
     * 求一个整数的N次方，假设N=75，整数为10
     * 75的二进制：1001011，分别求出10^1,10^2....,则只需要求二进制位数的乘法
     */
    public static int fib1(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    public static int fib2(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int tem1 = 1;
        int tem2 = 1;
        int res = 0;
        for (int i = 3; i <= N; ++i) {
            res = tem1 + tem2;
            tem1 = tem2;
            tem2 = res;
        }
        return res;
    }

    public static int fib3(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, N - 2);
        return res[0][0] + res[1][0];

    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; ++i) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; ++i) {
            for (int j = 0; j < m2[0].length; ++j) {
                for (int k = 0; k < m1[0].length; ++k) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    /**
     * 题2：台阶问题
     * O（log N）的方法，S(N)=S(N-1)+S(N-2)，也是一个二阶递推数列
     */
    public static int s3(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return N;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, N - 2);
        return 2 * res[0][0] + res[1][0];
    }

    /**
     * 题3：母牛生牛
     * 母牛不会死，第N-1年的牛会活到第N年；新增牛的数量等于第N-3年的数量
     * C(N)=C(N-1)+C(N-3)，C(1)=1，C(2)=2，C(3)=3,是一个三阶递推数列，可以用
     * 3X3矩阵表示
     * （Cn,Cn-1,Cn-2） = (C3,C2,C1) *  Matrix^(N-3),代入前几项，求出矩阵
     */
    public static int c1(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2 || N == 3) {
            return N;
        }
        return c1(N - 1) + c1(N - 3);
    }

    public static int c2(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2 || N == 3) {
            return N;
        }
        int pre = 3;
        int prepre = 2;
        int preprepre = 1;
        int res = 0;
        for (int i = 4; i <= N; ++i) {
            res = pre + preprepre;
            preprepre = prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }

    public static int c3(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1 || N == 2 || N == 3) {
            return N;
        }
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, N - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }


    public static void main(String[] args) {

        /***************测试斐波那契数列的时间复杂度********************/
        int N = 10;
        long start = System.currentTimeMillis();
        //System.out.println(String.format("第%d项斐波那契数列为%d：---cost time:%d", N, fib1(N), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("第%d项斐波那契数列为%d：---cost time:%d", N, fib2(N), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("第%d项斐波那契数列为%d：---cost time:%d", N, fib3(N), System.currentTimeMillis() - start));

        /********************测试台阶种类*************************/
        start = System.currentTimeMillis();
        System.out.println(String.format("台阶数为%d的种类为%d：---cost time:%d", N, s3(N), System.currentTimeMillis() - start));

        /********************母牛生牛*************************/
        start = System.currentTimeMillis();
        System.out.println(String.format("第%d年的母牛数目为%d：---cost time:%d", N, c1(N), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("第%d年的母牛数目为%d：---cost time:%d", N, c2(N), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("第%d年的母牛数目为%d：---cost time:%d", N, c3(N), System.currentTimeMillis() - start));

    }

}
