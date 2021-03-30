package com.tudresden.jadeframework;

import java.util.logging.Logger;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class FSMAgents extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FSMAgents.class.getName()); 
	//type all states as below
	private static final String STATE_A = "A"; 
	private static final String STATE_B = "B"; 
	private static final String STATE_C = "C";
	private static final String STATE_D = "D"; 
	private static final String STATE_E = "E"; 
	private static final String STATE_F = "F";
	
	protected void setup() {
		FSMBehaviour fsm = new FSMBehaviour(this) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public int onEnd() {
				logger.info("FSM Behavior completed");
				myAgent.doDelete();
				return super.onEnd();
			}
		}; 
		
		fsm.registerFirstState(new NamePrinter(), STATE_A);
		
		fsm.registerState(new NamePrinter(), STATE_B); 
		
//		fsm.deregisterState(new Name)
	}
	
	//Inner Class NamePrinter
	//Just printing names
	
	private class NamePrinter extends OneShotBehaviour {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void action() {
			System.out.println("Executing behaviour: " + getBehaviourName());
		}
	}
	
	private class RandomGenerator extends NamePrinter { //inner class inheritance
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int proportionateExitValue; 
		private int exitValue; 
		
		private RandomGenerator(int max) {
			super(); 
			proportionateExitValue = max; 
		}
		
		public void action() {
			logger.info("Executing behaviour: " + getBehaviourName());
			exitValue = (int) (Math.random() * proportionateExitValue);  //random value calculator
			logger.info("Exit value is: " + exitValue);
		}
		
		public int onEnd() {
			return exitValue; 
		}
	}
}
