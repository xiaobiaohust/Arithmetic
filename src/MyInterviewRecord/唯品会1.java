package MyInterviewRecord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 基于给定词典，对输入的句子进行切割。
 * 提示：词典可以是set，可以假定词的最小长度为1，最大长度为4
 * 给定词典如下：
 * [
 *     "唯品",
 *     "唯品会",
 *     "阿迪达斯",
 *     "阿迪",
 *     "运动鞋",
 *     "运动鞋男",
 *     "！",
 *     ","
 *     "。"
 * ]
 *
 * 输入："唯品会年终庆典！阿迪达斯运动鞋立即抢购。"
 * 输出：["唯品会", "年终庆典", "！", "阿迪达斯", "运动鞋", "立即抢购", "。"]
 */
public class 唯品会1 {
    public static List<String> func() {
        HashSet<String> set = new HashSet<>();
        set.add("唯品");
        set.add("唯品会");
        set.add("阿迪达斯");
        set.add("阿迪");
        set.add("运动鞋");
        set.add("运动鞋男");
        set.add("！");
        set.add(",");
        set.add("。");
        List<String> res = new ArrayList<>();
        String query = "唯品会年终庆典！阿迪达斯运动鞋立即抢购抢购抢购。哈哈哈";
        boolean flag ;
        int preIndex = 0;
        for(int i=0;i<query.length();){
            flag = false;
            for(int j =4;j>0;--j){
                // 对于靠近末尾的会导致越界，需要加个if判断
                if(i+j>query.length()){
                    continue;
                }
                if(set.contains(query.substring(i,i+j))){
                    //上一个匹配preIndex和当前i之间的子串是字典中不存在的词
                    if(i>preIndex){
                        res.add(query.substring(preIndex,i));
                    }
                    preIndex = i+j;
                    res.add(query.substring(i,i+j));
                    i+=j;
                    flag = true;
                    break;
                }
            }
            //从i开始没有匹配到字典，下一个字符开始匹配
            if(!flag){
                i++;
            }

        }
        if(preIndex<query.length())
            res.add(query.substring(preIndex,query.length()));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(func().toString());

    }
}
