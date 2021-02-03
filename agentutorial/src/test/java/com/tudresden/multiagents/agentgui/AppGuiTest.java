package com.tudresden.multiagents.agentgui;

import org.junit.Test;

import com.tudresden.multiagents.distributors.*;

public class AppGuiTest {
	
	@Test 
	public void appGuiTestFunc() {
		Distributor myAgent = null; 
		DistributorGUI guiApp = new DistributorGUI(myAgent);
		guiApp.showGUI();
	}

}
