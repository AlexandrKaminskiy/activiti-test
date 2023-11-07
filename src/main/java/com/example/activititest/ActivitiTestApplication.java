package com.example.activititest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class ActivitiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiTestApplication.class, args);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user")
				.password("{noop}pass")
				.authorities("ROLE_ACTIVITI_USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
