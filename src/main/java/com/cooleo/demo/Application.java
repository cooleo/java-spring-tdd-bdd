package com.cooleo.demo;

import com.cooleo.data.MongoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hungnguyendang on 6/18/15.
 */



@Configuration
@ComponentScan(basePackages = "com.cooleo.data")
@EnableAutoConfiguration(exclude = {MongoConfiguration.class})
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class);
    }
}
