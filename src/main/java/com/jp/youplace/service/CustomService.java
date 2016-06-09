package com.jp.youplace.service;

import java.util.List;

public interface CustomService<T> {
	public List<T> findAll();

	public T findOne(Long id);

	public void save(T entity);

	public Long count();

	public void delete(T entity);

	public void deleteById(Long id);
}
