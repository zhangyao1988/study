package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.springcloud.service.HelloWorldService;

@RestController
public class WebController {

	@Autowired
	private HelloWorldService helloWorldService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(){
		return helloWorldService.sayHello();
	}
}
