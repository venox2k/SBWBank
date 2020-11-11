package com.banque.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.MongoClient;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.banque.auth"}) // Scans the following packages for classes with @Controller annotations
public class WebConfig extends WebMvcConfigurerAdapter {
    /*@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    */
    @Bean
    public MongoDbFactory mongoDbFactory() {
    	return new SimpleMongoDbFactory(new MongoClient("localhost", 27017),"mydbBanque");
    }
    
    @Bean
    public MongoTemplate mongoTemplate() {
    	return new MongoTemplate(mongoDbFactory());
    }
}
