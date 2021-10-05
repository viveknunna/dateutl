package com.ust.adddaystodate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.ust.adddaystodate")).build()
				.useDefaultResponseMessages(false).apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Date calculator based on input days")
				.description("this page lists Date utility API's")
				.version("1.0")
				.contact(new Contact("IK","https://spn.io","test@gmail.com"))
				.license("License 2.0")
				.licenseUrl("https://www.spn.com/License")
				.build();
	}

}
