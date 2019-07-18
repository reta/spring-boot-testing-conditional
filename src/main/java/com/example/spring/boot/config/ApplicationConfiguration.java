package com.example.spring.boot.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import(LoggingConfiguration.class)
public class ApplicationConfiguration {
}
