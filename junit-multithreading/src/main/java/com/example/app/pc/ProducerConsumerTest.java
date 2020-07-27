package com.example.app.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		/*
		 * Worker worker=new Worker(); new Thread(()->worker.consumes()).start(); new
		 * Thread(()->worker.produce()).start();
		 */
		WorkerUsingLock worker=new WorkerUsingLock();
		new Thread(()->worker.consumes()).start();
		new Thread(()->worker.produce()).start();
		
	}

	static class Worker {
		//Lock lock=new ReentrantLock();
		//private Condition addedConditionMet=lock.newCondition();
		//private Condition removedConditionMet=lock.newCondition();
		private List<String> list=new ArrayList<String>();
			

		public void produce() {
			System.out.println("Producing ....");
			for (int i = 0; i < 10; i++) {
				list.add(String.valueOf(Math.random()));
				
			}
			synchronized (this) {
				this.notify();
			}
			
			

		}

		public void consumes() {
			while (list.isEmpty()) {
				synchronized (this) {
					try {
						System.out.println("No Data going to wating state");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			System.out.println(list);
			

		}
	}
	static class WorkerUsingLock {
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
			}finally {
				lock.unlock();
			}
			System.out.println(list);
			

		}
	}

}
