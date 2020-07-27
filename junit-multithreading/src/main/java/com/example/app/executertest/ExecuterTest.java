package com.example.app.executertest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
     Runnable task=()->{
    	 System.out.println("Hello doing task");
     };
     Callable<Integer> cTask=()->{
    	 System.out.println("DOing Callable TAsk");
    	 return new Random().nextInt();
     };
     //creating a pool
     int cores=Runtime.getRuntime().availableProcessors();
     System.out.println(cores);
     ExecutorService eService=Executors.newFixedThreadPool(cores);
     //For CPU Intensive Task the PoolSIze would be like this
     eService.execute(task);
     
       List<Future> futures=new ArrayList<Future>();
       for( int i=0;i<10;i++) {
    	Future<Integer> integerValue= eService.submit(cTask);
    	futures.add(integerValue);
       }
       Future<String> cFuture=eService.submit(()->{
    	   return "Hello";
       });
       CompletableFuture
       .supplyAsync(()->{ return "Hello";})
       .thenApplyAsync((data)->{ return data+data;})
       .thenAcceptAsync(System.out::println);
    	
    	//Perform SOme Other  Operations
    	for(Future f:futures) {
    	System.out.println(f.cancel(false)); //block the code until the future return value
    	}
    	
    			
     
     //In Main --
     System.out.println(": Thread Name- :"+Thread.currentThread().getName());
   
     
	}

}
