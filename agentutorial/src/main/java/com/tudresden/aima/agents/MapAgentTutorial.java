package com.tudresden.aima.agents;

import java.util.logging.Logger;

import aima.core.agent.Agent;
import aima.core.agent.EnvironmentListener;
import aima.core.agent.impl.DynamicPercept;
import aima.core.agent.impl.SimpleEnvironmentView;
import aima.core.environment.map.*;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.UniformCostSearch;


public class MapAgentTutorial {
	private static final Logger logger = Logger.getLogger(MapAgentTutorial.class.getName());
	public static void main(String[] args) {
		ExtendableMap map = new ExtendableMap();
		SimplifiedRoadMapOfRomania.initMap(map);
		MapEnvironment env = new MapEnvironment(map);
		EnvironmentListener<Object, Object> envView = new SimpleEnvironmentView();
		env.addEnvironmentListener(envView);
		
		String agentLoc = SimplifiedRoadMapOfRomania.ARAD;  //static import
		String destination = SimplifiedRoadMapOfRomania.BUCHAREST; 
		logger.info("agentLoc: " + agentLoc);
		logger.info("destination: " + destination);
		
		SearchForActions<String, MoveToAction> search; 
		search = new AStarSearch<>(new GraphSearch<>(), MapFunctions.createSLDHeuristicFunction(destination, map));
		logger.info("search object is: " + search);
		
		Agent<DynamicPercept, MoveToAction> agent; 
		agent = new SimpleMapAgent(map, search, destination);
//		agent = new MapAgent(map, search, destination);
		env.addAgent(agent, agentLoc);
		env.stepUntilDone();
		envView.notify(search.getMetrics().toString());
	}
}
