package com.tudresden.multiagents.distributors;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour; //Behaviour library
import jade.core.behaviours.OneShotBehaviour; //Behaviour library
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Hashtable;

import java.util.logging.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Distributor extends Agent{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8710400690661645060L;

	private static final Logger logger = Logger.getLogger(Distributor.class.getName());
	
	// The catalogue of items
	private Hashtable<String, Integer> collectionDist;
	
	//GUI object
	private DistributorGUI myGui;
	
	// setup function is going to be initiated
	protected void setup() {
		//Create the catalogue
		collectionDist = new Hashtable<String, Integer>();
		
		//This is the name of agent
		logger.info("Hello System! My name is " + getLocalName());
		
		DFAgentDescription dfDescription = new DFAgentDescription();
		dfDescription.setName(getAID());
		ServiceDescription serviceDescription = new ServiceDescription();
		serviceDescription.setType("supply-chain-management");
		serviceDescription.setName("JADE-example");
		dfDescription.addServices(serviceDescription);
		try 
		{
			DFService.register(this, dfDescription);
		} 
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void updateWarehouse(final String title, final int amount) {
		addBehaviour(new OneShotBehaviour() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 3825295789844957677L;

			@Override
			public void action() 
			{
				// TODO Auto-generated method stub
				collectionDist.put(title, new Integer(amount));
				logger.info(title + " inserted into catalogue. Amount: " + amount);
				
			}		
		});
	}
	
	private class OfferRequestsServer extends CyclicBehaviour 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -847916859154318443L;

		public void action() 
		{
			MessageTemplate mTemplate = MessageTemplate.MatchPerformative(ACLMessage.CFP);
			ACLMessage msg = myAgent.receive(mTemplate);
			if (msg != null) 
			{
				String title = msg.getContent();
				//Create an answer
				ACLMessage reply = msg.createReply();
				
				Integer amount = (Integer) collectionDist.get(title);
				if(amount != null) 
				{
					reply.setPerformative(ACLMessage.PROPOSE);
					reply.setContent(String.valueOf(amount.intValue()));
				}
				else 
				{
					//The requested item is not available from for manufacturing
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("not-available");
				}
				myAgent.send(reply); //send the answer to the manufacturer
			}
			else
			{
				block(); // block the request
			}
		}
	}
	
	private class PurchaseOrdersServer extends CyclicBehaviour {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void action() {
			// TODO Auto-generated method stub
			MessageTemplate mTemplate = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
			ACLMessage message = myAgent.receive(mTemplate);
			
			if (message != null) 
			{
				String title = message.getContent();
				ACLMessage reply = message.createReply();
				Integer priceOfPurchase = (Integer) collectionDist.remove(title);
				if(priceOfPurchase != null) 
				{
					reply.setPerformative(ACLMessage.INFORM);
					System.out.println(title + " distributed to agent " + message.getSender().getName());
				}
				else
				{
					// The requested item has not been available in the warehouse
					reply.setPerformative(ACLMessage.FAILURE );
					reply.setContent("not-available");
				}
				myAgent.send(reply);
			}
			else
			{
				block();
			}
			
		}
		
	}
}
