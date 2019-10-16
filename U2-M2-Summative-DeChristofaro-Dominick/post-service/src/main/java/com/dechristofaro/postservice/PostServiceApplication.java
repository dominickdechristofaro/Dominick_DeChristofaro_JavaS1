/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:	Post Service for the stwitter API.
 **************************************************************************************************/
package com.dechristofaro.postservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}

}
