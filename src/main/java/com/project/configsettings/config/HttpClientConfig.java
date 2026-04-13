package com.project.configsettings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpClientConfig {
    @Bean
    public RestClient restClient(AppProperties appProperties) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(appProperties.getHttp().getConnectTimeoutMs());
        requestFactory.setReadTimeout(appProperties.getHttp().getReadTimeoutMs());

        return RestClient.builder()
                .requestFactory(requestFactory)
                .build();
    }
}
