package LeetCode.RecursionAndDp;

/**
 * 矩阵的最小路径和
 */
public class Problem_02_MinPathSum {
    /**
     * 给定一个矩阵，从左上角到右下角，每次只能向下或者向右，路径上所有数字和就是路径和，求最小路径和
     * 思想：新建一个dp矩阵，可以实现时间复杂度O(MxN)，空间复杂度O(MxN)
     * @param m
     * @return
     */
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = m[i][j] + Math.min(dp[i - 1][j],dp[i][j - 1])  ;
            }
        }
        printMatrix(dp);
        return dp[row-1][col-1];
    }

    /**
     * 方法二：对方法一进行优化，可以使空间复杂度降为O（min(M,N)）
     * @param m
     * @return
     */
    public static int minPathSum2(int[][]m){
        if(m==null||m.length==0||m[0]==null||m[0].length==0){
            return 0;
        }
        int more = Math.max(m.length, m[0].length); // 行数与列数较大的那个为more
        int less = Math.min(m.length, m[0].length); // 行数与列数较小的那个为less
        boolean rowmore = more == m.length; // 行数是不是大于等于列数
        int[] arr = new int[less]; // 辅助数组的长度仅为行数与列数中的最小值
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j])
                        + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }


    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int[][] m = generateRandomMatrix(3, 4);
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 },
                { 8, 8, 4, 0 } };
        printMatrix(m);
        System.out.println(minPathSum1(m));
        //System.out.println(minPathSum2(m));

    }
}
