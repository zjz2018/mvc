package com.zjz.common.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
	public static void main(String[] args) {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		final Lock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) // 这行不能改动
		{
			String input = i + ""; // 这行不能改动
			try {
				queue.put(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String output;
					try {
						// lock.lock();
						output = TestDo.doSome(queue.take());
						System.out.println(Thread.currentThread().getName() + ":" + output);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						// lock.unlock();
					}
				}
			}).start();
		}
	}
}

// 不能改动此TestDo类
class TestDo {
	public static String doSome(String input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}
