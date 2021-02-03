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
import javax.swing.SwingUtilities;


public class RetailerAgent {
	
	public final HashSet<DFAgentDescription> discoveryServiceList = new HashSet<DFAgentDescription>(); //Directory Facilitator
	public final HashMap<Retailer.RetailerSector, HashMap<Retailer, RetailerInfo>> identifiedStocks = new HashMap<Retailer.RetailerSector, HashMap<Retailer,RetailerInfo>>();
	private RetailerAgent agent = this; 
}
