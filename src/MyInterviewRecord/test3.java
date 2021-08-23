package MyInterviewRecord;

import java.util.*;

public class test3 {
    public static int MAX_VALUE =100000;
    public static Queue<Integer>queue = new LinkedList<>();
    public static int M = 100;
    public static int max_value = -1;
    public static int max_len = 0;

    public static void fun(){
        int x1 = (int)(Math.random()*MAX_VALUE);
        queue.add(x1);
        process();
    }

    public static void process(){
        if(max_len>=M)return ;
        int x1 = queue.poll();
        int []x2 = new int[x1];
        max_len+=x1;
        for(int i=0;i<x1;++i){
            x2[i] = (int)(Math.random()*Integer.MAX_VALUE);
            max_value = Math.max(max_value,x2[i]);
        }
        int[]R =sorted(x2);
        int lowest = R[x1];
        int highest =  R[x1+1];
        for(int i=0;i<x1;++i){
            int r = R[i];// TODO:
            int x1_  = r*(highest-lowest);
            queue.add(x1_);
        }
        process();

    }
    public static int[] sorted(int[]arr){
        int [][]arrsorted = new int[arr.length][2];
        for(int i=0;i<arr.length;++i){
            arrsorted[i][0] = arr[i];
            arrsorted[i][1] = i;
        }
        Arrays.sort(arrsorted,new MyComparator());
        int[]R = new int[arr.length+2];
        for(int i=0;i<arrsorted.length;++i){
            R[arrsorted[i][1]] = i;
        }
        R[arrsorted.length] = arrsorted[0][0];
        R[arrsorted.length+1] = arrsorted[arrsorted.length-1][0];

        return R;
    }

    public static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[0]<b[0]) return -1;
            else if(a[0]>b[0]) return 1;
            else return 0;
        }
    }

}
