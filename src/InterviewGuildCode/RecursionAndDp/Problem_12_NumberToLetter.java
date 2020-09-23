package InterviewGuildCode.RecursionAndDp;

/**
 * 数字字符串转换为字母组合的种数
 * 给定一个字符串str，str全部由数字组成，str种某一个或两个相邻的字符组成的子串值在1~26之间
 * 的可以转换为一个字母，求str有多少种不同的转换结果
 */
public class Problem_12_NumberToLetter {
    /**
     * 暴力递归
     * 定义一个递归函数p(i)，表示str[0~i-1]以及转换，str[i~N]还未转换
     * 的情况下，合法的转换种数有多少
     * 1：p[N] = 1
     * 2：str[i]='0'，直接返回0
     * 3：不满足1,2条件，则p(i) = p(i+1)
     * 4：如果str[i~i+1]在10~26之间，则p(i)+=p(i+2)
     *
     * 时间复杂度O(2^N)，空间复杂度O(N)，主要是函数栈
     */
    public static int num1(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[]chs = str.toCharArray();
        return process(chs,0);
    }
    public static int process(char[]chs,int index){
        if(index==chs.length){
            return 1;
        }
        if(chs[index]=='0'){
            return 0;
        }
        int res = process(chs,index+1);
        if(index+1<chs.length&&(chs[index]-'0')*10+chs[index+1]-'0'<27){
            res+=process(chs,index+2);
        }
        return res;
    }

    /**
     * 通过类似菲薄拉起数列的求解过程，从后往前计算
     * p[N]=1
     * p[N-1] = chs[]
     * @param str
     * @return
     */
    public static int num2(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[]chs = str.toCharArray();
        int cur = chs[chs.length-1]=='0'?0:1;
        int next = 1;
        for(int i=chs.length-2;i>=0;i--){
            if (chs[i] == '0') {
                next = cur;
                cur = 0;
            }else{
                int tmp = cur;
                if((chs[i]-'0')*10+chs[i+1]-'0'<27){
                    cur+=next;
                }
                next = tmp;
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        String str = "781231783161018231";
        System.out.println(num1(str));
        System.out.println(num2(str));

    }
}
