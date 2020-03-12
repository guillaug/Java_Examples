package com.tu_dresden.blockchain;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

//Logger library
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionWeb3 {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionWeb3.class.getName());
	private static Web3j web3_instance = null;
	
	public static Web3j getInstance() {
		if(web3_instance == null) {
			web3_instance = Web3j.build(new HttpService("http://localhost:8545"));
		}
		return web3_instance;
	}
    public static void connectionWeb3js() {
    	try {
    		  
        	  Web3j web3 = ConnectionWeb3.getInstance(); 
        	  if(web3 == null) throw new IllegalArgumentException();
        	  System.out.println("Successfuly connected to Ethereum local node");

    	      // web3_clientVersion returns the current client version.
    	      Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

    	      // eth_blockNumber returns the number of most recent block.
    	      EthBlockNumber blockNumber = web3.ethBlockNumber().send();

    	      // eth_gasPrice, returns the current price per gas in wei.
    	      EthGasPrice gasPrice = web3.ethGasPrice().send();    	
    	      
    	      logger.info("Client version: " + clientVersion.getWeb3ClientVersion());
    	      logger.info("Block number: " + blockNumber.getBlockNumber());
    	      logger.info("Gas price: " + gasPrice.getGasPrice());
    	    } 
    	catch(IOException ex) {
    		throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    	}
    }
    
    public static void setupAsyncSetup() throws IOException, InterruptedException, ExecutionException
    {
    	Web3j web3 = ConnectionWeb3.getInstance();
    	if(web3 == null) throw new IllegalArgumentException();
    	Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
    	String clientVersion = web3ClientVersion.getWeb3ClientVersion();
    	logger.info("async function client version: " + clientVersion);
    }

}
