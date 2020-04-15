package com.rest.webservice.restfulwebservice.versining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		PersonV1 p1 = new PersonV1("Bhagya Shri");
		
		return p1 ;
		
	}
	@GetMapping("/v2/person")
     public PersonV2 personV2() {
		Name name= new Name("Bhagya", "Shri");
		PersonV2 p2 =new PersonV2(name);
		return p2;
		
	}
	
	@GetMapping(value = "/params/person", params = "version=1")
    public PersonV1 params1() {
    PersonV1 p1 = new PersonV1("Bhagya Shri");
		
		return p1 ;
		
	}
	
	@GetMapping(value = "/params/person", params = "version=2")
    public PersonV2 params2() {
		Name name= new Name("Bhagya", "Shri");
		PersonV2 p2 =new PersonV2(name);
		return p2;
		
	}
	
	@GetMapping(value = "/header/person", headers = "API_VERSION=1")
    public PersonV1 header1() {
    PersonV1 p1 = new PersonV1("Bhagya Shri");
	return p1 ;
		
	}
	
	@GetMapping(value = "/header/person", headers = "API_VERSION=2")
    public PersonV2 header2() {
		Name name= new Name("Bhagya", "Shri");
		PersonV2 p2 =new PersonV2(name);
		return p2;
		
	}
	
	
	@GetMapping(value = "/perduces/person", produces = "v1")
    public PersonV1 produces1() {
    PersonV1 p1 = new PersonV1("Bhagya Shri");
	return p1 ;
		
	}
	
	@GetMapping(value = "/perduces/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 produces2() {
		Name name= new Name("Bhagya", "Shri");
		PersonV2 p2 =new PersonV2(name);
		return p2;
		
	}
}
