package com.andrewprogramming.gaokao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("cn.itweknow.sbswagger.controller"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "爬取并提供高效相关信息的Rest API",
                "我的网站：www.andrew-programming.com",
                "API V1.0",
                "Terms of service",
                new Contact("Andrew", "http://www.andrew-programming.com", "andrew.deng@andrew-programming.com"),
                "Andrew Private Licence", "http://www.andrew-programming.com", Collections.emptyList());
    }
}