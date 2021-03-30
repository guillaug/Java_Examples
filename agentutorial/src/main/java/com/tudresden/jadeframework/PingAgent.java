package com.tudresden.jadeframework;
import java.util.logging.Logger;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;


public class PingAgent extends Agent {

	private static final Logger logger = Logger.getLogger(PingAgent.class.getName());
	
	
	/**
	 * 
	 */
	private final long serialVersionUID = -4101145908606966647L;

	public void setup() {
		logger.info("setup for the JADE agents" + getAID().getName());
		addBehaviour(new CyclicBehaviour(this) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 2901804430208592075L;

			@Override
			public void action() {
				// TODO Auto-generated method stub
				ACLMessage msg = receive();
				if(msg != null) {
					logger.info("agent name: " + myAgent.getLocalName() + "received: " + msg.getContent());
				}
				block();
			}
		});
		
		AMSAgentDescription[] agents = null; 
		try {
			SearchConstraints c = new SearchConstraints();
			c.setMaxResults(new Long(-1));
			agents = AMSService.search(this, new AMSAgentDescription(), c);  // AMS Dienst - Initialisierung - AMS Service Initialization
		}catch(Exception ex) {
			logger.info("Problem bei der AMS-Suche: " + ex);
			ex.printStackTrace();
		}
		
		for (AMSAgentDescription agent : agents) {
			AID agentID = agent.getName();
			ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
			msg.addReceiver(agentID);
			msg.setLanguage("English");
			msg.setContent("Ping");
			send(msg);
		}
	}
}
