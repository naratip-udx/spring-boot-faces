package me.narat.samples.bootfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
