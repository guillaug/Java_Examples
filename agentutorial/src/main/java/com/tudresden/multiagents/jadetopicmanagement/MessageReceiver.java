package com.tudresden.multiagents.topicmanagement;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class MessageReceiver {

	private final Agent agent;
	private final Behaviour behaviour;
	
	private MessageReceiver(Agent agent, Behaviour behaviour)
	{
		this.agent = agent;
		this.behaviour = behaviour;
	}
	
	public static MessageReceiver listen(Agent agent, Behaviour behaviour)
	{
		return new MessageReceiver(agent, behaviour);
	}
	
	public void forInteger(MessageContentReceiver contentReceiver)
	{
		ACLMessage message = agent.receive();
		if(message != null)
		{
			// We need to receive content
			contentReceiver.onMessage(Integer.valueOf(message.getContent()));  //Turn the value to Integer
		}
		else
		{
			behaviour.block(); // delete the behaviour
		}
	}
}
