package com.example.spring.boot.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class LoggingConfigurationTest {
    private final ApplicationContextRunner runner = new ApplicationContextRunner()
        .withConfiguration(UserConfigurations.of(LoggingConfiguration.class));
    
    @Test
    public void loggerShouldBeSlf4j() {
        runner
            .run(ctx -> 
                assertThat(ctx.getBean(Logger.class)).isInstanceOf(Logger.class)
            );
    }
    
    @Test
    public void loggerShouldBeNoop() {
        runner
            .withPropertyValues("logging.enabled=false")
            .run(ctx -> 
                assertThat(ctx.getBean(Logger.class)).isSameAs(NOPLogger.NOP_LOGGER)
            );
    }
}
