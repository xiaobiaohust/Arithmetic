package JianZhiOffer.Chapter2;

/**
 * 二维数组，从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有该数
 */
public class P44_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatric(int[][]data,int target){
        if(data==null||data.length==0||data[0].length==0){
            return false;
        }
        int row = data.length;
        int col = data[0].length;
        int i=0;
        int j=col-1;
        while (i<row&&j>-1){
            if(data[i][j]==target){
                return true;
            }else if(data[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;

    }

    public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(findInPartiallySortedMatric(data, 10));
        System.out.println(findInPartiallySortedMatric(data, 5));
    }
}
