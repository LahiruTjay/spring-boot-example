package com.retail.pos.exception;

import org.springframework.security.core.AuthenticationException;

public class CurrentRoleNotFoundException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public CurrentRoleNotFoundException() {
		super("CurrentRoleNotFoundException");
	}

}