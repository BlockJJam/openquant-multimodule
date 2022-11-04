package com.tys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppWikiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWikiApplication.class, args);
    }
}
