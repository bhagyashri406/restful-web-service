package com.rest.webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restfulwebservice.filter.SomeBeam;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBeam RetriveSomeBeam() {
		return new SomeBeam("value1" , "value2" , "Value3");
	}

}
