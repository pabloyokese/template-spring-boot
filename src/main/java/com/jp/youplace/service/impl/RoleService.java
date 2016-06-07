package com.jp.youplace.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Role;
import com.jp.youplace.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {

	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public Role findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
