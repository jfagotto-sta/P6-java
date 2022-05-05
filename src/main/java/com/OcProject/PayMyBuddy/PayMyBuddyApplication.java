package com.OcProject.PayMyBuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages={"com.OcProject.PayMyBuddy.repository","com.OcProject.PayMyBuddy.resources", "com.OcProject.PayMyBuddy.services", "com.OcProject.PayMyBuddy.controller","com.OcProject.PayMyBuddy.model"}
)
public class PayMyBuddyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}
}
