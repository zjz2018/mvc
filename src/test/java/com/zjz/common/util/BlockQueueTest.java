package com.zjz.common.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 阻塞队列
 * 
 * @author ZJZ
 * 
 */
public class BlockQueueTest {
	
	public static void main(String[] args) throws InterruptedException {
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		final Semaphore semaphore = new Semaphore(2);
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
		
		for (int i = 0; i < 16; i++) {// 取
			new Thread(new Runnable() {
				public void run() {
					try { 
						semaphore.acquire();
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " take num:" + queue.take());
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
	
}
