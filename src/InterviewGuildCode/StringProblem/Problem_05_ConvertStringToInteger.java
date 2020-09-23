package InterviewGuildCode.StringProblem;

/**
 * 整数字符串转为整数
 */
public class Problem_05_ConvertStringToInteger {
    public static boolean isValid(char[]chs){
        if(chs[0]!='-'&&(chs[0]<'0'||chs[0]>'9')){
            return false;
        }
        if(chs[0]=='-'&&(chs.length==1||chs[1]=='0')){
            return false;
        }
        if(chs[0]=='0'&&chs.length>1){
            return false;
        }
        for(int i=1;i<chs.length;++i){
            if(chs[i]<'0'||chs[i]>'9'){
                return false;
            }
        }
        return true;
    }

    public static int convert(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[]chs = str.toCharArray();
        if(!isValid(chs)){
            return 0;
        }
        boolean posi = chs[0]=='-'?false:true;
        int minq = Integer.MIN_VALUE/10;
        int minr = Integer.MIN_VALUE%10;
        int res = 0;
        int cur = 0;
        for(int i=posi?0:1;i<chs.length;++i){
            cur = '0'-chs[i];
            if((res<minq)||(res==minq&&cur<minr)){
                return 0;
            }
            res = res*10+cur;
        }
        //越界了
        if(posi&&res== Integer.MIN_VALUE){
            return 0;
        }
        return posi?-res:res;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convert(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));

        String test5 = "-123";
        System.out.println(convert(test5));

    }
}
