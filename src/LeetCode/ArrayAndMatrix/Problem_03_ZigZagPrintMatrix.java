package LeetCode.ArrayAndMatrix;

/**
 * 之字型打印矩阵
 * 要求：额外空间复杂度O(1)
 * 思路，斜着打印矩阵，上下坐标同时移动
 */
public class Problem_03_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][]matrix){
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc= 0;
        int endr = matrix.length-1;
        int endc= matrix[0].length-1;
        boolean fromUp = false;
        while (tr<endr+1){
            printLevel(matrix,tr,tc,dr,dc,fromUp);

        }
    }

    public
}
