package com.jp.youplace.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Role;
import com.jp.youplace.domain.RoleRepository;
import com.jp.youplace.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Long count() {
		return roleRepository.count();
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

	@Override
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}
	
}
