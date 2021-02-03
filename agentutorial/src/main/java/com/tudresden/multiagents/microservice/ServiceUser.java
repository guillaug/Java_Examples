//package com.tudresden.multiagents.microservice;
//
//import jadex.bridge.IInternalAccess;
//import jadex.bridge.service.ServiceScope;
//import jadex.bridge.service.annotation.OnStart;
//import jadex.bridge.service.component.IRequiredServicesFeature;
//import jadex.bridge.service.search.ServiceQuery;
//import jadex.micro.annotation.Agent;
//
//
//
//// Simple agent that searches and uses the service
//
//@Agent
//public class ServiceUser {
//	//Access to the agent.
//	@Agent
//	protected IInternalAccess agent;
//	
//	@OnStart
//	public void sendLocalName()
//	{
//		IHelloService serviceHel = agent.getFeature(IRequiredServicesFeature.class)
//								 .searchLocalService(new ServiceQuery<>(IHelloService.class, ServiceScope.PLATFORM));
//		System.out.println(serviceHel.sayHello(agent.getId().getLocalName()));
//	}
//}
