package com.tudresden.jadeframework;

import java.util.logging.Logger;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class PongAgent extends Agent{
	
	private static final Logger logger = Logger.getLogger(PongAgent.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 53578959314759087L;
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 8496031986207004406L;

			@Override
			public void action() {
				// TODO Auto-generated method stub
				ACLMessage msg = receive();
				if(msg != null) {
					logger.info("MyAgent info: " + myAgent.getLocalName() + " received: " + msg.getContent());
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Pong");
					send(reply);
				}
				block();
			}
		});			
	}
}
