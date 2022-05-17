package ru.belov.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GifExchangeRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifExchangeRateApplication.class, args);
	}

}
