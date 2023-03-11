package com.asaf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootConsoleApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }








}
