package com.rv.async.javaasyncsamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SampleRouter {

	@Autowired
	private SampleHelper sampleHelper;
	
	public String printMsg(String name) throws InterruptedException {
		System.out.println("Inside SampleRouter: " + Thread.currentThread().getName());
		System.out.println(" === Inside sampleRouter class "+sampleHelper);
		
		Thread.sleep(2000);
		
		return "Result from SampleRouter for mr. "+name;
	}
	
	@Async
	public Future<String> printMsg2(String name) throws InterruptedException {
		System.out.println(" == 3 SampleRouter == " + Thread.currentThread().getName());
		sampleHelper.executeThread(name);
		Thread.sleep(3000);
		System.out.println(" == 5 SampleRouter == ");
		Future<String> result = CompletableFuture.completedFuture("Result from SampleRouter for mr. "+name);
		return result;
	}
}

