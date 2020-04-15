package com.rest.webservice.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoServices {

	private static int userid = 4;
	private static List<User> users = new ArrayList<>() ;
	
	static {
		
		users.add(new User(1, "name1", new Date() ) );
		users.add(new User(2, "name2", new Date() ) );
		users.add(new User(3, "name3", new Date() ) );
		users.add(new User(4, "name4", new Date() ) );
	}
	
	// List<User> findAll();
	
	public List<User> findAll() {
		return users ;
	}
	
	public User SaveUser(User user) {
	if(user.getId()==null) {
		user.setId(++userid);
	}
		users.add(user) ;
		return user;
	}
	
	// save user saveUser(User user);
	// find user findOne(int id);
	
	public User FindOne(int id) {
	
		for(User user: users) {
			if(user.getId()==id) {
				return user ;
			}
		}
		return null;
	}
	
	public User DeleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user= iterator.next();
			if(user.getId()==id) {
				return user ;
			}
		}
		return null;
	}
}
	
	
	
