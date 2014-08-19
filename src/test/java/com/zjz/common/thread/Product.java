package com.zjz.common.thread;

public class Product {
	private Boolean isEmpty = true;
	private String food;

	public synchronized void put(String str) {
		while (!isEmpty) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		food = str;
		System.out.println("制造了:" + food);
		isEmpty = false;
		this.notify();

	}

	public synchronized void take() {
		while (!isEmpty) {
			System.out.println("消费了:" + food);
			isEmpty = true;
			this.notify();
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public String getFood() {
		return food;
	}

	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void setFood(String food) {
		this.food = food;
	}

}
