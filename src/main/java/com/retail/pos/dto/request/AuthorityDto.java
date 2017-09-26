package com.retail.pos.dto.request;

public class AuthorityDto {

	private Integer id;

	private String authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "AuthorityDto [id=" + id + ", authority=" + authority + "]";
	}
}
