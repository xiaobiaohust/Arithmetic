package LeetCode.ArrayAndMatrix;

/**
 * 子矩阵的最大累加和问题
 * 给定一个矩阵，返回子矩阵的最大累加和
 * 思路：已知求数组的最大累加和，先确定子矩阵的行数，子矩阵每一列元素相加，
 * 得到累加数组，求累加数组的最大累加和，累加数组最大累加和就是该子矩阵的
 * 最大累加和
 */
public class Problem_17_SubMatrixMaxSum {
    public static int maxSum(int[][]m){
        if(m==null||m.length==0||m[0].length==0){
            return 0;
        }
        int max= Integer.MIN_VALUE;
        int cur = 0;
        int[]s = null;
        for(int i=0;i<m.length;++i){
            s = new int[m[0].length];
            for(int j=i;j<m.length;++j){
                cur = 0;
                for(int k=0;k<s.length;++k){
                    s[k]+=m[j][k];
                    cur+=s[k];
                    max = Math.max(max,cur);
                    cur=cur<0?0:cur;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSum(matrix));
    }

}
