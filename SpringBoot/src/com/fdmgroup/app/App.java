package com.fdmgroup.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.fdmgroup.controller"})
@EnableJpaRepositories(basePackages={"com.fdmgroup.repository"})
@EntityScan(basePackages={"com.fdmgroup.model"})
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
}
