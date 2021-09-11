package MyInterviewRecord;

import java.util.Arrays;

/**
 * 最长回文子串
 */
public class 得物 {
    public static  String fun(String str){
        char[]chs = str.toCharArray();
        int len = chs.length;
        boolean [][] dp = new boolean[len][len];//
        int maxlen = Integer.MIN_VALUE;
        int startIndex = -1;
        for(int j=0;j<len;++j){
            for(int i=j;i>=0;--i){
                if((i==j)||(j-i==1 &&chs[i]==chs[j])||(j-i>1&&chs[i]==chs[j]&&dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i+1>maxlen){
                        startIndex = i;
                        maxlen = j-i+1;
                    }
                }
            }
        }
        return str.substring(startIndex,startIndex+maxlen);

    }
    public static void main(String[]args){
        String str ="babad";
        System.out.println(fun(str));
    }
}
