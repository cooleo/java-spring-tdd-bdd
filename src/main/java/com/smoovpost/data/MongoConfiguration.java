package com.smoovpost.data;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by hungnguyendang on 6/18/15.
 */
@Configuration
@PropertySource(value = {"classpath:mongodb.properties"})

@EnableMongoRepositories(basePackages = {"com.smoovpost.data"})
public class MongoConfiguration /*extends AbstractMongoConfiguration*/ {
    @Autowired
    private Environment env;



    protected String getDatabaseName() {
        return env.getProperty("mongodb.database");
    }

    @Value("${mongodb.database}")
    private String  dbName;

    @Value("${mongodb.host}")
    private String  host;

    @Value("${mongodb.port}")
    private Integer port;



    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydatabase");
    }
}

