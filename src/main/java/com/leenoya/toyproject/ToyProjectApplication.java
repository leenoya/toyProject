package com.leenoya.toyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.leenoya.toyProject.client"})
public class ToyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyProjectApplication.class, args);
	}

}
