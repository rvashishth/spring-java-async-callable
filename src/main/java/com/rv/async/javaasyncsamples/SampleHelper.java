package com.rv.async.javaasyncsamples;

import org.springframework.stereotype.Component;

@Component
public class SampleHelper {

	public void executeThread(String msg) {
		System.out.println(" == 4 sampleHelper=== "+Thread.currentThread()+"======"+msg);
	}
}
