package com.jp.youplace.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();

	<S extends User> S save(S entity);
	
	User findOne(Long id); 
	
	long count();    

}
