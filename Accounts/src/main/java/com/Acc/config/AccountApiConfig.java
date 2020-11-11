package com.Acc.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.ConnectionString;
import com.mongodb.Mongo;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.Acc.Api","com.Acc.service","com.Acc.dao","com.Acc.entity","com.Acc.config" , "com.Acc.rest","com.Acc.Exceptions"})
public class AccountApiConfig  implements WebMvcConfigurer{


	    @Bean
	    public MongoClient mongo() {
	        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/Account");
	        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	          .applyConnectionString(connectionString)
	          .build();
	        
	        return MongoClients.create(mongoClientSettings);
	    }
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {

	        return new MongoTemplate(mongo(), "Account");
	    }

}
