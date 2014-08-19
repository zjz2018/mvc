package com.zjz.common.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.zjz.demo.model.UserModel;

/**
 * 利用apache commons包对集合排序
 * list根据字段排列
 * map根据val排列
 * 
 * @author ZJZ
 *
 */
public class CollectionSort {
	private List<UserModel> users = Lists.newArrayList();
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	@Before
	// 初始化list
	public void initList() {
		for (int i = 0; i < 10; i++) {
			// 添加10位随机数字字母
			users.add(new UserModel(i, RandomStringUtils.randomAlphanumeric(10), new Date()));
		}
		// 排序前
		for (UserModel m : users)
			System.out.println(m);
		System.out.println("================init==============");
	}
	
	@Before
	// 初始化map
	public void initMap() {
		map.put("A", 10);
		map.put("A1", 13);
		map.put("A2", 150);
		map.put("A3", 120);
		map.put("A4", 11);
		System.out.println(map);
	}
	
	@Test
	// list排序
	public void listSortTest() {
		Comparator<UserModel> c1 = ComparatorUtils.reversedComparator(ComparableComparator.getInstance());// 逆序
		Comparator<UserModel> c2 = ComparatorUtils.nullHighComparator(ComparableComparator.getInstance());// 允许null
		List<BeanComparator> sortFields = Lists.newArrayList();// 多个排序
		sortFields.add(new BeanComparator("registerDate", c1));
		sortFields.add(new BeanComparator("username", c2));
		// Collections.sort(users, new BeanComparator("username",c1));//单个字段排序，若没排序器为升序
		Collections.sort(users, new ComparatorChain(sortFields));// 使用排序链
		for (UserModel m : users)
			System.out.println(m);
	}
	
	@Test
	// map排序
	public void mapSortTest() {
		// 定义treeset,根据val升序排列
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
