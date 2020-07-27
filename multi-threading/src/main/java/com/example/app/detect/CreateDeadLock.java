package com.example.app.detect;

public class CreateDeadLock {
	public static void main(String[] args) {
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
