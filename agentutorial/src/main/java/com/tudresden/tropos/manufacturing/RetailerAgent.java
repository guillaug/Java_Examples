package com.tudresden.tropos.manufacturing;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;


public class RetailerAgent {
	private static final Logger logger = Logger.getLogger(RetailerAgent.class.getName()	);
	public final HashSet<DFAgentDescription> discoveryServiceList = new HashSet<DFAgentDescription>(); //Directory Facilitator
	public final HashMap<Retailer.RetailerSector, HashMap<Retailer, RetailerInfo>> identifiedStocks = new HashMap<Retailer.RetailerSector, HashMap<Retailer,RetailerInfo>>();
	private RetailerAgent agent = this; 
	private RetailerView ui; 
	
	private final class UpdateFactoryLevel extends TickerBehaviour {

		public UpdateFactoryLevel(Agent a, long period) {
			super(a, period);
			// TODO Auto-generated constructor stub
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 3228602196743498318L;

		@Override
		protected void onTick() {
			// TODO Auto-generated method stub
			ServiceDescription serviceDescription = new ServiceDescription();
			serviceDescription.setType("FACTORY-LEVEL-DISCOVERY");
			DFAgentDescription dfAgentDescription = new DFAgentDescription();
			logger.info("dfAgentDescription: " + dfAgentDescription);
			dfAgentDescription.addServices(serviceDescription);
			try {
				DFAgentDescription[] result = DFService.search(this.myAgent, dfAgentDescription);
				//delete the list of holding and order level.
			} catch(FIPAException ex) {
				logger.severe("Exception message: " + ex);
			}
		}
		
		public class shutdownAgent extends OneShotBehaviour {

			@Override
			public void action() {
				// TODO Auto-generated method stub
//				agent.doDelete(); 
			}
			
		}
		
	}
	
	private final class FindManufacturingInformation extends SequentialBehaviour {
		private Set<DFAgentDescription> knownAgentBehaviours; 
		private Set<RetailerInfo> itemOffered = new HashSet<RetailerInfo>();
		private Set<RetailerInfo> itemToGet = new HashSet<RetailerInfo>();
		
//		this.ordering = ordering;
//		this.holding = holding;
//		this.shortage = shortage;

		public void FindManufacturingInformation(Retailer.RetailerSector _sector, float _ordering, float _holding, float _shortage) {
			knownAgentBehaviours = (HashSet<DFAgentDescription>) agent.discoveryServiceList.clone(); //assignDiscovery Service List
			super.addSubBehaviour(new class1(_sector, _ordering, _holding, _shortage));
			super.addSubBehaviour(new class2());
		}
		
		private class class1 extends OneShotBehaviour {
			private float maxOrdering;
			private float maxHolding; 
			private float maxShortage; 
			private final Retailer.RetailerSector sector; 
			public class1 (Retailer.RetailerSector _sector, float _maxOrdering, float _maxHolding, float _maxShortage) {
				this.sector = _sector; 
				this.maxOrdering = _maxOrdering; 
				this.maxHolding = _maxHolding;
				this.maxShortage = _maxShortage;
			}
			@Override
			public void action() {
				// TODO Auto-generated method stub
				logger.info("Sending the ordering-holding command to manufacturing agent");
				ACLMessage msg = new ACLMessage(ACLMessage.CFP);
				for(DFAgentDescription df : knownAgentBehaviours) {
					msg.addReceiver(df.getName()); //directory list names assigned to the ACL Messages -- Protocol Layer
				}
				try {
					msg.setContentObject(new RetailerInfo(maxOrdering, maxHolding, maxShortage));
					this.myAgent.send(msg);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		private class class2 extends SimpleBehaviour {

			@Override
			public void action() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean done() {
				// TODO Auto-generated method stub
				return false;
			}
			
		}
	}
}
