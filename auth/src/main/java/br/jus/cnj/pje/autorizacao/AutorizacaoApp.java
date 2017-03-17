package br.jus.cnj.pje.autorizacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AutorizacaoApp {

	public static void main(String[] args) {
		SpringApplication.run(AutorizacaoApp.class, args);
	}
	
}
