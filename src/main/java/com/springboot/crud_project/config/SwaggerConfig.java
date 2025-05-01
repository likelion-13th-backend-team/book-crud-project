package com.springboot.crud_project.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("도서 관리 시스템 API")
                        .description("Spring Boot 기반 CRUD API")
                        .version("v1.0")
                        .contact(new Contact().name("LikeLion13th").email("team@example.com"))
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("깃허브 문서 보기")
                        .url("https://github.com/your-team/book-management-system"));
    }
}
