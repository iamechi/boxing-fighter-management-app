package com.boxing_app.boxing_fighter_management_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoxingFighterManagementAppApplication {

	public static void main(String[] args) {
		System.out.println("Docker check");
		SpringApplication.run(BoxingFighterManagementAppApplication.class, args);
	}

}
