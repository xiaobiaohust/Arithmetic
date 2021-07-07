package InterviewGuildCode;

import java.util.Arrays;
import java.util.HashSet;

public class test {

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[][]m = new int[n][n];
        for(int i =0;i<n;++i){
            Arrays.fill(m[i], Integer.MAX_VALUE);
            m[i][i] = 0;
        }
        for(int i=0;i<times.length;++i){
            m[times[i][0]-1][times[i][1]-1] = times[i][2];
        }

        int []dis = new int[n];
        for(int i=0;i<n;++i){
            dis[i] = m[k-1][i];
        }
        HashSet<Integer> used = new HashSet<>();
        used.add(k-1);
        for(int i=1;i<n;++i){
            int min =Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j=0;j<n;++j){
                if(!used.contains(j)&&dis[j]<min){
                    min = dis[j];
                    minIndex = j;
                }
            }
            used.add(minIndex);

            for(int j=0;j<n;++j){
                int newValue = dis[minIndex]+m[minIndex][j];
                if(!used.contains(j)&&m[minIndex][j]!=Integer.MAX_VALUE&&newValue<dis[j]){
                    dis[j] = newValue;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            if(dis[i]==Integer.MAX_VALUE)return -1;
            max = Math.max(max, dis[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {2, 1, 1}
                , {2, 3, 1}
                , {3, 4, 1}};
        int nums = networkDelayTime(graph, 4,2);

    }


}
