package com.retail.pos.dto.request;

import java.util.List;

public class RoleAuthorityDto {

	private Integer id;

	private String roleName;

	private List<AuthorityDto> authorityList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<AuthorityDto> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<AuthorityDto> authorityList) {
		this.authorityList = authorityList;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", roleName=" + roleName + ", authorityList=" + authorityList + "]";
	}
}