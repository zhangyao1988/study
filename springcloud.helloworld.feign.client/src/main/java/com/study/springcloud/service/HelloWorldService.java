package com.study.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springcloud.service.impl.HelloWorldServiceFailure;

/**
 * 熔断机制
 * @author youyou
 *
 */
@FeignClient(name="SERVICE-HELLOWORLD", fallback=HelloWorldServiceFailure.class)
public interface HelloWorldService {

	@RequestMapping(value="/", method=RequestMethod.GET)
	String sayHello();
}
