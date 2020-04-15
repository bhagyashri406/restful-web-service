package com.rest.webservice.restfulwebservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
	
	 public static Contact DEAFULT_CONTACT = new Contact("ranga", "http://www.in28minutes.com", "in28minutes@gmail.com");
     @SuppressWarnings("deprecation")
	 public static ApiInfo DEAFULT_APP_INFO= new ApiInfo("Awesome API title", "Awesome API Description", "1.0", "urn:tos", DEAFULT_CONTACT.toString() , "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
     private static Set<String> DEFAULT_PRODUCER_CONSUMER =new HashSet<String>(Arrays.asList("application/json" ,"application/xml")) ;
	
    @Bean
    public Docket api() {

    	// contact =new Contact("ranga", "http://www.in28minutes.com", "in28minutes@gmail.com");
      	return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEAFULT_APP_INFO)
                .produces(DEFAULT_PRODUCER_CONSUMER);

    }
}