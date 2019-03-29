package com.study.springcloud.service.impl;

import org.springframework.stereotype.Component;

import com.study.springcloud.service.HelloWorldService;

@Component
public class HelloWorldServiceFailure implements HelloWorldService{

	@Override
	public String sayHello() {
		System.out.println("helloworld service is not available");
		return "helloworld service is not available";
	}

}
