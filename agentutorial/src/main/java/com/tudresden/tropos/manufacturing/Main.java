package com.tudresden.tropos.manufacturing;

public class Main {

	//Class loader initialization
	//Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	
	//Log
	
	//Profile p = new ProfileImpl(); 
	//p.setParameter(Profile.MAIN_HOST, "localhost"); 
	//p.setParameter(Profile.MAIN_PORT, "3250");
	
	//The singleton instance (accessible through the instance() static method) of
	//this class allows controlling the JADE runtime system from an external application. 
	//Two different modalities of controlling the JADE runtime system exist:
	
	// 1) The singleton instance (accessible through the instance() static method) of this class allows controlling the
	//JADE runtime system from an external application. Two different modalities of controlling the JADE runtime system exist:
	
	// 2) Single-container: Only one container can be executed in the local JVM. 
	// This modality is activated by means of the startUp() and shutDown() methods

	//Runtime r = Runtime.instance(); 
	
	//Creates a new main container in the current JVM, providing access through a proxy object.
	//final ContainerController cc = r.createMainContainer(p);
	
	//Log
	//invokeLater (below)
	//Causes runnable to have its run method called in the dispatch thread of the system EventQueue. 
	//This will happen after all pending events are processed.

	//EventQueue is a platform-independent class that queues events, both from the underlying peer classes and from trusted
	//classes.
	//EventQueue.invokeLater(new Runnable() {
		//
		//Platform manager initiate 
		//PlatformManager platformManager = new PlatformManager(cc);
		//frame.setVisible(true);  //GUI Event structure
	//})
}
