package com.jp.youplace.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Category;
import com.jp.youplace.domain.CategoryRepository;
import com.jp.youplace.service.ICategoryService;

@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public void save(Category entity) {
		categoryRepository.save(entity);
	}

	@Override
	public Long count() {
		return categoryRepository.count();
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

}
