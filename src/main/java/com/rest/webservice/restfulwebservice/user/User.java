package com.rest.webservice.restfulwebservice.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "all details about user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer  id;
	
	@Size(min=2, message = "Name Should have atleast 2 characters")
	@ApiModelProperty(notes = "Name Should have atleast 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "brithday should not be in the past")
	private Date birthday;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	
	
	public User() {
		
	}
	public User(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bathday=" + birthday + "]";
	}
	
	
}
