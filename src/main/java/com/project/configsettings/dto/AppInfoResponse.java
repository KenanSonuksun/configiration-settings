package com.project.configsettings.dto;

import java.util.List;

public record AppInfoResponse(
        String appName,
        List<String> allowedOrigins,
        int jwtExpirationMinutes,
        int connectTimeoutMs,
        int readTimeoutMs,
        boolean requestLogEnabled,
        List<String> activeProfiles
) {
}