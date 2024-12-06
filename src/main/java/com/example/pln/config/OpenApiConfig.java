package com.example.pln.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
     @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                .title("Swagger")
                .version("1.0")
                .description("VERSION 1")
                .contact(new Contact().name("STE").url("JEJEJ")));
    }

    
    
}
