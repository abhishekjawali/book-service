package com.abhi.spring.tdd.config;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class DataSourceConfiguration {

	@Bean
	public Cloud cloud() {
		return new CloudFactory().getCloud();
	}

	@Bean
	// @ConfigurationProperties(DataSourceProperties.PREFIX)
	public DataSource dataSource() {
		return cloud().getSingletonServiceConnector(DataSource.class, null);
	}
}
