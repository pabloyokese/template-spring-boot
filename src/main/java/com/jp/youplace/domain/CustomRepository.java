package com.jp.youplace.domain;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

	<S extends T> S save(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	long count();

	void delete(T entity);

	boolean exists(ID primaryKey);
}