package com.shfc.cloud.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package com.shfc.cloud.swagger2.SwaggerConfig
 * @Description: swagger config
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/18 15:10
 * version V1.0.0
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig{

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("cloud web 中使用Swagger2构建RESTful APIs")
//                .license("Apache License Version 2.0")
                .contact(new Contact("冷风吹", null, null))
                .version("v1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build().apiInfo(apiInfo());
    }
}
