package com.zjz.common.thread;


public class Test {
	private String str = "aaa";

	class InnerClass {
		private void sysout() {
			str = new String("bb");
			System.out.println(str);
		}
	}

	public void testInner() {
		final String str1 = "22";
		class InnerClass2 {
			private void sysout() {
				System.out.println(str1);
			}
		}
	}

	public int tryTest() {
		int i = 1;
		try {
			return fun1(i);
		} finally {
			fun2(i);
		}
	}

	public int fun1(int i) {
		System.out.println("fun1");
		return i;
	}

	public int fun2(int i) {
		System.out.println("fun2");
		return i++;
	}

	public static void main3(String[] args) {
		Test t = new Test();
		System.out.println(t.tryTest());
	}

	public static void main(String[] args) {
		Product pd = new Product();
		Producer p = new Producer("制造者", pd);
		Customer ct = new Customer("消费者", pd);
		Thread t1 = new Thread(p, p.getName());
		Thread t2 = new Thread(ct, ct.getName());
		// t2.setDaemon(true);
		t1.start();
		t2.start();
	}

	public static void main2(String[] args) {
		MyThread my = new MyThread();
		Thread t1 = new Thread(my, "t1");
		Thread t2 = new Thread(my, "t2");
		t1.start();
		t2.start();

	}

	class Value {
		public int i = 15;
	}

	public static void main4(String[] args) {
		Test t = new Test();
		t.first();
	}

	public void first() {
		int i = 5;
		Value v = new Value();
		v.i = 25;
		sec(v, i);
		System.out.println(v.i);
	}

	public void sec(Value v, int i) {
		i = 0;
		v.i = 20;
		Value va = new Value();
		v = va;
		System.out.println(v.i + " " + i);
	}

	public void move(String[] result, String[] a, String[] b, int index) {
		if (index >= a.length) {
			return;
		}
		for (int i = 0; i < b.length; i++) {
			result[(index * b.length) + i] = a[index] + b[i];
		}
		move(result, a, b, index + 1);
	}

	public static void main5(String[] args) {
		Test t = new Test();
		String[] res = new String[9];
		t.move(res, new String[] { "a", "b", "c" }, new String[] { "a", "b", "c" }, 0);
		for (String r : res) {
			System.out.println(r);
		}
	}

}
