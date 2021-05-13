package InterviewGuildCode.ArrayAndMatrix;

/**
 * 边界都是1的最大正方形大小
 * 给定一个NxN矩阵matrix，矩阵中只有0和1，返回边框全是1的最大正方形的边长长度
 * 方法一：暴力解法，通过确定左上角、右下角可以确定一个矩阵，时间复杂度为O(N^3)，每个矩阵
 * 判断边框是否全是1，时间复杂度O(N)，整体时间复杂度O(N^4)
 * 方法二：在暴力解法的基础上，进行优化，时间复杂度O(N^3)。判断一个矩阵是否满足条件，可以
 * 从O(N)降为O(1)，通过提前计算两个统计矩阵，达到要求
 */
public class Problem_21_MaxOneBorderSize {

    public static int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBoardMap(m, right, down);
        for (int size = Math.min(m.length, m[0].length); size > 0; --size) {
            if (hasSizeOfBoard(size, right, down)) {
                return size;
            }
        }
        return 0;
    }

    public static void setBoardMap(int[][] m, int[][] right, int[][] down) {
        int row = m.length;
        int col = m[0].length;
        if (m[row - 1][col - 1] == 1) {
            right[row - 1][col - 1] = 1;
            down[row - 1][col - 1] = 1;
        }
        for (int i = row - 2; i > -1; --i) {
            if (m[i][col - 1] == 1) {
                right[i][col - 1] = 1;
                down[i][col - 1] = down[i + 1][col - 1] + 1;
            }
        }
        for (int j = col - 2; j > -1; --j) {
            if (m[row - 1][j] == 1) {
                right[row - 1][j] = right[row - 1][j + 1] + 1;
                down[row - 1][j] = 1;
            }
        }
        for (int i = row - 2; i > -1; --i) {
            for (int j = col - 2; j > -1; --j) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    public static boolean hasSizeOfBoard(int size, int[][] right, int[][] down) {
        for (int i = 0; i < right.length - size + 1; ++i) {
            for (int j = 0; j < right[0].length - size + 1; ++j) {
                if (right[i][j] >= size && down[i][j] >= size
                        && right[i + size - 1][j] >= size
                        && down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandom01Matrix(7, 8);
        printMatrix(matrix);
        System.out.println(getMaxSize(matrix));
    }
}
