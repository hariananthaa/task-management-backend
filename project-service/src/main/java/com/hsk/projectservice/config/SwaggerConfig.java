package com.hsk.projectservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "Project Service API", description = "Project API documentation", version = "1.0"),
        servers = {@Server(url = "${swagger-url}", description = "Default Server URL")})
public class SwaggerConfig {
}