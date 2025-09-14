package com.victor_pokemon.aula.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("medico")
                .pathsToMatch("/**")
                .packagesToScan("com.curso.resources")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info().title("Medico")
                .description("Medico")
                .version("1.0")
                .contact(new Contact().name("Curso Spring")
                        .url("https://github.com/VitinhoChicas/Pokemon")
                        .email("curso@curso.com.br")));
    }
}
