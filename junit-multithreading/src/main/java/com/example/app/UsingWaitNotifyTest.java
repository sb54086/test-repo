package com.example.app;

public class UsingWaitNotifyTest {

	public static void main(String[] args) {
		Worker2 worker=new Worker2();
		
		new Thread(()->worker.doJob1()).start();
		new Thread(()->worker.doJob2()).start();

	}

	static class Worker2 {
		public  void doJob1()  {
			System.out.println("Dong Job1's Operaton ");
			try {
				synchronized (this) {
					this.wait();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Dong Job1's dependent for Job2 Operaton ");
         
		}

		public  void doJob2() {
			System.out.println("Dong Job2's Operaton ");
			synchronized (this) {
				this.notifyAll();
			}
			

		}
	}

}
