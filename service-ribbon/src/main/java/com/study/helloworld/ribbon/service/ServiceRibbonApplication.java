package com.study.helloworld.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.study.helloworld.ribbon.service.impl.HelloService;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceRibbonApplication {

	public static void main(String[] args){
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/")
	public String hello(){
		return helloService.getHelloContent();
	}
}
