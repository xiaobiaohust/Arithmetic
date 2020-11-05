package InterviewGuildCode.ArrayAndMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路值
 * 用一个整形矩阵matrix表示一个网络，1代表有路，0代表无路，每一个位置只要不越界
 * 都有上下左右四个方向，求从最左上角到最右下角的最短通路值
 * 思路：使用宽度优先遍历，时间复杂度O(NxM)
 * 1：生成一个map矩阵，map[i][j]的含义是从位置(0,0)走到(i,j)位置的最短路径值，
 * 开始将左上角位置行坐标以及列坐标分别放入行队列和rQ列队列cQ
 * 2：不断从队列弹出一个位置，看看这个坐标上下左右那些是1，这些都是能走的位置，压入队列
 * 3：将那些能走的位置设置各自在map中的值，即map[i][j]+1
 * 4：如果一个位置之前走过，就不要重复走，可以更具一个map中的值来确定
 * 5：一直重复上述步骤，直到遇到右下角位置结束，若队列为空还未到终点，则说明不存在
 * 这样的路径
 */
public class Problem_24_MinPathValue {
    public static int minPathValue(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1 || m[m.length - 1][m[0].length - 1] != 1) {
            return 0;
        }
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            if (r == m.length - 1 && c == m[0].length - 1) {
                return map[r][c];
            }
            walkTo(m, map, map[r][c], r - 1, c, rQ, cQ);
            walkTo(m, map, map[r][c], r + 1, c, rQ, cQ);
            walkTo(m, map, map[r][c], r, c - 1, rQ, cQ);
            walkTo(m, map, map[r][c], r, c + 1, rQ, cQ);

        }
        return 0;
    }

    public static void walkTo(int[][] m, int[][] map, int pre, int r, int c, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length || m[r][c] != 1 || map[r][c] != 0) {
            return;
        }
        map[r][c] = pre + 1;
        rQ.add(r);
        cQ.add(c);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1}};
        System.out.println(minPathValue(matrix));


    }
}
