package com.rv.async.javaasyncsamples;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	@GetMapping("/callable")
	@ResponseBody
	public String executeCallable() throws InterruptedException, ExecutionException {
		System.out.println("Inside SampleController: " + Thread.currentThread().getName());
		
		return sampleService.callRouterUsingCallable();
	}
	
	@GetMapping("/async")
	@ResponseBody
	public String executeAsync() throws InterruptedException, ExecutionException {
		System.out.println(" == 1 SampleController: " + Thread.currentThread().getName());
		
		String callAsyncRouter = sampleService.callAsyncRouter();
		System.out.println(" == 7 Controller --- after calling router===");
		return callAsyncRouter;
	}
}
