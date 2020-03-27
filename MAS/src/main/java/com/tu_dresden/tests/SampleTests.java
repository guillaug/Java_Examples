package com.tu_dresden.tests;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.gateway.ContractException;
import org.junit.Assert;

import com.tu_dresden.blockchain.*;


public class SampleTests {
	
	@Test
	public void connectionHyperledgerTest() throws ContractException, IOException, TimeoutException, InterruptedException {
		Assert.assertTrue(ConnectionFabric.ConnectFabric());
	}
}
