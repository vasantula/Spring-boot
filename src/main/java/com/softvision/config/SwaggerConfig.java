package com.softvision.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Ramesh", "@vasantula", "vasantula@gmail.com");
	public static final ApiInfo DEFAULT = new ApiInfo("Sample API documentation Title", "Sample Api Documentation",
			"1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUMES = new HashSet<>(
			Arrays.asList("application/json", "application/xml")) ;

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(DEFAULT_PRODUCE_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCE_AND_CONSUMES).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
}
