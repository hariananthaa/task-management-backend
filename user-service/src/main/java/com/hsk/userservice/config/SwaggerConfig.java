package com.hsk.userservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "User Service API", description = "User API documentation", version = "1.0"),
        servers = {@Server(url = "${swagger-url}", description = "Default Server URL")})
public class SwaggerConfig {
}