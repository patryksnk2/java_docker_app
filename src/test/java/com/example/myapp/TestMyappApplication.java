package com.example.myapp;

import org.springframework.boot.SpringApplication;

public class TestMyappApplication {

	public static void main(String[] args) {
		SpringApplication.from(MyappApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
