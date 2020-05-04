package com.tu_dresden.akka;

import java.io.Serializable;

public interface RoleMessages {

	//Type your messages in this class to collaborate between actors
	
	class ActionPerformed implements Serializable 
	{

	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = 6140958651365971575L;
		private final String description;
	    
	    public ActionPerformed(String description)
	    {
	    	this.description = description;
	    }
	    
	    public String getDescription()
	    {
	    	return description;
	    }
	}
	
	class CreateRoleMessages implements Serializable 
	{
	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = 4886187512230236655L;
		private final Role roles; 
	    
	    public CreateRoleMessages(Role roles)
	    {
	    	this.roles = roles;
	    }
	    
	    public Role getRoles()
	    {
	    	return roles;
	    }
	}
	
	
	// add a class named GetRoleMessage and implements Serializable
	// Serialize with a value 
	// Set Role Id
	// Get Role ID
	
	class GetRoleMessage implements Serializable 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2578945027920918623L;
		/**
		 * 
		 */
		
		private Long roleID = null;
		
		public void setRoleID(Long roleID)
		{
			this.roleID = roleID;
		}
		
		public Long getRoleID()
		{
			return roleID;
		}
	}

}
