package com.zjz.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存
 * 
 * @author ZJZ
 * 
 */
public class LockTest {
	private static Map<String, Object> cache = new HashMap<String, Object>();
	ReadWriteLock lock = new ReentrantReadWriteLock();// 读写锁

	public Object get(String key) {
		lock.readLock().lock();
		try {
			if (cache.get(key) == null) {// 空
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					if (cache.get(key) == null) {// 多线程下防止复写
						cache.put(key, new Object());
						System.out.println(Thread.currentThread().getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.writeLock().unlock();
				}
				lock.readLock().lock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return cache.get(key);
	}

	public static void main(String[] args) {
		final LockTest test = new LockTest();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + ":" + test.get("num"));
				}
			}).start();
		}
	}

}
