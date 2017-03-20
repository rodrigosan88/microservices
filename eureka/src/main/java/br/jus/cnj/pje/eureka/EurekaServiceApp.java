package br.jus.cnj.pje.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApp.class, args);
	}
	
}
