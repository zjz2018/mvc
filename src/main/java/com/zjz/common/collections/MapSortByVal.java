package com.zjz.common.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * map中根据值排序
 * 
 * @author ZJZ
 *
 */
public class MapSortByVal {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 10);
		map.put("A1", 13);
		map.put("A2", 150);
		map.put("A3", 120);
		map.put("A4", 11);
		System.out.println(map);
		// 定义treeset,包含排序
		SortedSet<Map.Entry<String, Integer>> set = new TreeSet<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
				});
		// 将Entry列表放入集合中
		set.addAll(map.entrySet());
		System.out.println(set);
		
	}
	
}
