//package com.tudresden.multiagents.microservice;
//
//
//import jadex.bridge.IInternalAccess;
//import jadex.bridge.service.ServiceScope;
//import jadex.bridge.service.annotation.OnStart;
//import jadex.bridge.service.annotation.Service;
//import jadex.bridge.service.component.IRequiredServicesFeature;
//import jadex.bridge.service.search.ServiceQuery;
//import jadex.microservice.annotation.Microservice;
//
//
//@Microservice
//@Service
//public class UserMicroservice {
//	
//	@OnStart
//	public void start(IInternalAccess component)
//	{
//		ISyncService syncI = component.getFeature(IRequiredServicesFeature.class).searchLocalService(new ServiceQuery<>(ISyncService.class, ServiceScope.PLATFORM));
//		IAsyncService asyncI = component.getFeature(IRequiredServicesFeature.class).searchLocalService(new ServiceQuery<>(IAsyncService.class, ServiceScope.PLATFORM));
//		System.out.println(syncI.sayHello("Agent A")+" "+asyncI.sayHello("Agent B").get());
//		System.out.println(syncI.sayHello("Agent C")+" "+asyncI.sayHello("Agent D").get());
//	}
//
//}
