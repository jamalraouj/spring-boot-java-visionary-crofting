package com.youcode.youbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class YouBooking {
	public static void main(String[] args) {
		SpringApplication.run(YouBooking.class, args);
	}
}