package com.jp.youplace.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String name;
	
	public User() {
	}

	
	public User(long id, String name) {
		super();
		Id = id;
		this.name = name;
	}


	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + "]";
	}
	
	
}
