package com.longjw.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootApplicationDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
