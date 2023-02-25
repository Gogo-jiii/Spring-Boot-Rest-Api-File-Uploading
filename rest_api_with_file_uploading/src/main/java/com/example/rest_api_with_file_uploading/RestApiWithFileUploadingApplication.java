package com.example.rest_api_with_file_uploading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.rest_api_with_file_uploading")
public class RestApiWithFileUploadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWithFileUploadingApplication.class, args);
		System.out.println("Server started...");
	}

}
