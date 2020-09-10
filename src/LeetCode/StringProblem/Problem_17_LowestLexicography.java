package LeetCode.StringProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接所有字符串产生字典顺序最小的字符串
 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，使得所有的字符拼接起来
 * 组成的大写字符串是所有可能性中字典顺序最小的
 *
 * 错误思路：直接将字符串数组按照字典排序排序，
 *      比如b,ba连接bba,bab，
 *
 * 正确思路：排序需要改，分别将两个字符串a,b拼接成a.b 、b.a，
 *      如果a.b <b.a，则a放前面
 *
 *
 *
 */

public class Problem_17_LowestLexicography {
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            return (a+b).compareTo(b+a);
        }
    }

    public static String lowestString(String[]strs){
        if(strs==null||strs.length==0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i=0;i<strs.length;++i){
            res+=strs[i];
        }
        return res;
    }


    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
