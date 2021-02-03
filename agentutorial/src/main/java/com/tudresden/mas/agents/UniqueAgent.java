package com.tudresden.mas.agents;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.logging.Logger;

public class UniqueAgent extends Agent{

	private static final Logger logger = Logger.getLogger(UniqueAgent.class.getName());
	
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
