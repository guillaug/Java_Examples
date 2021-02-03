package com.tudresden.jadeframework;

import jade.core.Agent;
import jade.util.leap.Iterator; 

public class HelloJade {
	public class HelloWorldAgent extends Agent {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void setup() {
			System.out.println("Hello World. I am an agent");
			System.out.println("My local-name is " + getAID().getLocalName());
			System.out.println("My GUID is " + getAID().getName());
			System.out.println("My addresses are: ");
			Iterator it = getAID().getAllAddresses();
			while(it.hasNext()) {
				System.out.println("- " + it.next());
			}
			
			//Agent termination
			doDelete();
		}
	}
}
