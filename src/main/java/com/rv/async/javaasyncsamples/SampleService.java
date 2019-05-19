package com.rv.async.javaasyncsamples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	@Autowired
	private SampleRouter sampleRouter;
	
	public String callRouterUsingCallable() throws InterruptedException, ExecutionException {
		System.out.println("Inside SampleService: " + Thread.currentThread().getName());
		
		MyCallable mc = new MyCallable("Rahul",this.sampleRouter);
		
		System.out.println(" === Before calling myCallable");
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> submit = es.submit(mc);
		
		System.out.println(" === After Calling myCallable");
		
		String string = submit.get();
		System.out.println(" === Result of myCallable: "+string);
		
		// Can request shutdown once result is received successfully.
		es.shutdown();
		return string;
	}
	
	public String callAsyncRouter() throws InterruptedException, ExecutionException {
		System.out.println(" == 2 SampleService: " + Thread.currentThread().getName());
		
		Future<String> printMsg2 = sampleRouter.printMsg2("Rahul");
		System.out.println(" == 6 SampleService == After calling async method");
		
		return printMsg2.get();
	}
}
