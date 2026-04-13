package com.project.configsettings.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupValidationRunner implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(StartupValidationRunner.class);

    private final AppProperties appProperties;
    private final Environment environment;

    public StartupValidationRunner(AppProperties appProperties, Environment environment) {
        this.appProperties = appProperties;
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) {
        boolean prodProfileActive = Arrays.asList(environment.getActiveProfiles()).contains("prod");

        if (prodProfileActive) {
            String jwtSecret = appProperties.getSecurity().getJwtSecret();

            if (jwtSecret == null || jwtSecret.isBlank()) {
                throw new IllegalStateException("APP_JWT_SECRET must be provided when 'prod' profile is active.");
            }

            if (appProperties.getCors().getAllowedOrigins().stream().anyMatch("*"::equals)) {
                throw new IllegalStateException("Wildcard CORS origin is not allowed in prod profile.");
            }
        }

        log.info("Application startup validation completed successfully. activeProfiles={}",
                Arrays.toString(environment.getActiveProfiles()));
    }
}
