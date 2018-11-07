package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("demo-server-apis")
        .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(controllerPaths())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Demo Service").description("Demo Service").version("v1")
        .build();
  }

  private Predicate<String> controllerPaths() {
    return Predicates.or(PathSelectors.regex("/demoservice/v1/.*"));
  }

}
