package InterviewGuildCode.StringProblem;

/**
 * 0左边必有1的二进制字符串数量
 * 给定一个整数N，求由"0"字符与"1"字符组成的长度为N的所有字符串中，满足"0"字符
 * 的左边必有"1"字符的字符串数量
 */
public class Problem_16_ZeroLeftOneStringNumber {
    /**
     * 一：暴力解法
     * 长度为N的字符串种类为2^N，每个字符串判断是否符合要求时间复杂度O(N)
     * 整体时间复杂度O(2^N x N)
     *
     * 二：递归 ，时间复杂度O(2^N)
     * 1：p(i)表示0~i-1位置上的字符已经确定，且第i-1位置的字符为1，有多少种
     * 符合要求的字符串
     *      p(i) = p(i+1)+p(i+2)
     *      p(N-1) = 2
     *      p(N) =1
     */
    public static int getNum1(int n){
        if(n<1){
            return 0;
        }
        return process(1,n);
    }
    public static int process(int i,int n){
        if(i==n){
            return 1;
        }else if(i==n-1){
            return 2;
        }
        return process(i+1,n)+process(i+2,n);
    }

    /**
     * 形如斐波那契数列，可以实现时间复杂度O(N)，空间复杂度O(1)
     * @param n
     * @return
     */
    public static int getNum2(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int pre = 1;
        int cur = 2;
        for(int i=3;i<n+1;i++){
            int temp = cur;
            cur+=pre;
            pre = temp;
        }
        return cur;
    }

    /**
     * 斐波那契是可以通过矩阵相乘的方法将时间复杂度降低为O(logN)
     * @param n
     * @return
     */
    public static int getNum3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[][] base = { { 1, 1 }, { 1, 0 } };
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
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
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i != 20; i++) {
            System.out.println(getNum1(i));
            System.out.println(getNum2(i));
            //System.out.println(getNum3(i));
            System.out.println("===================");
        }

    }
}
