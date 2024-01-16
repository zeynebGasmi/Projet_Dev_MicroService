package com.example.playerserrvice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PlayerSerrviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerSerrviceApplication.class, args);
	}

}
