package com.example.coursovayarabota2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
		(path = "/exam")
@SpringBootApplication
public class Coursovayarabota2Application {

	public static void main(String[] args) {
		SpringApplication.run(Coursovayarabota2Application.class, args);
	}

}
