package InterviewGuildCode.StackAndQueue;


import java.util.LinkedList;

/**
 * 最大值减去最小值小于或小等于num的子数组数量
 *要求：给定数组arr和整数num，返回有多少个子数组满足如下情况：
 * max（arr[i:j]）-min(arr[i:j])<=nums,数组长度为N，
 * 要求：算法复杂度为O(N)
 *
 * 理解：假设子数组arr[i,j]满足条件，则该子数组的所有子数组也满足条件；
 * 假设子数组arr[i:j]不满足条件，则包含子数组的所有其他数组都不满足条件
 *
 * 思路1：暴力解法，找到arr的所有子数组，一共有O（n^2）个，每个子数组遍历找到最大值最小值
 * ，时间复杂度O（N），整体时间复杂度O (N^3)
 *
 * 思路2：使用双端队列解决这个问题，类似滑动窗口
 * 使用两个双端队列qmax、qmin来维护子窗口数组的最大值最小值更新结构。
 * qmax的对头一种维持最大值，并且从对头到队尾依次递减；
 * qmin的对头一直维持最小值，并且从对头到队尾依次增加
 * i,j分别是子数组的头和尾，依次遍历原始数组，先固定子数组的头i,依次增加，同时更新qmax和qmin
 * 当不满足条件的时候，i+1,在更新j,i,j只会增加，不会减少，同时每个元素只会push qmax和qmin一次，pop一次
 * 可求出时间复杂度O（N）
 */
public class Problem_10_AllLessNumSubArray {
    public static int getNum(int[] arr,int num){
        if(arr==null||arr.length==0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0;
        int j=0;
        int res=0;
        while(i<arr.length){
            //只要满足条件，j就一直向右拓展
            while(j<arr.length){
                while(!qmin.isEmpty()&&arr[qmin.peekLast()]>arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty()&&arr[qmax.pollLast()]<arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }

    public static int[] getRandomArray(int len){
        if(len<0){
            return null;
        }
        int[] arr = new int[len];
        for(int i=0;i<len;++i){
            arr[i] = (int) (Math.random()*10);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        if(arr!=null){
            for(int i=0;i<arr.length;++i){
                System.out.println(arr[i]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[]args){
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr,num));
    }
}
