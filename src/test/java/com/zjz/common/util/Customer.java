package com.zjz.common.util;

public class Customer implements Runnable {
	private String name;
	private Product product;

	@Override
	public void run() {
		product.take();
	}

	public void run1() {
		synchronized (product) {
			while (true) {
				try {
					if (!product.getIsEmpty()) {
						System.out.println(getName() + "消费" + product.getFood());
						product.setIsEmpty(true);
						Thread.sleep(2000);
						product.notify();
						product.wait();
					} else {
						product.wait();
					}
				} catch (Exception e) {
				}
			}
		}
	}

	public Customer(String name, Product product) {
		super();
		this.name = name;
		this.product = product;
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
