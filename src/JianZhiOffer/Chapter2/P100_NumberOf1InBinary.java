package JianZhiOffer.Chapter2;

public class P100_NumberOf1InBinary {
    // 输入n不能是负数，负数右移的话，在左边添加的是1
    public static int numberOfOne1(int n){
        int count = 0;
        while (n!=0){
            if((n&1)!=0)count++;
            n>>=1;
        }
        return count;
    }
    //输入n可以是负数，移位的是无符号数，
    public static int numberOfOne2(int n){
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if((flag&n)!=0)count++;
            flag<<=1;
        }
        return count;
    }

    public static void main(String[] args){

        System.out.println(numberOfOne1(3));
        //System.out.println(numberOfOne1(-3));
        System.out.println(numberOfOne2(3));
        System.out.println(numberOfOne2(-3));

        System.out.println();
    }
}
