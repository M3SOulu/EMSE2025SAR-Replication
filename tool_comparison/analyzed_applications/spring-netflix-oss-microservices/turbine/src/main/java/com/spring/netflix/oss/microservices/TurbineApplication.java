package com.spring.netflix.oss.microservices;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

@SpringBootApplication
@EnableTurbineAmqp
@EnableEurekaClient
public class TurbineApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TurbineApplication.class).run(args);
	}
}
