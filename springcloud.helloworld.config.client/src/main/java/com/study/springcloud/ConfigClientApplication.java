package com.study.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

	@Value("${hello}")
	private String hello;
	
	public static void main(String[] args){
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@RequestMapping(value="/hello")
	public String hello(){
		return hello;
	}
}
