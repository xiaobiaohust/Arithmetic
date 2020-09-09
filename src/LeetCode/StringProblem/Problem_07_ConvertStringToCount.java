package LeetCode.StringProblem;

/**
 * 字符串的统计字符串
 * 给定一个字符串str，返回str的统计字符串
 */
public class Problem_07_ConvertStringToCount {
    public static String getCountString(String str){
        if(str==null||str.length()==0){
            return "";
        }
        char[]chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num=1;
        for(int i=1;i<chs.length;++i){
            if(chs[i]==chs[i-1]){
                num++;
            }else{
                res = res+"_"+String.valueOf(num)+"_"+String.valueOf(chs[i]);
                num=1;
            }
        }
        res = res+"_"+String.valueOf(num);
        return res;
    }

    /**
     * 给定一个字符串的统计字符串，在给定一个整数index，原字符串上的
     * 第index个字符
     * @param str
     * @param index
     * @return
     */
    public static char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

    public static void main(String[] args) {
        String str = "aaabbadddffc";
        String res = getCountString(str);
        System.out.println(str);
        System.out.println(res);
        System.out.print(getCharAt(res, 9));

    }


}
