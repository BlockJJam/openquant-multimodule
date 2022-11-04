package com.tys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class AppMarketdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppMarketdataApplication.class, args);
    }
}
