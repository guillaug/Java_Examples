package com.tudresden.jadeframework;

import java.util.logging.Logger;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;

public class ComplexBehaviorAgent extends Agent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3665739569260309858L;
	private static Logger logger = Logger.getLogger(ComplexBehaviorAgent.class.getName());
	class SingleStepBehavior extends OneShotBehaviour {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3640530520653563594L;
		private String myStep; 
		
		public SingleStepBehavior (Agent a, String step) {
			super(a);
			myStep = step;
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			logger.info("Agent" + getName() + ": Step " + myStep);
		}
	}
	
	protected void setup() {
		SequentialBehaviour myBehaviour = new SequentialBehaviour(this) {
			public int onEnd() {
				reset(); 
				return super.onEnd();
			}
		};
	    SequentialBehaviour behavior1 = new SequentialBehaviour(this);
	    SequentialBehaviour behavior2 = new SequentialBehaviour(this);
	    SequentialBehaviour behavior3 = new SequentialBehaviour(this);

	    behavior2.addSubBehaviour(new SingleStepBehavior(this, "2.1.1"));
	    behavior2.addSubBehaviour(new SingleStepBehavior(this, "2.1.2"));
	    behavior2.addSubBehaviour(new SingleStepBehavior(this, "2.1.3"));
	    behavior3.addSubBehaviour(new SingleStepBehavior(this, "2.2.1"));
	    behavior3.addSubBehaviour(new SingleStepBehavior(this, "2.2.2"));

	    Behaviour newBehavior = new SingleStepBehavior(this, ".2.2.3"); //semantic versioning
	    behavior3.addSubBehaviour(newBehavior);
	    myBehaviour.addSubBehaviour(new SingleStepBehavior(this, "1.1.0"));
	    myBehaviour.addSubBehaviour(new SingleStepBehavior(this, "1.1.1"));
	    myBehaviour.addSubBehaviour(new SingleStepBehavior(this, "1.1.2"));
	    addBehaviour(myBehaviour);
		
	}
}
