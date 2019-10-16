/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:	Eureka Discovery Client Server
 * 					Hosted at http://localhost:8761
 **************************************************************************************************/
package com.dechristofaro.eurekaregistryservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistryServiceApplication.class, args);
	}

}
