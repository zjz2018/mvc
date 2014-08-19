package com.zjz.common.util;

import java.util.concurrent.atomic.AtomicInteger;

public class AtmoicTest {
	private static AtomicInteger num = new AtomicInteger(10);

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("-- current is " + num.decrementAndGet());
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("++ current is " + num.incrementAndGet());
				}
			}
		}).start();
	}

}
