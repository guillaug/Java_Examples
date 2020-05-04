package com.tu_dresden.akka;

import com.tu_dresden.akka.RoleMessages.ActionPerformed;
import com.tu_dresden.akka.RoleMessages.CreateRoleMessages;
import com.tu_dresden.akka.RoleMessages.GetRoleMessage;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.FI;

public class RoleActor extends AbstractActor{
	
	private RoleService roleService = new RoleService();
	
	// Insert a prop
	static Props prop()
	{
		return Props.create(RoleActor.class);
	}

	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		//Receive builder
		return receiveBuilder()
				.match(CreateRoleMessages.class, handleCreateRole())
				.match(GetRoleMessage.class, handleGetRole())
				.build();
	}
		
	  //Java Stream
	  private FI.UnitApply<CreateRoleMessages> handleCreateRole() {
		    return createRoleMessageMessage -> {
		      roleService.createRole(createRoleMessageMessage.getRoles());
		      sender().tell(new ActionPerformed(String.format("Role %s created.", createRoleMessageMessage.getRoles()
		              .getName())), getSelf());
		    };
		  }
	  	 
  	  // Java Stream
	  private FI.UnitApply<GetRoleMessage> handleGetRole() {
	    return getUserMessageMessage -> {
	      sender().tell(roleService.getRoles(getUserMessageMessage.getRoleID()), getSelf());
	    };
	  }

	
	

}
