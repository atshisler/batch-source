package com.revature;

public class HelloWorld {

	// - single line
	/*
	 *  - multiple line
	 */
	/**
	 *  - java docs
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hello world");
		new HelloWorld().print(10,20);
		new HelloWorld().print(10,20,30);
		new HelloWorld().print(10,20,30,40);
		new HelloWorld().print(10,20,30,40,50);
		new HelloWorld().print(10,20,30,40,50,60,70,80);
	}
	
	//can I overload static method - Yes
	//can I overload main method - Yes
	//can I override static method - No
	//can I override main method - No
	
	
	//varargs
	void print(int x, int ...y){
		
		for(int a : y) {
			System.out.println("value of x: " + x
					+ ", value of y: " + a);
		}
		//System.out.println("print the number " + x + y);
	}
	
}
