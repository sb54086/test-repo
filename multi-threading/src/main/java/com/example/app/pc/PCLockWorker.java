package com.example.app.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCLockWorker {
	Lock lock=new ReentrantLock();
	private Condition addedConditionMet=lock.newCondition();
	private Condition removedConditionMet=lock.newCondition();
	private List<String> list=new ArrayList<String>();
		

	public void produce() {
		
		lock.lock();
		System.out.println("Producing ....");
		for (int i = 0; i < 10; i++) {
			list.add(String.valueOf(Math.random()));
		}
		addedConditionMet.signal();
		removedConditionMet.signal();
		lock.unlock();
		
		

	}

	public void consumes() {
		lock.lock();
		try {
		while (list.isEmpty()) {
			try {
				System.out.println("No Data Consumer Going to Wating");
				addedConditionMet.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(list);
		
			
		}finally {
			lock.unlock();
		}
		
		

	}
	public static void main(String[] args) {
		PCLockWorker wo=new PCLockWorker();
		
		new Thread(()->wo.consumes()).start();
		new Thread(()->wo.produce()).start();
	}

}
