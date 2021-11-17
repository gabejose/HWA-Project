package com.qa.demo.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public String greeting() {
		return "Spring is working!";
	}
	
	@Bean
	public LocalTime getTime() {
		return LocalTime.now();
	}
}
