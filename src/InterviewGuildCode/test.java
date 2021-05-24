package InterviewGuildCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class test {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    public static int process(int i, int[] record, int n) {
        if(i==n){
            return 1;
        }
        int res = 0;
        for(int j=0;j<n;++j){
            if(isValid(record,i,j)){
                record[i]=j;
                res+=process(i+1,record,n);
            }
        }
        return res;
    }
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; ++k) {
            if (record[k] == j || Math.abs(i - k) == Math.abs(j - record[k])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababac";
        System.out.println(num1(8));
    }
}
