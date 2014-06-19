package com.zjz.common.util;

public class MyThread implements Runnable {
	private byte[] lock = new byte[0];

	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 20; i++) {
				if (((i % 10) == 0) && (i != 0)) {
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + ":" + i);
				if (i == 19) {
					lock.notify();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " is over");
	}

}
