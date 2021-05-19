package InterviewGuildCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class test {
    public static int getIndexOf(String s, String m) {

        if (s == null || m == null || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] mm = m.toCharArray();
        int[] nextArray = getNextArray(mm);
        int si = 0;
        int mi = 0;
        while (si<ss.length&&mi<mm.length){
            if(ss[si]==mm[mi]){
                si++;
                mi++;
            }else if(nextArray[mi]==-1){
                si++;
            }else{
                mi = nextArray[mi];
            }
        }
        return mi==mm.length?si-mi:-1;


    }

    public static int[] getNextArray(char[] mm) {
        if (mm.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[mm.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = next[i - 1];
        while (i < next.length) {
            if (mm[i - 1] == mm[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababac";
        System.out.println(getIndexOf(str, match));
    }
}
