package com.rest.webservice.restfulwebservice.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id ;
	private String discription ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user ;
	
	
	
	public Post(){
		
	}
	
	public Post(Integer id, String discription, User user) {
		super();
		this.id = id;
		this.discription = discription;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", discription=" + discription + "]";
	}
	
	
}
