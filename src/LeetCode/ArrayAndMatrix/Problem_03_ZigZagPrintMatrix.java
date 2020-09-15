package LeetCode.ArrayAndMatrix;

/**
 * 之字型打印矩阵
 * 要求：额外空间复杂度O(1)
 * 思路，斜着打印矩阵，上下坐标同时移动
 */
public class Problem_03_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        int endr = matrix.length - 1;
        int endc = matrix[0].length - 1;
        boolean flag = false;
        while (tr < endr + 1) {
            printLevel(matrix, tr, tc, dr, dc, flag);
            tr = tc == endc ? tr + 1 : tr;
            tc = tc == endc ? tc : tc + 1;
            dc = dr == endr ? dc + 1 : dc;
            dr = dr == endr ? dr : dr + 1;
            flag = !flag;
        }
    }

    public static void printLevel(int[][] matrix, int tr, int tc, int dr, int dc, boolean flag) {
        if (flag) {
            while (tr < dr + 1) {
                System.out.print(matrix[tr++][tc--] + " ");
            }
        } else {
            while (dr > tr - 1) {
                System.out.print(matrix[dr--][dc++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }

}
