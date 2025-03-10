package com.fibonacci.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fibonacci.fibonacci.fibonacci.ResultCalculator;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.out.println(ResultCalculator.Calculate(10));
	}

}
