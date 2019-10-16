/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:	Cloud Configuration Server found at:
 * 					https://github.com/dominickdechristofaro/dominick-dechristofaro-cloud-config-repo
 * 					Configuration files hosted on port:
 * 					http://localhost:1999
 **************************************************************************************************/
package com.dechristofaro.cloudconfigservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServiceApplication.class, args);
	}

}
