package InterviewGuildCode.ArrayAndMatrix;

/**
 * 在行列都排好序的矩阵中找数
 * 给定一个NxM的矩阵m,和一个整数k,判断k是否在矩阵中
 * 要求：时间复杂度O(N+M)，额外空间复杂度O(1)
 * 思路，从一个角开始，一边比它小，一边比它大就OK
 */
public class Problem_07_FindNumInSortedMatrix {
    public static boolean isContains(int[][]m,int k){
        if(m==null||m.length==0||m[0]==null||m[0].length==0){
            return false;
        }
        int row = 0;
        int col =m[0].length-1;
        while (row<m.length&&col>-1){
            if(m[row][col]==k){
                return true;
            }else if(m[row][col]<k){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }

}
