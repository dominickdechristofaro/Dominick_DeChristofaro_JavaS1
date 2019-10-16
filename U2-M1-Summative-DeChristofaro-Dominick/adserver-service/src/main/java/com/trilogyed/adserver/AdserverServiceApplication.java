package com.trilogyed.adserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdserverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdserverServiceApplication.class, args);
	}

}
