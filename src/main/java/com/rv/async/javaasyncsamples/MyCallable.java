package com.rv.async.javaasyncsamples;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String name;
	
	private SampleRouter sampleRouter;
	
	public MyCallable(String name, SampleRouter sampleRouter) {
		this.name = name;
		this.sampleRouter = sampleRouter;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("Inside MyCallable: " + Thread.currentThread().getName());
		
		
		String printMsg = sampleRouter.printMsg(this.name);
		
		return printMsg;
	}

}
