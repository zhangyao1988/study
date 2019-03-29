package com.study.helloworld.ribbon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="serviceFailure")
	public String getHelloContent(){
		return restTemplate.getForObject("http://service-helloworld/", String.class);
	}
	
	public String serviceFailure(){
		return "helloworld service is not available!";
	}
}
