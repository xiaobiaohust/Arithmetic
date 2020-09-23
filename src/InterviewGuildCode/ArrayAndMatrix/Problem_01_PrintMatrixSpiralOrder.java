package InterviewGuildCode.ArrayAndMatrix;

/**
 * 转圈打印矩阵
 * 要求：额外空间复杂度O(1)
 * 思路：分圈打印矩阵
 */
public class Problem_01_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matric) {
        int tr = 0;
        int tc = 0;
        int dr = matric.length-1;
        int dc = matric[0].length-1;
        while (tr <= dr && tc <= dc) {
            printEdge(matric, tr++, tc++, dr--, dc--);
        }
    }

    public static void printEdge(int[][] matric, int tr, int tc, int dr, int dc) {
        if (tr == dr) {
            for (int i = tc; i <= dc; ++i) {
                System.out.print(matric[tr][i] + " ");
            }
        } else if (tc == dc) {
            for (int i = tr; i <= dr; ++i) {
                System.out.print(matric[i][tc] + " ");
            }
        } else {
            int curc = tc;
            int curr = tr;
            while (curc != dc) {
                System.out.print(matric[curr][curc++] + " ");
            }
            while (curr != dr) {
                System.out.print(matric[curr++][curc] + " ");
            }
            while (curc != tc) {
                System.out.print(matric[curr][curc--] + " ");
            }
            while (curr != tr) {
                System.out.print(matric[curr--][curc] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}
