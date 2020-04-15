package com.rest.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.annotation.Resources;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDaoServices services ;
	@GetMapping(path = "/users")
	public List<User> retrieveAllUser(){
		return services.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable  int id){
		User user =services.FindOne(id);
		if(user==null)throw new UserNotFoundException("id -" + id) ;
		
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkTo =	linkTo(methodOn(this.getClass()).retrieveAllUser() ); 
//		resource.add(linkTo.withRel("all-user"));
//		return resource;
		
		return user ;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user ){
		User saveUser= services.SaveUser(user);
		
		///users/{id} ,  id =  user.getId();
	URI location =	ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(saveUser.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public User DeleteUserById(@PathVariable  int id){
		User user =services.DeleteById(id);
		if(user==null)throw new UserNotFoundException("id -" + id) ;
		return user;
	}
	
	
	@GetMapping(path = "/useme")
	public List<User> retrieveAllUseme(){
		return services.findAll();
	}
}

