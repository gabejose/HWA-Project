package com.qa.demo;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HwaSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HwaSpringBootApplication.class, args);
		
		Object byName = context.getBean("greeting");
		LocalTime byTime = context.getBean("getTime", LocalTime.class);
		
		System.out.println(byName);
		System.out.println(byTime);
	}

}
