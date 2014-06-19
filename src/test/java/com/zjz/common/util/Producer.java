package com.zjz.common.util;

public class Producer implements Runnable {
	private String name;
	private Product product;

	public Producer(String name, Product product) {
		super();
		this.name = name;
		this.product = product;
	}

	public void run() {
		synchronized (product) {
			for (int i = 0; i < 10; i++) {
				product.put(i + "layer");
				// try {
				// if (product.getIsEmpty()) {
				// product.setFood(i + "layer");
				// System.out.println(this.getName() + "生产了" + product.getFood());
				// product.setIsEmpty(false);
				// product.notify();
				// product.wait();
				// }
				// }else{
				// product.wait();
				// }
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		}
	}

	public void run2() {
		for (int i = 0; i < 10; i++) {
			synchronized (product) {
				try {
					if (product.getIsEmpty()) {
						product.setFood(i + "layer");
						System.out.println(this.getName() + "生产了" + product.getFood());
						product.setIsEmpty(false);
						product.notify();
						product.wait();
					} else {
						product.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public Product getProduct() {
		return product;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
