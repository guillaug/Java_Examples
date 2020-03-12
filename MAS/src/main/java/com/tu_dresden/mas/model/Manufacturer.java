package com.tu_dresden.mas.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tu_dresden.blockchain.ConnectionWeb3;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.core.behaviours.*;

public class Manufacturer extends Agent{
	
	//private Logger instance
	private static final Logger logger = LoggerFactory.getLogger(ConnectionWeb3.class.getName());

	//The name of the Item
	private String targetManufacturingItem;
	
	//The list of known manufacturing companies
	private AID[] manufacturaAgents;
	
	protected void setup() {
		logger.info("setup manufacturing");
		
		//Argument based programming - We need take params from front-end application
		Object[] args = getArguments();
		if(args != null && args.length > 0) {
			targetManufacturingItem = (String) args[0];
			logger.info("the name of the manufacturing item is: " + targetManufacturingItem);
			
			//Add a ticket behaviour that schedules a request to seller agents every minute
			addBehaviour(new TickerBehaviour(this, 60000) {
				protected void onTick() {
					logger.info("We are trying to reach the following item : " + targetManufacturingItem);
					DFAgentDescription template = new DFAgentDescription(); // this is an ontology description
					ServiceDescription serviceDesc = new ServiceDescription();
					serviceDesc.setType("manufacturingItemTransfer");
					template.addServices(serviceDesc);
					try {
						DFAgentDescription[] results = DFService.search(myAgent, template);
						manufacturaAgents = new AID[results.length];
						for(int i = 0; i < results.length; ++i) {
							
						}
					} catch (FIPAException fe) {
						fe.printStackTrace();
					}
					
					myAgent.addBehaviour(new RequestPerformer());
				}
			});
		}

	}
	
	private class RequestPerformer extends Behaviour {
		
		private AID producer;
		private int bestPrice;
		private int repliesCnt = 0;
		private MessageTemplate messageTemplate;
		private int condition = 0;
		@Override
		public void action() {
			// TODO Auto-generated method stub
			switch(condition) {
			case 0:
				//Send the cfp to all manufacturing companies
				ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
				for(int i = 0; i < manufacturaAgents.length; ++i) {
					cfp.addReceiver(manufacturaAgents[i]); //scann all receivers
				}
				cfp.setContent(targetManufacturingItem);
				cfp.setConversationId("initial-manufacturing");
				cfp.setReplyWith("cfp" + System.currentTimeMillis());
				myAgent.send(cfp);
				
				//Prepare the template to get proposals
				//mt = MessageTemplate.and(MessageTemplate.MatchConversationId("suppy_chain_simulation"));
			}
		}

		@Override
		public boolean done() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}