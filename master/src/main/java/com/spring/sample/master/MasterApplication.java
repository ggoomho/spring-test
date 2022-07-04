package com.spring.sample.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterApplication.class, args);
	}

}
