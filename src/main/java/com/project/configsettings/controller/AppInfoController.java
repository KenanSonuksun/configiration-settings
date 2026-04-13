package com.project.configsettings.controller;

import com.project.configsettings.config.AppProperties;
import com.project.configsettings.dto.AppInfoResponse;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AppInfoController {

    private final AppProperties appProperties;
    private final Environment environment;

    public AppInfoController(AppProperties appProperties, Environment environment) {
        this.appProperties = appProperties;
        this.environment = environment;
    }

    @GetMapping("/api/app-info")
    public AppInfoResponse appInfo() {
        return new AppInfoResponse(
                "config-settings",
                appProperties.getCors().getAllowedOrigins(),
                appProperties.getSecurity().getJwtExpirationMinutes(),
                appProperties.getHttp().getConnectTimeoutMs(),
                appProperties.getHttp().getReadTimeoutMs(),
                appProperties.getFeatures().isRequestLogEnabled(),
                Arrays.asList(environment.getActiveProfiles())
        );
    }
}
