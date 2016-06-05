package com.jp.youplace.domain;


public interface UserRepository extends CustomRepository<User, Long> {
	User findByUserName(String userName);
	void deleteById(Long id);
}
