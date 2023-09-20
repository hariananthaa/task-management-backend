package com.hsk.apigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    public GatewayConfig() {
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/v1/users/**")
                        .uri("http://localhost:8091"))
                .route("project-service", r -> r.path("/api/v1/projects/**")
                        .uri("http://localhost:8092"))
                .build();
    }
}
