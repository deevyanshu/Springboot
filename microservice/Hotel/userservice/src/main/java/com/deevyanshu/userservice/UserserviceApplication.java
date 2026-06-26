package com.deevyanshu.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserserviceApplication {

	//this bean can be declared here but best practice is to declare it in configuration class
	/*@Bean
	public RestTemplate RestTemplate()
	{
		return new RestTemplate();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	

}
