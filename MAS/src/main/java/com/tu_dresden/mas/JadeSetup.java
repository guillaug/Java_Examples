package com.tu_dresden.mas;

import jade.core.Agent; // Library is not recognizable


public class JadeSetup extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void setup() {
		System.out.println("Hello World! My name is: " + getLocalName());
		doDelete();
	}
	
	public void doDelete() {
		System.gc();
	}
	
}


