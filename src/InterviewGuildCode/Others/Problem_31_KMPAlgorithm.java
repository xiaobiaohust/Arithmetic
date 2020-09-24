package InterviewGuildCode.Others;

/**
 * KMP算法
 * 给定两个字符串str、match，长度分别为N、M，判断match是否是str的子串，
 * 是则返回在str中的开始位置，不是则返回-1
 *
 * 普通解法：时间复杂度O(NxM)，每次都从头开始遍历
 * KMP算法：时间复杂度O(N+M)
 * 1：求match数组对应的nextArr数组，nextArr[i]表示的含义是：match[i]之前的
 * 字符串，以match[i-1]结尾的后缀与以match[0]开头的前缀的的最大匹配长度
 *      * nextArr[0]=-1,nextArr[1] =0
 *      * 求解nextArr[i],已知nextArr[i-1],match[i] = A,match[i-1] = B
 *      * k =nextArr[i-1],
 *      * if match[k] = B,则nextArr[i]= k+1
 *      * if match[k] ！= B, k = nextArr[k],重复上述步骤，直到到最左
 *      或者相等为止
 *      时间复杂度为O(M)
 *
 * 2：假设从str[i]开始匹配，匹配到j位置不相等，k = nextArr[j-i],
 *    str继续从j开始，match从k开始，匹配，整个过程str一直向右遍历
 *    时间复杂度O(N)
 *
 */
public class Problem_31_KMPAlgorithm {
    public static int getIndexOf(String s,String m){
        if(s==null||m==null||s.length()<m.length()){
            return -1;
        }
        char[]ss = s.toCharArray();
        char[]ms = m.toCharArray();
        int[]nextArr = getNextArray(ms);
        int si = 0;
        int mi = 0;
        while (si<ss.length&&mi<ms.length){
            if(ss[si]==ms[mi]){
                si++;
                mi++;
            }else if(nextArr[mi]==-1){
                //第一个数就不相等
                si++;
            }else{
                mi = nextArr[mi];
            }
        }
        return mi==ms.length?si-mi:-1;
    }

    public static int[]getNextArray(char[] ms){
        if(ms.length==1){
            return new int[]{-1};
        }
        int []next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = next[i-1];
        while (i<next.length){
            if(ms[i-1] ==ms[cn]){
                next[i++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
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
