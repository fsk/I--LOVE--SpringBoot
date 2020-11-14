package com.frknshnklksz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DataJpaApp {
    public static void main(String[] args) {
        SpringApplication.run(DataJpaApp.class, args);
    }
}
