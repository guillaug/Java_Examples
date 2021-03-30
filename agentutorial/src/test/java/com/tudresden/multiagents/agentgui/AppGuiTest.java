package com.tudresden.multiagents.agentgui;

import org.junit.Test;

import com.tudresden.jadeframework.Distributor;
import com.tudresden.jadeframework.DistributorGUI;

public class AppGuiTest {
	
	@Test 
	public void appGuiTestFunc() {
		Distributor myAgent = null; 
		DistributorGUI guiApp = new DistributorGUI(myAgent);
		guiApp.showGUI();
	}

}
