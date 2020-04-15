package com.tu_dresden.mas.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class UniqueAgent extends Agent{

	private static final Logger logger = LoggerFactory.getLogger(UniqueAgent.class.getName());
	
	@Override
	public void setup()
	{
		final String otherAgentName = (String) this.getArguments()[0];
		//addBehaviour(new newBehaviour(this, otherAgentName));
	}
	
	@Override
	public void takeDown()
	{
		// take down the action
	}
}
