package com.tudresden.mas.agents;
import com.tudresden.jadeframework.ContainerKiller;
import jade.core.behaviours.Behaviour;
import jade.core.Agent;

import static com.tudresden.multiagents.jadetopicmanagement.MessageBuilder.inform;
import static com.tudresden.multiagents.jadetopicmanagement.MessageReceiver.listen;

import java.util.logging.Logger;

public class IncrementBehaviour extends Behaviour {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1988293032278181432L;

	private static final Logger logger = Logger.getLogger(IncrementBehaviour.class.getName());

    private static final int MAX_INCREMENT = 10;
    
    // This states and behaviour will be transferred to the solidity contract
    private enum State {
    	START_INCREMENT, CONTINUE_INCREMENT, STOP_INCREMENT;
    }
    
    private final Agent agent;
    private final String otherAgentName;
    private State state;
    
    public IncrementBehaviour(Agent agent, String otherAgentName)
    {
    	this.agent = agent;
    	this.otherAgentName = otherAgentName;
    	this.state = State.START_INCREMENT;
    	
    }
    
    @Override
    public void action() 
    {
    	switch(state)
    	{
    		case START_INCREMENT:
    			startIncrementing();
    			break;
    		case CONTINUE_INCREMENT:
    			continueIncrementing();
    			break;
    		case STOP_INCREMENT:
    			stopIncrementing();
    			break;
    		default:
    			block();
    	}
    }
    
    private void startIncrementing()
    {
    	agent.send(inform().toLocal(otherAgentName).withContent(1).build());
    	state = State.CONTINUE_INCREMENT;
    }
    
    private void continueIncrementing()
    {
    	listen(agent, this).forInteger((toIncrement) -> {
    		logger.info("Received " + toIncrement);
    		toIncrement++;
    		agent.send(inform().toLocal(otherAgentName).withContent(toIncrement).build());
    		if(toIncrement > MAX_INCREMENT) 
    		{
    			state = State.STOP_INCREMENT;
    		}
    	});
    }
    
    private void stopIncrementing()
    {
        listen(agent, this).forInteger((toIgnore) -> {
            logger.info("Ignore this please: " + toIgnore);
            ContainerKiller.killContainerOf(agent);
        });
    }

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}
}
