package com.tu_dresden.akka;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.http.javadsl.server.HttpApp;
import akka.http.javadsl.server.Route;
import scala.concurrent.duration.Duration;
import akka.util.Timeout;

public class RoleActivator extends HttpApp{

	private final ActorRef roleActor;
	
	Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));

	@Override
	protected Route routes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RoleActivator(ActorRef roleActor)
	{
		this.roleActor = roleActor;
	}
}
