package com.microideal.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication
@EnableEurekaClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackages = "com.microideal.orderserver.repository.jpa")
public class OrderServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}
}
