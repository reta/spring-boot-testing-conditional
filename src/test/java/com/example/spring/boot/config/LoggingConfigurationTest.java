package com.example.spring.boot.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Enclosed.class)
public class LoggingConfigurationTest {
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public static class LoggerEnabledTest {
        @Autowired private Logger logger;
        
        @Test
        public void loggerShouldBeSlf4j() {
            assertThat(logger).isInstanceOf(ch.qos.logback.classic.Logger.class);
        }
    }
    
    @RunWith(SpringRunner.class)
    @SpringBootTest
    @TestPropertySource(properties = "logging.enabled=false")
    public static class LoggerDisabledTest {
        @Autowired private Logger logger;
        
        @Test
        public void loggerShouldBeNoop() {
            assertThat(logger).isSameAs(NOPLogger.NOP_LOGGER);
        }
    }
}
