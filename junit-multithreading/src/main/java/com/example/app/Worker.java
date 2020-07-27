package com.example.app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {
	private Lock lock=new ReentrantLock();
	private Condition conditionMet=lock.newCondition();
	
	
	public void job1() {
		lock.lock();
		
		try {
			System.out.println("Doing JOB1's Operation  iin :"+Thread.currentThread().getName());
			conditionMet.await(); //suspend here
			//can now do job2 dependent operations here
			System.out.println("Doing JOB1 dependent Operation in :"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void job2() {
		lock.lock();
		
		try {
			System.out.println("Doing JOB2  Operation in :"+Thread.currentThread().getName());
			conditionMet.signal();
		}
		finally {
			lock.unlock();
		}
	}

}
