package com.example.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfiguration {
    @Configuration
    @ConditionalOnProperty(name = "logging.enabled", matchIfMissing = true)
    public static class Slf4jConfiguration {
        @Bean
        Logger logger() {
            return LoggerFactory.getLogger("sample");
        }
    }
    
    @Bean
    @ConditionalOnMissingBean
    Logger logger() {
        return new NOPLoggerFactory().getLogger("sample"); 
    }
}
