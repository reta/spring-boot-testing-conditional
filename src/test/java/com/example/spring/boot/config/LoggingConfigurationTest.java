package com.example.spring.boot.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class LoggingConfigurationTest {
    @Nested
    @ExtendWith(SpringExtension.class)
    @SpringBootTest
    @DisplayName("Logging is enabled, expecting Slf4j logger")
    public static class LoggerEnabledTest {
        @Autowired private Logger logger;
        
        @Test
        public void loggerShouldBeSlf4j() {
            assertThat(logger).isInstanceOf(ch.qos.logback.classic.Logger.class);
        }
    }
    
    @Nested
    @ExtendWith(SpringExtension.class)
    @SpringBootTest
    @TestPropertySource(properties = "logging.enabled=false")
    @DisplayName("Logging is disabled, expecting NOOP logger")
    public static class LoggerDisabledTest {
        @Autowired private Logger logger;
        
        @Test
        public void loggerShouldBeNoop() {
            assertThat(logger).isSameAs(NOPLogger.NOP_LOGGER);
        }
    }
}
