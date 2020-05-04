package com.tu_dresden.akka;

public class Role {
	private final Long id;
	
	private final String name;
	
	public Role()
	{
		this.name = "";
		this.id = null;
	}
	
	public Role(Long id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Long getID() 
	{
		return id;
	}
}
