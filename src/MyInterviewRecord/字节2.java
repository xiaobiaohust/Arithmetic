package MyInterviewRecord;

/**
 * 木板盛水
 */
public class 字节2 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        int[]arr = new int[]{3,5,2,6};
        System.out.print(fun(arr));
    }
    public static int fun(int[]arr){
        if(arr==null||arr.length==1){
            return 0;
        }
        int len = arr.length;
        int[]help1 = new int[len-1];
        int[]help2 = new int[len-1];
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<len-1;++i){
            maxValue = Math.max(maxValue,arr[i]);
            help1[i] = maxValue;
        }
        maxValue = Integer.MIN_VALUE;
        for(int i=len-1;i>0;--i){
            maxValue = Math.max(maxValue,arr[i]);
            help2[i-1] = maxValue;
        }
        int res = 0;
        for(int i=0;i<len-1;++i){
            res+=Math.min(help1[i],help2[i]);
        }
        return res;
    }
}
