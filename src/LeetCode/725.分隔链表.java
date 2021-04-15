import java.util.List;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[]result = new ListNode[k];

        // 遍历得到链表的节点个数
        int nodeNum = 0;
        ListNode cur = root;
        while(cur!=null){
            nodeNum++;
            cur = cur.next;
        }

        // 链表节点个数小于k,后面全部是null
        if(nodeNum<k){
            cur = root;
            ListNode pre = null;
            for(int i=0;i<k;++i){
                if(cur!=null){
                    result[i] = cur;
                    if(pre!=null){
                        pre.next = null;
                    }
                    pre = cur;
                    cur = cur.next;
                }else{
                    result[i] = null;
                }
            }
            return result;

        }

        // 链表节点数大于k,分为两部分，前面一部分的节点数比后一部分的节点数大1
        int numDiv = nodeNum/k;
        int numMod = nodeNum%k;
        ListNode pre = null;
        cur = root;
        int index = 0;
        int i=0;
        while (index<(numDiv+1)*numMod){
            if(index%(numDiv+1)==0){
                result[i++] = cur;
                if(pre!=null){
                    pre.next = null;
                }
            }
            pre = cur;
            cur = cur.next;
            index++;

        } 

        index = 0;
        while (i<k){
            if((index%numDiv)==0){
                result[i++] = cur;
                if(pre!=null){
                    pre.next = null;
                }
            }
            pre = cur;
            cur = cur.next;
            index++;

        } 
        return result;
    }
}
// @lc code=end

