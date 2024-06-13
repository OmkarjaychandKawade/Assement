package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@ComponentScan("com.example.demo.controller")
public class DemoMvc1Application {

	public static void main(String[] args) {
		ApplicationContext  context=SpringApplication.run(DemoMvc1Application.class, args);
		
		
	}
}
