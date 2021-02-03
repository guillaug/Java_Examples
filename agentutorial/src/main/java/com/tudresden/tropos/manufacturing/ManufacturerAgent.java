package com.tudresden.tropos.manufacturing;

import javax.sql.rowset.serial.SerialArray;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ManufacturerAgent extends Agent{
	
	private ManufacturerAgent agent = this; 
	private static final Logger logger = Logger.getLogger(ManufacturerAgent.class.getName());
	final private Set<RetailerAgent> retailerList = new HashSet<RetailerAgent>();
	private UIMaker ui;
	
	public UIMaker getUI() {
		return ui;
	}


	public void setup() {
		
		ServiceDescription serviceDescription = new ServiceDescription();
		serviceDescription.setType("MANUFACTURING");
		serviceDescription.setName(agent.getName());
		
		DFAgentDescription agentDescription = new DFAgentDescription();
		agentDescription.addServices(serviceDescription);
	
		try {
			DFService.register(this, agentDescription);
			logger.info("We are registering the agent: " + agent);
		} catch(FIPAException ex) {
			logger.info("No registration for an agent");
			ex.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				logger.info("Creating the Manufacturer UI");
				try {
//					ui = new UIMaker(agent);
					ui.setVisible(true); //set the UI
				} catch(Exception ex)
				{
					logger.info("We cannot create an UI" + logger);
				}
			}
		});
	}
	
	//Cyclic Behaviour : This behaviour stays active as long as its agent is alive and will be called repeatedly after every event. 
	//Quite useful to handle message reception
	private class CheckRetailerMessage extends CyclicBehaviour {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6422469507967710115L;

		@Override
		public void action() {
			logger.info("Waiting for the messages from the Retailer");
			ACLMessage msg = this.myAgent.receive();
			if(msg == null)
			{
				logger.info("The message of the behaviour is null");
				this.block();
				return;
			}
			
			try {
				Object contentObject = msg.getContentObject();
				if(contentObject.getClass().equals(Manufacturing.class)) {
//					agent.addBehaviour(agent.new OrderSearch());
				}
			} catch(Exception ex)
			{
				
			}
		}
	}
	
	private class OrderSearch extends OneShotBehaviour {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1895732600751152274L;
		public OrderSearch(ACLMessage message, RetailerInfo serialNumber) {
			super();
			this.message = message;
			this.serialNumber = serialNumber;
		}
		ACLMessage message;
		RetailerInfo serialNumber;
		@Override
		public void action() {
			// TODO Auto-generated method stub
			HashSet<RetailerAgent> returnedSearchList = new HashSet<RetailerAgent>();
			for(RetailerInfo retailer: agent.retailerList) {
				double retailerInfo = retailer.getHolding(); 
				
				
				returnedSearchList.add(retailer.clone());
			}
		} 
	}
	
	public class AddOrderingLevel extends OneShotBehaviour {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5571426728312051585L;
		private RetailerAgent ID;
		
		public AddOrderingLevel(RetailerAgent ID) {
			// TODO Auto-generated constructor stub
			this.ID = ID;
		}
		@Override
		public void action() {
			// TODO Auto-generated method stub
			agent.retailerList.add(ID);
		}
		
	}
	
	public class RemoveOrderingLevel extends OneShotBehaviour {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3923663102118102638L;
		private RetailerAgent ID;
		
		public RemoveOrderingLevel(RetailerAgent ID) {
			// TODO Auto-generated constructor stub
			this.ID = ID;
		}
		@Override
		public void action() {
			// TODO Auto-generated method stub
			agent.retailerList.remove(ID);
		}
	}
	
	public class ShutdownAgent extends OneShotBehaviour {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5742602393565651418L;
		@Override
		public void action() {
			try {
				DFService.deregister(agent);
			} catch(FIPAException ex)
			{
				logger.severe("Agent cannot be unregistered from the Directory Facility");
			}
		}
	}
	
}
