package com.rest.webservice.restfulwebservice.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
@GetMapping("/filter")
public MappingJacksonValue RetriveSomeBeam(){
	SomeBeam someBeam =	 new SomeBeam("value1" , "value2" , "Value3");
	MappingJacksonValue mapping = new MappingJacksonValue(someBeam) ;
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1" ,"field3");
	FilterProvider filters   = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	mapping.setFilters(filters);
	return mapping ;
}


@GetMapping("/filteringList")
public SomeBeam RetriveSomeBeamAll(){
	return new SomeBeam("value1" , "value2" , "Value3");
}


@GetMapping("/filtering-list")
public MappingJacksonValue RetriveListSomeBeam(){
	
	
	//SomeBeam someBeam =	 new SomeBeam("value1" , "value2" , "Value3");
	
	List<SomeBeam> beams = new ArrayList<SomeBeam>();
	beams.add(new SomeBeam("value1" , "value2" , "Value3"));
	beams.add(new SomeBeam("value11" , "value22" , "Value33"));
	beams.add(new SomeBeam("value13" , "value23" , "Value33"));
	
	
	
	MappingJacksonValue mapping = new MappingJacksonValue(beams) ;
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1" ,"field3");
	FilterProvider filters   = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	mapping.setFilters(filters);
	return mapping ;
	

//    System.out.println("filteringlist");
//	return beams;  //Arrays.asList(new SomeBeam("value1" , "value2" , "Value3"), new SomeBeam("value11" , "value22" , "Value3"));
}

}