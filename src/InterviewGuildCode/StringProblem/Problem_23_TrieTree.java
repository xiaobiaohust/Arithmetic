package InterviewGuildCode.StringProblem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 字典树，前缀树
 */
public class Problem_23_TrieTree {
    public static class TrieNode {
        public int path;
        public int end;
        public String value;
        public HashMap<String, TrieNode> nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            value = "";
            nexts = new HashMap<>();
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //前缀树插入元素
        public void insert(String word) {
            if (word == null) {
                return;
            }

            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                String keyword = word.substring(i,i+1);
                if(!cur.nexts.containsKey(keyword)){
                    cur.nexts.put(keyword,new TrieNode());
                }
                cur = cur.nexts.get(keyword);
                cur.path++;
                cur.value = keyword;
            }
            cur.end++;
        }

        //前缀树删除元素
        public void delete(String word){
            if (word == null) {
                return ;
            }
            if(search(word)){
                TrieNode cur = root;
                for(int i=0;i<word.length();++i){
                    String keyword= word.substring(i,i+1);
                    if(cur.nexts.containsKey(keyword)){
                        cur = cur.nexts.get(keyword);
                        cur.path--;
                    }
                }
                cur.end--;
            }
        }

        public boolean search(String word){
            if(word==null){
                return false;
            }
            TrieNode cur = root;
            for(int i=0;i<word.length();++i){
                String keyword = word.substring(i,i+1);
                if(!cur.nexts.containsKey(keyword)){
                    return false;
                }
                cur = cur.nexts.get(keyword);
            }
            return cur.end!=0;
        }

        //找到以pre作为前缀的字符串数量
        public int prefixNumber(String pre){
            if(pre==null){
                return 0;
            }

            TrieNode cur = root;
            for(int i=0;i<pre.length();++i){
                String keyword = pre.substring(i,i+1);
                if(!cur.nexts.containsKey(keyword)){
                    return 0;
                }
                cur = cur.nexts.get(keyword);
            }
            return cur.path;
        }

        // 从cur开始的所有字符串
        public ArrayList<String> getNextWords(TrieNode cur){
            if(cur.nexts.equals(new HashMap<>())){
                return new ArrayList<>();
            }
            ArrayList<String>words = new ArrayList<>();
            for(String key:cur.nexts.keySet()){
                ArrayList<String>words_ = getNextWords(cur.nexts.get(key));
                if(cur.nexts.get(key).end>0){
                    words_.add("");
                }
                for(String str:words_){
                    words.add(key+str);
                }
            }
            return words;
        }

        //找到以pre作为前缀的所有字符串
        public ArrayList<String> prefixString(String pre){
            if (pre == null) {
                return new ArrayList<>();
            }
            TrieNode cur = root;
            for(int i=0;i<pre.length();++i){
                String keyword = pre.substring(i,i+1);
                if(!cur.nexts.containsKey(keyword)){
                    return new ArrayList<>();
                }
                cur=cur.nexts.get(keyword);
            }
            ArrayList<String> words = getNextWords(cur);
            for(int i=0;i<words.size();++i){
                words.set(i,pre+words.get(i));
            }
            if(cur.end>0){
                words.add(pre);
            }
            return words;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("我是小白");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.insert("zuoa");
        System.out.println(trie.search("zuoac"));
        System.out.println(trie.prefixNumber("zuo"));
        System.out.println(trie.prefixString("zuo"));

    }


}
