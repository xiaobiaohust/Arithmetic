package MyInterviewRecord;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最长连续子集
 */
public class 字节 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();javascript:void(0);
        //System.out.println(a);
        System.out.println("Hello World!");
        int[]data = new int[]{1,2,3,8,6,5,9,12,7};
        int[]res = fun(data);
        System.out.println(Arrays.toString(res));
    }
    public static int[] fun(int []arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        while(i<arr.length){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            if(map.containsKey(arr[i]-1)){
                merge(map,arr[i]-1,arr[i]);
            }
            if(map.containsKey(arr[i]+1))
            {
                merge(map,arr[i],arr[i]+1);
            }
            ++i;
        }
        for(int key:map.keySet()){
            // System.out.println(key+ "- "+ map.get(key));
        }


        int maxLen = Integer.MIN_VALUE;
        int right = -1;
        for(int key:map.keySet()){
            if(map.get(key)>=maxLen&&key>=right){
                maxLen = map.get(key);
                right = key;
            }

        }
        System.out.println(maxLen+ "- "+right);

        int []res = new int[maxLen];
        for(int j=0;j<maxLen;++j){
            res[maxLen-j-1] = right-j;
        }
        return res;

    }
    public static void merge(HashMap<Integer,Integer> map, int left, int right){
        int leftLen = map.get(left);
        int righLlen = map.get(right);
        int newLeft = left-leftLen+1;
        int newRight = right+righLlen-1;
        int newLen = newRight-newLeft+1;
        map.put(newLeft,newLen);
        map.put(newRight,newLen);
    }
}
