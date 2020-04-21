package com.tu_dresden.blockchain;

import java.util.concurrent.Executors;

public class EthereumConfiguration {

	ConnectionEthereumJ ethConfig() throws Exception 
	{
		ConnectionEthereumJ connectEthereum = new ConnectionEthereumJ();
		Executors.newSingleThreadExecutor().submit(connectEthereum::start); // Single Thread Executor
		return null;
		
	}
}
