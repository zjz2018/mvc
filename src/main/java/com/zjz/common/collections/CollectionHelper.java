package com.zjz.common.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang.RandomStringUtils;

import com.google.common.collect.Lists;
import com.zjz.demo.model.UserModel;

public class CollectionHelper {
	public static void main(String[] args) {
		List<UserModel> users = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			users.add(new UserModel(i, RandomStringUtils.randomAlphanumeric(10), new Date()));
		}
		// 排序前
		for (UserModel m : users)
			System.out.println(m);
		System.out.println("================after==============");
		Comparator<UserModel> c1 = ComparatorUtils.reversedComparator(ComparableComparator.getInstance());// 逆序
		Comparator<UserModel> c2 = ComparatorUtils.nullHighComparator(ComparableComparator.getInstance());// 允许null
		List<BeanComparator> sortFields = Lists.newArrayList();
		sortFields.add(new BeanComparator("registerDate", c1));
		sortFields.add(new BeanComparator("username", c2));
		// Collections.sort(users, new BeanComparator("username",c1));//单个字段排序，若没排序器为升序
		Collections.sort(users, new ComparatorChain(sortFields));// 使用排序链
		for (UserModel m : users)
			System.out.println(m);
	}
	
}
