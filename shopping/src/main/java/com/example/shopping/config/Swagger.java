package com.example.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class Swagger {
    private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

    @Bean
    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.shopping"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .description("Authorization")
                .defaultValue("Bearer ")
                .required(false)
                .build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES)

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.shopping"))
                .build()
                // Setting globalOperationParameters ensures that authentication header is applied to all APIs
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Shopping API",
                "Shopping APIs.",
                "0.0.1",
                "Terms of service",
                new Contact("Bui Hoang Thai", "", ""),
                "License of API", "API license URL", Collections.emptyList());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(null, null, null, null, "Authorization", ApiKeyVehicle.HEADER,
//                "Authorization", ",");
//    }
}
