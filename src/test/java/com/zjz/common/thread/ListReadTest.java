package com.zjz.common.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;

/**
 * 多线程读取列表
 * 
 * @author ZJZ
 *
 */
public class ListReadTest {
	
	public static void main(String[] args) throws InterruptedException {
		final List<String> lists = Lists.newArrayList("A", "B", "C", "D", "E", "F", "G", "H", "I");// 原始列表
		final BlockingQueue<String> queue = new ArrayBlockingQueue(lists.size());// 阻塞队列
		CountDownLatch latch = new CountDownLatch(lists.size());// 倒数闸门
		for (String str : lists) {
			queue.put(str);// 填充队列
		}
		Long start=System.currentTimeMillis();
		int nums = Runtime.getRuntime().availableProcessors();// 当前CPU线程数
		ExecutorService executor = Executors.newFixedThreadPool(nums);
		ListReadTest main = new ListReadTest();
		for (int i = 0; i < lists.size(); i++) {
			executor.execute(main.new Worker(queue, latch));
		}
		latch.await();// 阻塞
		executor.shutdown();
		System.out.println(System.currentTimeMillis()-start);
	}
	
	class Worker implements Runnable {
		private BlockingQueue queue;
		private CountDownLatch latch;
		
		public Worker(BlockingQueue queue, CountDownLatch latch) {
			this.queue = queue;
			this.latch = latch;
		}
		
		@Override
		public void run() {
			try {
				if (!queue.isEmpty()) {// 循环队列
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + ":" + queue.take().toString());// 读取数据
					latch.countDown();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
