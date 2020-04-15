package com.rest.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;
import javax.validation.Valid;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	@Autowired
	private UserDaoServices services ;
	
	@Autowired
	private  UserRepository userRepository ;
	
	@Autowired
	private  PostRepository postRepository ;
	
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable  int id){
	Optional<User>	 user =userRepository.findById(id);
		if(!user.isPresent())throw new UserNotFoundException("id -" + id) ;
		
		/*
		 * Resource<User> resource = new Resource<User>(user.get());
		 * ControllerLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).retrieveAllUser() );
		 * resource.add(linkTo.withRel("all-user")); return resource;
		 */
		
		return user ;
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user ){
		User saveUser= userRepository.save(user);
		
		///users/{id} ,  id =  user.getId();
	URI location =	ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(saveUser.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	
	}
	
	
	@DeleteMapping(path = "/jpa/delete/{id}")
	public Void DeleteUserById(@PathVariable  int id){
		 userRepository.deleteById(id);
	//	if(user==null)throw new UserNotFoundException("id -" + id) ;
	//	return user;
		return null;
	}
	
	
	@GetMapping(path = "/jpa/useme")
	public List<User> retrieveAllUseme(){
		return userRepository.findAll();
	}
	
	
	@GetMapping(path = "/jpa/users/{id}/post")
	public List<Post> retrieveAllUser(@PathVariable int id){
		
		Optional<User>	 user =userRepository.findById(id);
		if(!user.isPresent())throw new UserNotFoundException("id -" + id) ;
		
		return user.get().getPost();
	}
	
	
	@PostMapping(path = "/jpa/users/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post ){
		Optional<User> userOPt =userRepository.findById(id);
		if(!userOPt.isPresent())throw new UserNotFoundException("id -" + id) ;
		
		User user =  userOPt.get();
		post.setUser(user);
		postRepository.save(post); 
		URI location =	ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(post.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	
	}
}

