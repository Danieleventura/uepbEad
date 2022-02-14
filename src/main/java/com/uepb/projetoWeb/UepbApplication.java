package com.uepb.projetoWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.uepb.projetoWeb.controllers")
@ComponentScan(basePackages = {"com.uepb.projetoWeb"})
public class UepbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UepbApplication.class, args);
	}
}
