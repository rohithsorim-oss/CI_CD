package com.rohith.cicdDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@SpringBootApplication
public class CicdDemoApplication {

	private static String h = "";

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(CicdDemoApplication.class, args);
	}

	@Bean
    ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
