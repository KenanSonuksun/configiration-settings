package com.project.configsettings;

import com.project.configsettings.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ConfigSettingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSettingsApplication.class, args);
    }

}
