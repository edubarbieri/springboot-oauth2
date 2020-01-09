package br.com.edubarbieri.authserver.model;

import org.springframework.security.core.GrantedAuthority;

import br.com.edubarbieri.authserver.domain.Role;

public class UserGrantedAuthority implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	private final String grant;
	
	public UserGrantedAuthority(Role authority) {
		this.grant = authority.getId();
	}
	
	@Override
	public String getAuthority() {
		return grant;
	}

}
