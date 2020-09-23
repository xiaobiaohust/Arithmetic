package InterviewGuildCode.ArrayAndMatrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 在数组中找到出现次数大于N/K的数
 * 题1：给定一个数组arr，打印其中出现次数大于一半的数，时间复杂度O(N)，空间复杂度O(1)
 * 题2：给定一个数组arr，给定一个数k，打印所有出现次数大于N/K的数，时间复杂度O(NxK)，空间复杂度O(K)
 * <p>
 * 思路1：使用哈希表，记录每个数出现的次数，空间复杂度不满足要求
 * 思路2：一次在数组中删掉k个不同的数，直到整下数的种类不足k就停止，那么
 * 删除的次数一定小于N/K，所以大于N/K的数一定会在最后被剩下来
 */
public class Problem_06_FindKMajority {
    public static void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;
        //循环删除2个不同的元素
        for (int i = 0; i < arr.length; ++i) {
            if (times == 0) {
                cand = arr[i];
                times++;
            } else if (cand == arr[i]) {
                times++;
            } else {
                times--;
            }
        }

        times = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("no such number");
        }
    }

    /**
     * 进阶问题，建立k-1个候选，遍历循环删除k个不同的元素
     * @param arr
     * @param k
     */
    public static void printKMajor(int[]arr,int k){
        if(k<2){
            System.out.println("the value of k is invalid");
            return;
        }
        HashMap<Integer,Integer>cands = new HashMap<>();
        for(int i=0;i<arr.length;++i){
            if(cands.containsKey(arr[i])){
                cands.put(arr[i],cands.get(arr[i])+1);
            }else{
                if(cands.size()==k-1){
                    allCandsMinusOne(cands);
                }else{
                    cands.put(arr[i],1);
                }
            }
        }
        HashMap<Integer,Integer>reals = getReals(arr,cands);
        boolean hasPrint = false;
        for(int key:reals.keySet()){
            if(reals.get(key)>arr.length/k){
                hasPrint = true;
                System.out.print(key+" ");
            }
        }
        if(!hasPrint){
            System.out.println("no such number");
        }
    }

    //一次删除k个元素
    public static void allCandsMinusOne(HashMap<Integer,Integer>map){
        List<Integer>removeList = new LinkedList<>();
        for(int key:map.keySet()){
            int value = map.get(key);
            if(value==1){
                removeList.add(key);
            }
            map.put(key,value-1);
        }
        for(int key:removeList){
            map.remove(key);
        }
    }
    //统计最后的候选集中每个元素出现的次数
    public static HashMap<Integer,Integer>getReals(int[]arr,HashMap<Integer,Integer>cands){
        HashMap<Integer,Integer>reals = new HashMap<>();
        for(int i=0;i<arr.length;++i){
            if(cands.containsKey(arr[i])){
                if(reals.containsKey(arr[i])){
                    reals.put(arr[i],reals.get(arr[i])+1);
                }else{
                    reals.put(arr[i],1);
                }
            }
        }
        return reals;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 2, 1 };
        printHalfMajor(arr);
        int K = 4;
        printKMajor(arr, K);
    }

}
