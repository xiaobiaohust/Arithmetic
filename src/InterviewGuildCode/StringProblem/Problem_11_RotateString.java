package InterviewGuildCode.StringProblem;

/**
 * 翻转字符串
 */
public class Problem_11_RotateString {
    /**
     * 题一
     * 给定一个字符类型的数组chs,在单词间做逆序调整，对空格的位置没要求
     * 思想：首先将chs翻转一下，导致单词内部也翻转了一遍，再将单词内部在翻转一遍就OK
     */
    public static void rotateWord(char[] chs) {
        if (chs == null || chs.length == 0) {
            return;
        }
        reverse(chs,0,chs.length-1);
        int l = -1;
        int r =-1;
        for(int i=0;i<chs.length;++i){
            if(chs[i]!=' '){
                l = i==0||chs[i-1]==' '?i:l;
                r = i==chs.length-1||chs[i+1]==' '?i:r;
            }
            if(l!=-1&&r!=-1){
                reverse(chs,l,r);
                l = -1;
                r = -1;
            }
        }


    }

    public static void reverse(char[] chs, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 补充题目
     * 给定一个字符类型的数组chs和一个整数size，把大小为size的左半区域整体
     * 移到右半区域，右半区域整体移到左边
     * @param
     */
    public static void rotate1(char[]chs,int size){
        if(chs==null||chs.length==0||size<=0||size>=chs.length){
            return;
        }
        reverse(chs,0,size-1);
        reverse(chs,size,chs.length-1);
        reverse(chs,0,chs.length-1);
    }



    public static void main(String[] args) {
        char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
                'i', 'g' };
        System.out.println(String.valueOf(chas1));
        rotateWord(chas1);
        System.out.println(String.valueOf(chas1));

        char[] chas2 = { '1', '2', '3', '4', '5', 'A', 'B', 'C' };
        System.out.println(String.valueOf(chas2));
        rotate1(chas2, 5);
        System.out.println(String.valueOf(chas2));


    }

}
