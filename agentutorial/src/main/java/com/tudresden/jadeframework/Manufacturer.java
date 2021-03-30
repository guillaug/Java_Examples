package com.tudresden.jadeframework;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import com.tu_dresden.ethereum.ConnectionWeb3;
import java.util.logging.Logger;

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
	
	//This is a JADE Agent
	
	//private Logger instance
	private static final Logger logger = Logger.getLogger(Manufacturer.class.getName());

	//The name of the Item
	private String targetManufacturingItem;
	
	//The list of known distributor companies
	private AID[] distributorAgent;
	
	protected void setup() {
		logger.info("setup manufacturing");
		
		//Argument based programming - We need take params from front-end application
		Object[] args = getArguments();
		if(args != null && args.length > 0) {
			targetManufacturingItem = (String) args[0];
			logger.info("the name of the manufacturing item is: " + targetManufacturingItem);
			
			//Add a ticket behaviour that schedules a request to seller agents every minute
			addBehaviour(new TickerBehaviour(this, 60000) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				protected void onTick() {
					logger.info("We are trying to reach the following item : " + targetManufacturingItem);
					DFAgentDescription template = new DFAgentDescription(); // this is an ontology description
					ServiceDescription serviceDesc = new ServiceDescription();
					serviceDesc.setType("manufacturingItemTransfer");
					template.addServices(serviceDesc);  // added service to the template
					try {
						DFAgentDescription[] results = DFService.search(myAgent, template);
						distributorAgent = new AID[results.length];
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
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private AID producer;
		private int bestPrice;
		private int counterReply = 0;
		private MessageTemplate messageTemplate;
		private int condition = 0;
		@Override
		public void action() {
			// TODO Auto-generated method stub
			switch(condition) {
			case 0:
				//Send the cfp to all manufacturing companies
				ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
				for(int i = 0; i < distributorAgent.length; ++i) {
					cfp.addReceiver(distributorAgent[i]); //scann all receivers
				}
				cfp.setContent(targetManufacturingItem);
				cfp.setConversationId("initial-manufacturing");
				cfp.setReplyWith("cfp" + System.currentTimeMillis());
				myAgent.send(cfp);
				
				//Prepare the template to get proposals
				messageTemplate = MessageTemplate.and(MessageTemplate.MatchConversationId("suppy_chain_simulation"),
						MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));
			break;
			
			case 1:
				ACLMessage reply = myAgent.receive(messageTemplate); // reply to the message
				if(reply != null) {
					//Reply received 
					if (reply.getPerformative() == ACLMessage.PROPOSE) {
						// WHy propose message 
						int worth = Integer.parseInt(reply.getContent());
						if (producer == null || worth < bestPrice) {
							//price assignment to the bestPrice
							bestPrice = worth;
							producer = reply.getSender();
						}
					}
					counterReply++;
					if(counterReply >= distributorAgent.length) {
						//if you want, you can assign a step count
					}
					
				}
				else {
					block();
				}
			break;
			case 2:
				ACLMessage order = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
				order.addReceiver(producer);
				order.setContent(targetManufacturingItem); 
				order.setConversationId("suppy_chain_simulation");
				order.setReplyWith("order" + System.currentTimeMillis());
				myAgent.send(order); //send order to manufacturing company
				messageTemplate = MessageTemplate.and(MessageTemplate.MatchConversationId("supply-chain-simulation"),
						MessageTemplate.MatchInReplyTo(order.getReplyWith()));
				break;
			case 3:
				reply = myAgent.receive(messageTemplate);
				if(reply != null) {
					//Purchase order reply received
					if(reply.getPerformative() == ACLMessage.INFORM) //why get performative
					{
						logger.info("targetManufacturingItem: " + targetManufacturingItem);
						logger.info("Producer: " + producer);
						myAgent.doDelete();
					}else {
						logger.info("Attempt failed. Please try again.");
					}
				} else {
					block();
				}
				break;
			}
		}

		public boolean done() {
			// TODO Auto-generated method stub
			if(producer == null) { // why error
				logger.info("Attempt failed");
			}
			return false;
		}
		
	}
}
