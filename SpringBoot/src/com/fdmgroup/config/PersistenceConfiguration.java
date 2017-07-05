package com.fdmgroup.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@Primary
	public DataSource flywayDataSource(){
		return DataSourceBuilder.create().build();
	}


}
