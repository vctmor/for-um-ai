package com.amoreira.for_um_ai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForUmAiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ForUmAiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Achoooooooooooo");
	}

}

