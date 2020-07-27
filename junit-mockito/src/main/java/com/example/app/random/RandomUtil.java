package com.example.app.random;

public class RandomUtil {
	public static void main(String[] args) {
		for(int i=0;i<2;i++) {
			test();
		}
		
	}
	public static void test() {
System.out.println(Math.random()); //it generates 0.1000000 to 0.999999
		
		System.out.println((int) (Math.random()*100)); //It generate 2 digit random no
		
		System.out.println((int) (Math.random()*10)); //It generate 1 digit random no
		
		System.out.println((int) (Math.random()*4)); //It generate 0 to 3  random no
		
	}

}
