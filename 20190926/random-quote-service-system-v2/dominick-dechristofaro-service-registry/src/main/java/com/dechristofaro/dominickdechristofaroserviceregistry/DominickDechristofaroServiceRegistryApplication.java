package com.dechristofaro.dominickdechristofaroserviceregistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DominickDechristofaroServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominickDechristofaroServiceRegistryApplication.class, args);
	}

}
