package MyInterviewRecord;

public class test5 {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] mm = m.toCharArray();
        int[] next = getNextArray(mm);
        int si = 0;
        int mi = 0;
        while (si<ss.length&&mi<mm.length){
            if(ss[si]==mm[mi]){
                si++;
                mi++;
            }
            else if(mi==0){
                si++;
            }else{
                mi = next[mi];
            }
        }
        return mi==mm.length?si-mi:-1;

    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int k = next[i - 1];
        while (i < ms.length) {
            if (ms[i - 1] == ms[k]) {
                next[i] = ++k;
            } else if (k > 0) {
                k = next[k];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
