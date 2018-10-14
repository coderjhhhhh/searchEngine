package com.goodfancier.searchEngine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SearchEngineApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SearchEngineApplication.class, args);
    }
}