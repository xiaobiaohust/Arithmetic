package MyInterviewRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class weipinghui2 {

    public static String fun(String str) {
        String[] chs = str.split(" ");
        long wordsSum = 0;
        HashMap<String, Double> wordsF = new HashMap<>();
        for (int i = 0; i < chs.length; ++i) {
            wordsSum++;
            if (wordsF.containsKey(chs[i])) {
                wordsF.put(chs[i], wordsF.get(chs[i]) + 1.0);
            } else {
                wordsF.put(chs[i], 1.0);
            }
        }
        int i=0;
        String[] keys = new String[wordsF.size()];
        Double[] values = new Double[wordsF.size()];
        double wordsMinP = 1.0;
        for (String key : wordsF.keySet()) {
            double temp = wordsF.get(key) / wordsSum;
            wordsF.put(key, temp);
            keys[i]= key;
            values[i++] = temp;
            if (temp < wordsMinP) wordsMinP = temp;
        }

        int N = wordsF.size();
        int M = (int) (1.0 / wordsMinP) + 1;
        HashMap<Integer, String> map = new HashMap<>();
        int cur =  0;
        double curP = values[cur];
        for (i = 0; i < M; ++i) {
            if(i/(M+0.0)<curP){
                map.put(i,keys[cur]);
            }else{
                cur++;
                curP += values[cur];
                i--;
            }
        }
        int randInt = (int)(Math.random()*M);

        return map.get(randInt);

    }

}
