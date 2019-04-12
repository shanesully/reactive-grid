package com.tweethub.reactivegrid;

import com.tweethub.reactivegrid.services.impl.config.Twitter4jConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Twitter4jConfig.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
