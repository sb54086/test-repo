package com.example.app;

public class ReEntrantTest {

	public static void main(String[] args) {
     Worker worker=new Worker();
     
     new Thread(()->worker.job1()).start();
     new Thread(()->worker.job2()).start();
	}

}
