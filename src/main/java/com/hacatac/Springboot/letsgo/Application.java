package com.hacatac.Springboot.letsgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	String test = "System.out.println(\"Does server restart?\")";

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
