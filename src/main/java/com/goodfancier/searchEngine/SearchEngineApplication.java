package com.goodfancier.searchEngine;

import com.goodfancier.searchEngine.config.JpaConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SearchEngineApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(new Class<?>[]{SearchEngineApplication.class, JpaConfig.class}, args);
    }
}