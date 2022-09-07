package com.prueba.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrincipalApplication extends SpringBootServletInitializer {

	@Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrincipalApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PrincipalApplication.class, args);
		System.out.println("esto es un mensaje de prueba de commit");
	}

}
