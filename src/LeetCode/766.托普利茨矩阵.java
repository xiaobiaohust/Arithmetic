/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; ++j) {
            int i = 0;
            int value = matrix[i][j];
            int i_ = i;
            int j_ = j;
            while (i_ < m && j_ < n) {
                if (matrix[i_++][j_++] != value) {
                    return false;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            int j = 0;
            int value = matrix[i][j];
            int i_ = i;
            int j_ = j;
            while (i_ < m && j_ < n) {
                if (matrix[i_++][j_++] != value) {
                    return false;
                }
            }
        }
        return true;

    }
}
// @lc code=end
