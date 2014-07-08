package com.zjz.basic;

/**
 * 继承类测试
 * 
 * 静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法
 * 父类中的成员变量被隐藏,方法被覆盖
 * 
 * @author ZJZ
 * 
 */
public class ExtendClass {
	
	class Parent {
		String str = "parent valiable";
		
		public Parent() {
			System.out.println(str);
		}
		
		public void method() {
			System.out.println(str + ":" + "parent method");
		}
		
		{
			System.out.println("parent block");
		}
	}
	
	class Child extends Parent {
		String str = "child valiable";
		
		public Child() {
			System.out.println(str);
		}
		
		public void method() {
			super.method();
			System.out.println(str + ":" + "child method");
		}
		
		{
			System.out.println("child block");
		}
	}
	
	public static void main(String[] args) {
		ExtendClass t = new ExtendClass();
		Parent p = t.new Child();
		p.method();
	}
	
}
