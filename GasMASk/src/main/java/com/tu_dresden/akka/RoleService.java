package com.tu_dresden.akka;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleService {
	
	private final static List<Role> roles = new ArrayList<>();
	
	//hardcoded role names
	static {
		roles.add(new Role(1l, "Role1"));
		roles.add(new Role(2l, "Role2"));
		roles.add(new Role(3l, "Role3"));
	}
	
	public Optional<Role> getRoles(Long id)
	{
		// Do not use primitive type here
		return roles.stream().filter(role -> role.getID().equals(id)).findFirst();
	}
	
	public void createRole(Role role)
	{
		roles.add(role);
	}
	
	public List<Role> getRoles()
	{
		return roles;
	}

}
