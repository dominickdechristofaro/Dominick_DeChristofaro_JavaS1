package com.dechristofaro.dominickdechristofaromagiceightballservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DominickDechristofaroMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominickDechristofaroMagicEightBallServiceApplication.class, args);
	}

}
