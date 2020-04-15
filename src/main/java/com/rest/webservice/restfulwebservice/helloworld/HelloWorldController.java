package com.rest.webservice.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	// method = "hello world"
	// GET
	// URI- /hello-world
	// @GetMapping(path = "/hello-world");
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String HelloWorld() {

		return "Hello World";

	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {

		return new HelloWorldBean("Hello World Bean");

	}

	// /hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

		return new HelloWorldBean(String.format("Hello World, %s", name));

	}
	
//	same method as below

//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-International")
//	public String HelloWorldInternational(@RequestHeader(name= "Accept-Language" , required = false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-International")
	public String HelloWorldInternational() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
