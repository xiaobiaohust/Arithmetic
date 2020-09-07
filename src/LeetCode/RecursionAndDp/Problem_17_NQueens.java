package LeetCode.RecursionAndDp;

/**
 * N 皇后问题
 * N皇后问题是指在NxN的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，
 * 也不再同一条斜线上，给定一个整数n，返回n皇后的摆法有多少种
 */
public class Problem_17_NQueens {
    /**
     * 1：(i,j)已放置，满足下列条件不能放置
     * 整个第i行不能放置
     * 整个第j不能放置
     * 如果位置(a,b)，满足\a-i\ = \b-j\,则说明在一条斜线上，也不能
     * 2：可以采用逐行放置皇后的方式，判断是否满足放置条件
     *
     * @param n
     * @return
     */
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; ++j) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; ++k) {
            if (record[k] == j || Math.abs(i - k) == Math.abs(j - record[k])) {
                return false;
            }
        }
        return true;
    }

    public static int num2(int n) {
        return 0;
    }

    public static void main(String[] args) {
        int n = 13;
        long start = System.currentTimeMillis();
        System.out.println(num1(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        //System.out.println(num2(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }

}
