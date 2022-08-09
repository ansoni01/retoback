package com.retoback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class RetobackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetobackApplication.class, args);
	}

}
