package com.zjz.common.basic;

import java.util.Map;

import com.google.common.collect.Maps;

public class HeapOOM {
	
	public static void main(String[] args) {
		Map<String,String> map=Maps.newHashMap();
		for(int i=0;i<1000000;i++){
			map.put(i+"", i+"==val");
		}
		System.out.println(11);
	}
	
}
