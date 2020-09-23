package InterviewGuildCode.ArrayAndMatrix;

/**
 * 将正方形矩阵顺时针转动90度
 * 要求：额外空间复杂度O(1)
 * 思路：分圈处理的方式
 */
public class Problem_02_RotateMatrix {
    public static void rotate(int[][]m){
        int tr = 0;
        int tc = 0;
        int dr = m.length-1;
        int dc = m[0].length-1;
        while (tr<dr){
            rotateEdge(m,tr++,tc++,dr--,dc--);
        }
    }
    public static void rotateEdge(int[][]m,int tr,int tc,int dr,int dc){
        for(int i=0;i<dc-tc;++i){
            int tmp = m[tr][tc+i];
            m[tr][tc+i] = m[dr-i][tc];
            m[dr-i][tc] = m[dr][dc-i];
            m[dr][dc-i] = m[tr+i][dc];
            m[tr+i][dc] = tmp;
        }
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
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
