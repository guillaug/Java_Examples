package com.tudresden.multiagents.jadexagent;

import jadex.base.PlatformConfiguration;
import jadex.base.Starter;

public class MainJadex {
	
	public static void main(String[] args) {
		System.out.println("Hello Main Jadex App");
		PlatformConfiguration configuration = PlatformConfiguration.getDefault();
		configuration.addComponent(HelloJadex.class);
		Starter.createPlatform(configuration).get();
	}
}
