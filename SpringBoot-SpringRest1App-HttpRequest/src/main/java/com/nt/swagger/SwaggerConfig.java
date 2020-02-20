package com.nt.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createDocket() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				      .select()
				      .apis (RequestHandlerSelectors.basePackage("com.nt.restcontroller"))
				      .paths(PathSelectors.any())
				      .build()
				      .apiInfo(getApiContactDtls());
				      return docket;
		
	}
	public ApiInfo getApiContactDtls() {
		Contact c=new Contact("TEK-LEADS","www.tekleads.com","tekleads4u@gmail.com");
				ApiInfo apiInfo=new ApiInfo("Contact-Api"
						                     ,"contact Operation"
						                     ,"1.1"
						                     ,"www.tekleads.com"
						                     ,c
						                     ,"www.apache.org/licence"
						                     ,"www.apache.org");
	 return apiInfo;
	}

}
