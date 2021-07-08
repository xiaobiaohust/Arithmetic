package JianZhiOffer.Chapter2;

/**
 * 替换空格
 * 把传入的字符数组中的空格替换成‘%20’，且传入数组保证有足够的空间容纳修改后的字符
 */
public class P51_ReplaceSpaces {
    public static void replaceBlank(char[]data){
        int charlen = 0;
        int spacelen = 0;
        for(int i=0;i<data.length;++i){
            if(data[i]==0){
                break;
            }
            if(data[i]==' ') spacelen++;
            charlen++;
        }
        int j=charlen+2*spacelen-1;
        for(int i=charlen-1;i>-1;--i){
            if(data[i]==' '){
                data[j--]= '0';
                data[j--]= '2';
                data[j--]= '%';
            }else{
                data[j--] = data[i];
            }
        }
    }
    public static void main(String[] args){
        char[] predata = "We are happy.".toCharArray();
        char[] data = new char[20];
        for(int i=0;i<predata.length;i++)
            data[i] = predata[i];
        System.out.println(data);
        replaceBlank(data);
        System.out.println(data);
    }
}
