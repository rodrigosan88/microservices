package br.jus.cnj.pje.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CepApp extends ResourceServerConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(CepApp.class, args);
	}
}
