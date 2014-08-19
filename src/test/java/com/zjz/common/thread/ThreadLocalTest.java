package com.zjz.common.thread;

import java.util.Random;

public class ThreadLocalTest {
	class Man {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private static final ThreadLocal<Man> manlocal = new ThreadLocal<ThreadLocalTest.Man>();

	public static void main(String[] args) {
		// final Man man = new ThreadLocalTest().new Man();
		final ThreadLocalTest tt = new ThreadLocalTest();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Integer it = new Random().nextInt(50);
					Man man = tt.getMan();
					man.setName(it + ":name:" + Thread.currentThread().getName());
					System.out.println(man.getName());
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(man.getName());
				}
			}).start();
		}
		// System.out.println(man.getName());
	}

	private Man getMan() {
		Man man = manlocal.get();
		if (man == null) {
			man = new Man();
			manlocal.set(man);
		}
		return man;
	}

}
