package com.spring.data.basic.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.spring.data.basic.controller")
@EnableJpaRepositories(basePackages = "com.spring.data.basic.repository")
@EntityScan(basePackages = "com.spring.data.basic.model")
@SpringBootApplication
public class SpringDatatBasicConfig {

	public static void main(String[] args) {

		SpringApplication.run(SpringDatatBasicConfig.class, args);

	}
}
