package com.example.springboot2h.database;

import com.example.springboot2h.models.Product;
import com.example.springboot2h.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product( "Macbook", 2022, 22,"");
                Product productB = new Product( "Asus", 2022, 22,"");
                logger.info("insert data: "+productRepository.save(productA));
                logger.info("insert data: "+productRepository.save(productB));
            }
        };
    }
}
