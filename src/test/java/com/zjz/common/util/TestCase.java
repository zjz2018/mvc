package com.zjz.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestCase {
	@Test
	@Ignore
	public void testThread() {
		final TestCase.Business b = new TestCase.Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i <= 5; i++) {
						b.sub();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "sub").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						b.main();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "main").start();
	}

	static class Business {
		private Boolean flag = true;

		public synchronized void sub() throws InterruptedException {
			if (!flag) {
				for (int i = 0; i < 1; i++) {
					System.out.println(Thread.currentThread().getName());
				}
				flag = true;
				this.notify();
				this.wait();
			} else {
				this.wait();
			}

		}

		public synchronized void main() throws InterruptedException {
			if (flag) {
				for (int i = 0; i < 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}
				flag = false;
				this.notify();
				this.wait();
			} else {
				this.wait();
			}
		}
	}

	static class Ming {
		private Boolean flag = true;

		public synchronized void a() throws InterruptedException {
			if (!flag) {
				System.out.println("知道了!");
				flag = true;
				this.notify();
				this.wait();
			} else {
				this.wait();
			}

		}

		public synchronized void b() throws InterruptedException {
			if (flag) {
				for (int i = 0; i < 3; i++) {
					System.out.println("起床了!");
				}
				flag = false;
				this.notify();
				this.wait();
			} else {
				this.wait();
			}
		}

	}

	@Test
	@Ignore
	public void testMing() {
		final TestCase.Ming ming = new TestCase.Ming();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						ming.a();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						ming.b();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	static class Product {
		private boolean isEmpty = true;
		private String current;

		public synchronized void take() {
			while (!isEmpty) {
				System.out.println("消费了:" + current);
				isEmpty = true;
				this.notify();
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public synchronized void put(String food) {
			if (isEmpty) {
				System.out.println("生产了:" + food);
				current = food;
				isEmpty = false;
				this.notify();
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	@Ignore
	public void testFood() {
		final TestCase.Product product = new TestCase.Product();
		new Thread(new Runnable() {
			@Override
			public void run() {
				String[] a = new String[] { "aa", "bb", "cc", "dd", "ee" };
				for (String element : a) {
					product.put(element);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				product.take();
			}
		}).start();
	}

	@Test
	@Ignore
	public void testDeman() {
		com.zjz.common.util.Product pd = new com.zjz.common.util.Product();
		Producer p = new Producer("制造者", pd);
		Customer ct = new Customer("消费者", pd);
		Thread t1 = new Thread(p, p.getName());
		Thread t2 = new Thread(ct, ct.getName());
		// t2.setDaemon(true);
		t1.start();
		t2.start();
	}

	@Test
	@Ignore
	public void testStream() {
		String str = "说到底";
		FileOutputStream fos;
		/*	try {
				fos=new FileOutputStream("D:\\1.txt");
				fos.write(str.getBytes("UTF-8"));
			} catch (FileNotFoundException e) {
				File file=FileUtils.getFile("D:\\1.txt");
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		BufferedReader reader = null;
		try {
			InputStream is = new FileInputStream("D:\\1.txt");
			reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			String res = "";
			while ((line = reader.readLine()) != null) {
				res += line + ";";
			}
			// byte[] b = new byte[1024];
			// int len = is.read(b);
			// String str1 = new String(b, 0, len, Charsets.UTF_8);
			System.out.println(res);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	@Ignore
	public void testChar() throws UnsupportedEncodingException {
		String str = "我ABC我汉DEF";
		int l = 6;
		int sl = 0;
		byte[] b = str.getBytes("GBK");
		boolean isChinese = false;
		for (int i = 0; i < l; i++) {
			if ((b[i] < 0) && !isChinese) {
				isChinese = true;
			} else {
				sl++;
				isChinese = false;
			}
		}
		System.out.println(str.substring(0, sl));
	}

	@Test
	@Ignore
	public void testRegular() {
		String str = "a_B-c9T";
		System.out.println(str.replaceAll("[\\d]", "#"));
	}

	public void testStringNum() {
		String str = "a1啊";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > '0') {

			}
		}
	}

	@Test
	@Ignore
	public void testSumLoop() {
		int sum = 0;
		int ori = 2;// 2+22+222
		int tmp = 0;
		for (int i = 0; i < 3; i++) {
			tmp = (tmp * 10) + ori;
			sum += tmp;
		}
		Assert.assertEquals(246, sum);
		System.out.println(sum);
	}

	@Test
	@Ignore
	public void testM() {
		TestCase.testDg(4);
	}

	public static void testDg(int n) {
		if (n == 1) {
			System.out.println("*");
			return;
		}
		testDg(n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}

	public static void sort(String[] strData, int begin, int end) {
		String tmpData;
		int i = begin;
		int j = end;
		int middle = (i + j) / 2;
		do {
			if ((strData[i].compareTo(strData[middle]) < 0) && (i < end)) {
				i++;
			}
			if ((strData[j].compareTo(strData[middle]) > 0) && (j > begin)) {
				j--;
			}
			if (i <= j) {
				tmpData = strData[i];
				strData[i] = strData[j];
				strData[j] = tmpData;
			}
			i++;
			j--;
		} while (i <= j);
		if (i < end) {
			sort(strData, i, end);
		}
		if (j > begin) {
			sort(strData, begin, j);
		}
	}

	@Test
	public void testSort() {
		String[] strData = { "25", "26", "23", "22", "21", "24" };
		sort(strData, 0, strData.length - 1);
		for (String str : strData) {
			System.out.println(str);
		}
	}

}
