package MyInterviewRecord;

import java.util.*;

/**
 *
 */

public class 米哈游 {
    public static int[] fun(String[] data) {
        HashMap<String, Set<String>> userToSession = new HashMap<>();
        HashMap<String, ArrayList> sessionToTime = new HashMap<>();

        for (String str : data) {
            String[] strArr = str.split("\t");

            if (!userToSession.containsKey(strArr[0])) {
                userToSession.put(strArr[0], new HashSet<>());
            }
            userToSession.get(strArr[0]).add(strArr[1]);

            if(!sessionToTime.containsKey(strArr[2])) {
                sessionToTime.put(strArr[2], new ArrayList<Integer>());
            }
            sessionToTime.get(strArr[2]).add(Integer.valueOf(strArr[4]));
        }

        //HashMap<String,Integer>userIdCostTimes = new HashMap<>();
        int[]cost = new int[userToSession.size()];
        int i=0;
        for(String userId:userToSession.keySet()){
            int costTime = 0;
            Set<String>sessionIdSet = userToSession.get(userId);
            for(String sessionId:sessionIdSet){
                List<Integer>times = sessionToTime.get(sessionId);
                if(times.size()!=2){
                    continue;
                }
                costTime+=Math.abs(times.get(0)-times.get(1));
            }
            //userIdCostTimes.put(userId,costTime);
            cost[i++] = costTime;
        }

        return  new int[1];

    }
    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
