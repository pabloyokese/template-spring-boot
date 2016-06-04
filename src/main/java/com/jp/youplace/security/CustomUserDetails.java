package com.jp.youplace.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.jp.youplace.domain.User;


public class CustomUserDetails extends User implements UserDetails{

	private static final long serialVersionUID = 1L;
	private List<String> roles;
	
	public CustomUserDetails(User user, List<String> roles) {
		super(user);
		this.roles = roles;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = org.springframework.util.StringUtils.collectionToCommaDelimitedString(this.roles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
