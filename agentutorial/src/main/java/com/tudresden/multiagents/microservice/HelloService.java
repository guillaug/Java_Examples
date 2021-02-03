//package com.tudresden.multiagents.microservice;
//
//import jadex.bridge.service.IServiceIdentifier;
//import jadex.bridge.service.annotation.ServiceComponent;
//import jadex.bridge.service.annotation.ServiceIdentifier;
//import jadex.commons.future.IFuture;
//import jadex.platform.service.componentregistry.IHelloService;
//import jadex.bridge.IInternalAccess;
//
//
//public class HelloService implements IHelloService{
//
//	// Access to hosting components	
//	@ServiceComponent
//	protected IInternalAccess comparator;
//	
//	//Access to the service id
//	@ServiceIdentifier
//	protected IServiceIdentifier serviceId;
//
//	@Override
//	public IFuture<String> sayHello(String name) {
//		// TODO Auto-generated method stub
//		return null; // we should return a string value
//	}
//	
//	
//	
//}
