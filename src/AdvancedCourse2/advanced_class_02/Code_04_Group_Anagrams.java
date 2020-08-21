package AdvancedCourse2.advanced_class_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 变形词
 */
public class Code_04_Group_Anagrams {

	/**
	 * 排序在统计
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String key = String.valueOf(chs);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

	/**
	 * 统计字母频率
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			int[] record = new int[26];
			for (char cha : str.toCharArray()) {
				record[cha - 'a']++;
			}
			StringBuilder builder = new StringBuilder();
			for (int value : record) {
				builder.append(String.valueOf(value)).append("_");
			}
			String key = builder.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

}
