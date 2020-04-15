package com.tu_dresden.tests;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.gateway.ContractException;
import org.junit.Assert;

import com.tu_dresden.blockchain.*;


public class TestsSample {
	
	@Test
	public void connectionHyperledgerTest() throws ContractException, IOException, TimeoutException, InterruptedException {
		Assert.assertFalse(ConnectionFabric.ConnectFabric());
	}
	
	@Test
	public void connectionWeb3J() throws InterruptedException, ExecutionException {
		Assert.assertTrue(ConnectionWeb3.connectionWeb3js());
	}
	
	@Test
	public void makeTransaction() throws IOException, InterruptedException {
		Assert.assertTrue(ConnectionWeb3.makeTransaction());
	}
}
