package com.zjz.common.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞队列
 * 
 * @author ZJZ
 * 
 */
public class BlockQueueTest {

	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new SynchronousQueue();
		// final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(4);
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 16; i++) {// 放
					try {
						queue.put(i);
						System.out.println("put num:" + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		for (int i = 0; i < 4; i++) {// 取
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							Thread.sleep(1000);
							System.out.println(Thread.currentThread().getName() + " take num:" + queue.take());
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}

}
